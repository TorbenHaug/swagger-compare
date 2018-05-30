package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.callbacks.CallbacksCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.examples.ExamplesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.headers.HeadersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.links.LinksCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParametersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.request_bodies.RequestBodiesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.responses.ResponsesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.schemas.SchemasCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.security_schemes.SecuritySchemesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.Components;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class ComponentsCompareHolder extends AbstractCompareHolder<Components> {

    private CompareHolderFactory compareHolderFactory;

    public ComponentsCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Components left, Components right, CompareCriticalType created, CompareCriticalType deleted) {
        Components leftValue = left == null ? new Components() : left;
        Components rightValue = right == null ? new Components() : right;

        SchemasCompareHolder schemasCompareHolder = compareHolderFactory.getSchemasCompareHolder();
        ResponsesCompareHolder responsesCompareHolder = compareHolderFactory.getResponsesCompareHolder();
        ParametersCompareHolder parametersCompareHolder = compareHolderFactory.getParametersCompareHolder();
        ExamplesCompareHolder examplesCompareHolder = compareHolderFactory.getExamplesCompareHolder();
        RequestBodiesCompareHolder requestBodiesCompareHolder = compareHolderFactory.getRequestBodiesCompareHolder();
        HeadersCompareHolder headersCompareHolder = compareHolderFactory.getHeadersCompareHolder();
        SecuritySchemesCompareHolder securitySchemesCompareHolder = compareHolderFactory.getSecuritySchemesCompareHolder();
        LinksCompareHolder linksCompareHolder = compareHolderFactory.getLinksCompareHolder();
        CallbacksCompareHolder callbacksCompareHolder = compareHolderFactory.getCallbacksCompareHolder();

        NodeCompareResult result = new NodeCompareResult(created, deleted);

        this.nodeCompare(leftValue.getSchemas(), rightValue.getSchemas(), "Schemas", schemasCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getResponses(), rightValue.getResponses(), "Responses", responsesCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        parametersCompareHolder.setNormalizedParameterNames(new DualHashBidiMap<>(), new DualHashBidiMap<>());
        this.nodeCompare(leftValue.getParameters(), rightValue.getParameters(), "Parameters", parametersCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getExamples(), rightValue.getExamples(), "Examples", examplesCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getRequestBodies(), rightValue.getRequestBodies(), "RequestBodies", requestBodiesCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getHeaders(), rightValue.getHeaders(), "Headers", headersCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getSecuritySchemes(), rightValue.getSecuritySchemes(), "SecuritySchemes", securitySchemesCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getLinks(), rightValue.getLinks(), "Links", linksCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getCallbacks(), rightValue.getCallbacks(), "Callbacks", callbacksCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        return result;
    }
}
