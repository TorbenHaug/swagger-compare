package de.haug_dev.swagger_compare.swagger_compare_core.paths;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_core.callbacks.CallbacksCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.misc.ExternalDocumentationObjectCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.misc.TagsCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParametersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.request_bodies.RequestBodyCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.responses.ResponsesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.security_schemes.SecuritiesRequirementObjectCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.servers.ServersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OperationCompareHolder extends AbstractCompareHolder<Operation> {

    private static Logger LOG = Logger.getLogger(OperationCompareHolder.class);

    private BidiMap<String, String> normalizedParameterNamesLeft = new DualHashBidiMap<>();
    private BidiMap<String, String> normalizedParameterNamesRight = new DualHashBidiMap<>();
    private CompareHolderFactory compareHolderFactory;

    public OperationCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    public void setNormalizedParameterNames(BidiMap<String, String> normalizedParameterNamesLeft, BidiMap<String, String> normalizedParameterNamesRight) {
        this.normalizedParameterNamesLeft = normalizedParameterNamesLeft == null ? new DualHashBidiMap<>() : normalizedParameterNamesLeft;
        this.normalizedParameterNamesRight = normalizedParameterNamesRight == null ? new DualHashBidiMap<>() : normalizedParameterNamesRight;
    }

    @Override
    public ICompareResult compare(Operation left, Operation right, CompareCriticalType created, CompareCriticalType deleted) {
        Operation leftValue = left == null ? new Operation() : left;
        Operation rightValue = right == null ? new Operation() : right;

        TagsCompareHolder tagsCompareHolder = compareHolderFactory.getTagsCompareHolder();
        ExternalDocumentationObjectCompareHolder externalDocumentationObjectCompareHolder = compareHolderFactory.getExternalDocumentationObjectCompareHolder();
        ParametersCompareHolder parametersCompareHolder = compareHolderFactory.getParametersCompareHolder();
        RequestBodyCompareHolder requestBodyCompareHolder = compareHolderFactory.getRequestBodyCompareHolder();
        ResponsesCompareHolder responsesCompareHolder = compareHolderFactory.getResponsesCompareHolder();
        CallbacksCompareHolder callbacksCompareHolder = compareHolderFactory.getCallbacksCompareHolder();
        ServersCompareHolder serversCompareHolder = compareHolderFactory.getServersCompareHolder();
        SecuritiesRequirementObjectCompareHolder securitiesRequirementObjectCompareHolder = compareHolderFactory.getSecuritiesRequirementObjectCompareHolder();

        NodeCompareResult result = new NodeCompareResult(created, deleted);
        this.nodeCompare(leftValue.getTags(), rightValue.getTags(), "Tags", tagsCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.INFO);
        this.leafCompare(leftValue.getSummary(), rightValue.getSummary(), "Summary", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO, CompareCriticalType.INFO, result);
        this.leafCompare(leftValue.getDescription(), rightValue.getDescription(), "Description", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO, CompareCriticalType.INFO, result);
        this.nodeCompare(leftValue.getExternalDocs(), rightValue.getExternalDocs(), "ExternalDocs", externalDocumentationObjectCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.INFO);
        this.leafCompare(leftValue.getOperationId(), rightValue.getOperationId(), "OperationId", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, result);
        Map<String, Parameter> parametersLeft = new HashMap<>();
        if (leftValue.getParameters() != null) {
            leftValue.getParameters().forEach((v) -> {
                String normalizedName = normalizedParameterNamesLeft.getKey(v.getName());
                String name = (normalizedName == null) ? v.getName() : ("path".equals(v.getIn()) ? normalizedName : v.getName());
                parametersLeft.put(v.getIn() + ":" + name, v);
            });
        }
        Map<String, Parameter> parametersRight = new HashMap<>();
        if (rightValue.getParameters() != null) {
            rightValue.getParameters().forEach((v) -> {
                String normalizedName = normalizedParameterNamesRight.getKey(v.getName());
                String name = (normalizedName == null) ? v.getName() : ("path".equals(v.getIn()) ? normalizedName : v.getName());
                parametersRight.put(v.getIn() + ":" + name, v);
            });
        }
        parametersCompareHolder.setNormalizedParameterNames(normalizedParameterNamesLeft, normalizedParameterNamesRight);
        this.nodeCompare(parametersLeft, parametersRight, "Parameters", parametersCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getRequestBody(), rightValue.getRequestBody(), "RequestBody", requestBodyCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getResponses(), rightValue.getResponses(), "Responses", responsesCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getCallbacks(), rightValue.getCallbacks(), "Callbacks", callbacksCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        if (!(leftValue.getDeprecated() == null && rightValue.getDeprecated() == null)) {
            LeafCompareResult deprecatedResult = null;
            Boolean leftDeprecated = leftValue.getDeprecated();
            Boolean rightDeprecated = rightValue.getDeprecated();
            if (Objects.equals(leftDeprecated, rightDeprecated)) {
                deprecatedResult = new LeafCompareResult(leftDeprecated, rightDeprecated, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
            } else if (leftDeprecated != null && rightDeprecated == null) {
                deprecatedResult = new LeafCompareResult(leftDeprecated, rightDeprecated, CompareResultType.DELETED, CompareCriticalType.NONE);
            } else if (leftDeprecated == null && rightDeprecated != null && rightDeprecated.equals(Boolean.TRUE)) {
                deprecatedResult = new LeafCompareResult(leftDeprecated, rightDeprecated, CompareResultType.CREATED, CompareCriticalType.WARNING);
            } else if (leftDeprecated == null && rightDeprecated != null && rightDeprecated.equals(Boolean.FALSE)) {
                deprecatedResult = new LeafCompareResult(leftDeprecated, rightDeprecated, CompareResultType.CREATED, CompareCriticalType.NONE);
            } else if (leftDeprecated != null && leftDeprecated.equals(Boolean.TRUE) && rightDeprecated != null && rightDeprecated.equals(Boolean.FALSE)) {
                deprecatedResult = new LeafCompareResult(leftDeprecated, rightDeprecated, CompareResultType.CHANGED, CompareCriticalType.NONE);
            } else if (leftDeprecated != null && leftDeprecated.equals(Boolean.FALSE) && rightDeprecated != null && rightDeprecated.equals(Boolean.TRUE)) {
                deprecatedResult = new LeafCompareResult(leftDeprecated, rightDeprecated, CompareResultType.CHANGED, CompareCriticalType.WARNING);
            } else {
                LOG.error("Deprecated has an unknown state! Left: " + leftDeprecated + ", Right: " + rightDeprecated);
                deprecatedResult = new LeafCompareResult(leftDeprecated, rightDeprecated, CompareResultType.CHANGED, CompareCriticalType.CRITICAL);
            }
            result.put("Deprecated", deprecatedResult);
        }
        this.nodeCompare(leftValue.getSecurity(), rightValue.getSecurity(), "Security", securitiesRequirementObjectCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getServers(), rightValue.getServers(), "Servers", serversCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        return result;
    }
}
