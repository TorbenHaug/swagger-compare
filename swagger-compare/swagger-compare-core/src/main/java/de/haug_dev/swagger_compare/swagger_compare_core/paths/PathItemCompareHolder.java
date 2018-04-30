package de.haug_dev.swagger_compare.swagger_compare_core.paths;

import de.haug_dev.swagger_compare.swagger_compare_core.*;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParametersCompareHolder;
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
    private final RefCompareHolder refCompareHolder;
    private final SummaryCompareHolder summaryCompareHolder;
    private DescriptionCompareHolder descriptionCompareHolder;
    private final OperationCompareHolder operationCompareHolder;
    private final ServersCompareHolder serversCompareHolder;
    private final ParametersCompareHolder parametersCompareHolder;

    @Autowired
    public PathItemCompareHolder(
            RefCompareHolder refCompareHolder,
            SummaryCompareHolder summaryCompareHolder,
            DescriptionCompareHolder descriptionCompareHolder,
            OperationCompareHolder operationCompareHolder,
            ServersCompareHolder serversCompareHolder,
            ParametersCompareHolder parametersCompareHolder){
        this.refCompareHolder = refCompareHolder;
        this.summaryCompareHolder = summaryCompareHolder;
        this.descriptionCompareHolder = descriptionCompareHolder;
        this.operationCompareHolder = operationCompareHolder;
        this.serversCompareHolder = serversCompareHolder;
        this.parametersCompareHolder = parametersCompareHolder;
    }

    public void setNormalizedParameterNames(BidiMap<String, String> normalizedParameterNamesLeft, BidiMap<String, String> normalizedParameterNamesRight) {
        this.normalizedParameterNamesLeft = normalizedParameterNamesLeft;
        this.normalizedParameterNamesRight = normalizedParameterNamesRight;
    }

    @Override
    public ICompareResult compare(PathItem left, PathItem right) {
        NodeCompareResult result = new NodeCompareResult();
        PathItem pathItemLeft = left == null ? new PathItem() : left;
        PathItem pathItemRight = right == null ? new PathItem() : right;
        this.nodeCompare(pathItemLeft.get$ref(), pathItemRight.get$ref(), "Ref", refCompareHolder, result);
        this.nodeCompare(pathItemLeft.getSummary(), pathItemRight.getSummary(), "Summary", summaryCompareHolder, result);
        this.nodeCompare(pathItemLeft.getDescription(), pathItemRight.getDescription(), "Description", descriptionCompareHolder, result);
        this.nodeCompare(pathItemLeft.getGet(), pathItemRight.getGet(), "Get", operationCompareHolder, result);
        this.nodeCompare(pathItemLeft.getPut(), pathItemRight.getPut(), "Put", operationCompareHolder, result);
        this.nodeCompare(pathItemLeft.getPost(), pathItemRight.getPost(), "Post", operationCompareHolder, result);
        this.nodeCompare(pathItemLeft.getDelete(), pathItemRight.getDelete(), "Delete", operationCompareHolder, result);
        this.nodeCompare(pathItemLeft.getOptions(), pathItemRight.getOptions(), "Options", operationCompareHolder, result);
        this.nodeCompare(pathItemLeft.getHead(), pathItemRight.getHead(), "Head", operationCompareHolder, result);
        this.nodeCompare(pathItemLeft.getPatch(), pathItemRight.getPatch(), "Patch", operationCompareHolder, result);
        this.nodeCompare(pathItemLeft.getTrace(), pathItemRight.getTrace(), "Trace", operationCompareHolder, result);

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
        this.nodeCompare(serversLeft, serversRight, "Servers", serversCompareHolder, result);

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
        this.nodeCompare(parametersLeft, parametersRight, "Parameters", parametersCompareHolder, result);
        return result;
    }
}