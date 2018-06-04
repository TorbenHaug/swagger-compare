package de.haug_dev.swagger_compare.swagger_compare_core.servers;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.stereotype.Component;

import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.CRITICAL;
import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.INFO;
import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.NONE;

@Component
public class ServerCompareHolder extends AbstractCompareHolder<Server> {
    private CompareHolderFactory compareHolderFactory;

    public ServerCompareHolder(CompareHolderFactory compareHolderFactory){
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Server left, Server right, CompareCriticalType created, CompareCriticalType deleted) {
        Server leftValue = left == null ? new Server() : left;
        Server rightValue = right == null ? new Server() : right;

        NodeCompareResult result = new NodeCompareResult(created, deleted);

        this.leafCompare(leftValue.getUrl(), rightValue.getUrl(), "Url", NONE, CRITICAL, CRITICAL, CRITICAL, result);
        this.leafCompare(leftValue.getDescription(), rightValue.getDescription(), "Description", NONE, INFO, INFO, INFO, result);
        ServerVariablesCompareHolder serverVariablesCompareHolder = compareHolderFactory.getServerVariablesCompareHolder();
        this.nodeCompare(leftValue.getVariables(), rightValue.getVariables(), "Variables", serverVariablesCompareHolder, result, CRITICAL, CRITICAL);

        return result;
    }
}
