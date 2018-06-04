package de.haug_dev.swagger_compare.swagger_compare_core.servers;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.servers.ServerVariable;

import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.*;

public class ServerVariableCompareHolder extends AbstractCompareHolder<ServerVariable> {

    @Override
    public ICompareResult compare(ServerVariable left, ServerVariable right, CompareCriticalType created, CompareCriticalType deleted) {
        ServerVariable leftValue = left == null ? new ServerVariable() : left;
        ServerVariable rightValue = right == null ? new ServerVariable() : right;
        NodeCompareResult result = new NodeCompareResult(created, deleted);

        this.leafCompare(leftValue.getEnum(), rightValue.getEnum(), "Enum", NONE, CRITICAL, CRITICAL, CRITICAL, result);
        this.leafCompare(leftValue.getDefault(), rightValue.getDefault(), "Default", NONE, CRITICAL, CRITICAL, CRITICAL, result);
        this.leafCompare(leftValue.getDescription(), rightValue.getDescription(), "Description", NONE, INFO, INFO, INFO, result);

        return result;
    }
}
