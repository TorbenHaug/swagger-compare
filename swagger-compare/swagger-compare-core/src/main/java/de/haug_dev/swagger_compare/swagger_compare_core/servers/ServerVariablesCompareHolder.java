package de.haug_dev.swagger_compare.swagger_compare_core.servers;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.servers.ServerVariables;

public class ServerVariablesCompareHolder extends AbstractCompareHolder<ServerVariables> {

    private CompareHolderFactory compareHolderFactory;

    public ServerVariablesCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(ServerVariables left, ServerVariables right, CompareCriticalType created, CompareCriticalType deleted) {
        ServerVariables leftValue = left == null ? new ServerVariables() : left;
        ServerVariables rightValue = right == null ? new ServerVariables() : right;

        ServerVariableCompareHolder serverVariableCompareHolder = compareHolderFactory.getServerVariableCompareHolder();
        return this.referableCompare(leftValue, rightValue, serverVariableCompareHolder, created, deleted);
    }
}
