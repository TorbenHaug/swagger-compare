package de.haug_dev.swagger_compare.swagger_compare_core.servers;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.servers.ServerVariable;
import io.swagger.v3.oas.models.servers.ServerVariables;

import java.util.Map;

public class ServerVariablesCompareHolder extends AbstractCompareHolder<Map<String, ServerVariable>> {

    private CompareHolderFactory compareHolderFactory;

    public ServerVariablesCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Map<String, ServerVariable> left, Map<String, ServerVariable> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, ServerVariable> leftValue = left == null ? new ServerVariables() : left;
        Map<String, ServerVariable> rightValue = right == null ? new ServerVariables() : right;

        ServerVariableCompareHolder serverVariableCompareHolder = compareHolderFactory.getServerVariableCompareHolder();
        return this.referableCompare(leftValue, rightValue, serverVariableCompareHolder, created, deleted);
    }
}
