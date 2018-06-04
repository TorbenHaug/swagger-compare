package de.haug_dev.swagger_compare.swagger_compare_core.paths;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParametersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.servers.ServersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class PathItemCompareHolder extends AbstractCompareHolder<PathItem> {

    private static Logger LOG = LoggerFactory.getLogger(PathItemCompareHolder.class);

    private BidiMap<String, String> normalizedParameterNamesLeft = new DualHashBidiMap<>();
    private BidiMap<String, String> normalizedParameterNamesRight = new DualHashBidiMap<>();
    private CompareHolderFactory compareHolderFactory;

    public PathItemCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    public void setNormalizedParameterNames(BidiMap<String, String> normalizedParameterNamesLeft, BidiMap<String, String> normalizedParameterNamesRight) {
        this.normalizedParameterNamesLeft = normalizedParameterNamesLeft;
        this.normalizedParameterNamesRight = normalizedParameterNamesRight;
    }

    @Override
    public ICompareResult compare(PathItem left, PathItem right, CompareCriticalType created, CompareCriticalType deleted) {
        NodeCompareResult result = new NodeCompareResult(created, deleted);
        PathItem pathItemLeft = left == null ? new PathItem() : left;
        PathItem pathItemRight = right == null ? new PathItem() : right;

        OperationCompareHolder operationCompareHolderGet = compareHolderFactory.getOperationCompareHolder();
        OperationCompareHolder operationCompareHolderPut = compareHolderFactory.getOperationCompareHolder();
        OperationCompareHolder operationCompareHolderPost = compareHolderFactory.getOperationCompareHolder();
        OperationCompareHolder operationCompareHolderDelete = compareHolderFactory.getOperationCompareHolder();
        OperationCompareHolder operationCompareHolderOptions = compareHolderFactory.getOperationCompareHolder();
        OperationCompareHolder operationCompareHolderHead = compareHolderFactory.getOperationCompareHolder();
        OperationCompareHolder operationCompareHolderPatch = compareHolderFactory.getOperationCompareHolder();
        OperationCompareHolder operationCompareHolderTrace = compareHolderFactory.getOperationCompareHolder();
        ServersCompareHolder serversCompareHolder = compareHolderFactory.getServersCompareHolder();
        ParametersCompareHolder parametersCompareHolder = compareHolderFactory.getParametersCompareHolder();

        this.leafCompare(pathItemLeft.get$ref(), pathItemRight.get$ref(), "Ref", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, result);
        this.leafCompare(pathItemLeft.getSummary(), pathItemRight.getSummary(), "Summary", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO, CompareCriticalType.INFO, result);
        this.leafCompare(pathItemLeft.getDescription(), pathItemRight.getDescription(), "Description", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO, CompareCriticalType.INFO, result);
        operationCompareHolderGet.setNormalizedParameterNames(normalizedParameterNamesLeft, normalizedParameterNamesRight);
        this.nodeCompare(pathItemLeft.getGet(), pathItemRight.getGet(), "Get", operationCompareHolderGet, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        operationCompareHolderPut.setNormalizedParameterNames(normalizedParameterNamesLeft, normalizedParameterNamesRight);
        this.nodeCompare(pathItemLeft.getPut(), pathItemRight.getPut(), "Put", operationCompareHolderPut, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        operationCompareHolderPost.setNormalizedParameterNames(normalizedParameterNamesLeft, normalizedParameterNamesRight);
        this.nodeCompare(pathItemLeft.getPost(), pathItemRight.getPost(), "Post", operationCompareHolderPost, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        operationCompareHolderDelete.setNormalizedParameterNames(normalizedParameterNamesLeft, normalizedParameterNamesRight);
        this.nodeCompare(pathItemLeft.getDelete(), pathItemRight.getDelete(), "Delete", operationCompareHolderDelete, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        operationCompareHolderOptions.setNormalizedParameterNames(normalizedParameterNamesLeft, normalizedParameterNamesRight);
        this.nodeCompare(pathItemLeft.getOptions(), pathItemRight.getOptions(), "Options", operationCompareHolderOptions, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        operationCompareHolderHead.setNormalizedParameterNames(normalizedParameterNamesLeft, normalizedParameterNamesRight);
        this.nodeCompare(pathItemLeft.getHead(), pathItemRight.getHead(), "Head", operationCompareHolderHead, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        operationCompareHolderPatch.setNormalizedParameterNames(normalizedParameterNamesLeft, normalizedParameterNamesRight);
        this.nodeCompare(pathItemLeft.getPatch(), pathItemRight.getPatch(), "Patch", operationCompareHolderPatch, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        operationCompareHolderTrace.setNormalizedParameterNames(normalizedParameterNamesLeft, normalizedParameterNamesRight);
        this.nodeCompare(pathItemLeft.getTrace(), pathItemRight.getTrace(), "Trace", operationCompareHolderTrace, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(pathItemLeft.getServers(), pathItemRight.getServers(), "Servers", serversCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        parametersCompareHolder.setNormalizedParameterNames(normalizedParameterNamesLeft, normalizedParameterNamesRight);
        Map<String, Parameter> parametersLeft = parametersCompareHolder.listToMapLeft(pathItemLeft.getParameters());
        Map<String, Parameter> parametersRight = parametersCompareHolder.listToMapRight(pathItemRight.getParameters());
        this.nodeCompare(parametersLeft, parametersRight, "Parameters", parametersCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        return result;
    }
}
