package de.haug_dev.swagger_compare.swagger_compare_core.paths;

import de.haug_dev.swagger_compare.swagger_compare_core.*;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParametersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.servers.Server;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PathItemCompareHolder extends AbstractCompareHolder<PathItem> {
    private BidiMap<String, String> normalizedParameterNamesLeft = new DualHashBidiMap<>();
    private BidiMap<String, String> normalizedParameterNamesRight = new DualHashBidiMap<>();
    private final OperationCompareHolder operationCompareHolder;
    private final ServersCompareHolder serversCompareHolder;
    private final ParametersCompareHolder parametersCompareHolder;

    @Autowired
    public PathItemCompareHolder(
            OperationCompareHolder operationCompareHolder,
            ServersCompareHolder serversCompareHolder,
            ParametersCompareHolder parametersCompareHolder){
        this.operationCompareHolder = operationCompareHolder;
        this.serversCompareHolder = serversCompareHolder;
        this.parametersCompareHolder = parametersCompareHolder;
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
        this.leafCompare(pathItemLeft.get$ref(), pathItemRight.get$ref(), "Ref", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL,CompareCriticalType.CRITICAL, result);
        this.leafCompare(pathItemLeft.getSummary(), pathItemRight.getSummary(), "Summary", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO,CompareCriticalType.INFO, result);
        this.leafCompare(pathItemLeft.getDescription(), pathItemRight.getDescription(), "Description", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO,CompareCriticalType.INFO, result);
        this.nodeCompare(pathItemLeft.getGet(), pathItemRight.getGet(), "Get", operationCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(pathItemLeft.getPut(), pathItemRight.getPut(), "Put", operationCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(pathItemLeft.getPost(), pathItemRight.getPost(), "Post", operationCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(pathItemLeft.getDelete(), pathItemRight.getDelete(), "Delete", operationCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(pathItemLeft.getOptions(), pathItemRight.getOptions(), "Options", operationCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(pathItemLeft.getHead(), pathItemRight.getHead(), "Head", operationCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(pathItemLeft.getPatch(), pathItemRight.getPatch(), "Patch", operationCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(pathItemLeft.getTrace(), pathItemRight.getTrace(), "Trace", operationCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        Map<String, Server> serversLeft = new HashMap<>();
        if(pathItemLeft.getServers() != null) {
            pathItemLeft.getServers().forEach((v) -> {
                serversLeft.put(v.getUrl(), v);
            });
        }
        Map<String, Server> serversRight = new HashMap<>();
        if(pathItemRight.getServers() != null) {
            pathItemRight.getServers().forEach((v) -> {
                serversRight.put(v.getUrl(), v);
            });
        }
        this.nodeCompare(serversLeft, serversRight, "Servers", serversCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        Map<String, Parameter> parametersLeft = new HashMap<>();
        if(pathItemLeft.getParameters() != null) {
            pathItemLeft.getParameters().forEach((v) -> {
                String normalizedName = normalizedParameterNamesLeft.getKey(v.getName());
                String name = normalizedName == null ? v.getName() : normalizedName;
                parametersLeft.put(name, v);
            });
        }
        Map<String, Parameter> parametersRight = new HashMap<>();
        if(pathItemRight.getParameters() != null) {
            pathItemRight.getParameters().forEach((v) -> {
                String normalizedName = normalizedParameterNamesRight.getKey(v.getName());
                String name = normalizedName == null ? v.getName() : normalizedName;
                parametersRight.put(name, v);
            });
        }
        parametersCompareHolder.setNormalizedParameterNames(normalizedParameterNamesLeft, normalizedParameterNamesRight);
        this.nodeCompare(parametersLeft, parametersRight, "Parameters", parametersCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        return result;
    }
}
