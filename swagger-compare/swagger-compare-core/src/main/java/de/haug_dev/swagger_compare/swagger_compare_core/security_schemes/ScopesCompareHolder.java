package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.security.Scopes;

public class ScopesCompareHolder extends AbstractCompareHolder<Scopes> {

    private CompareHolderFactory compareHolderFactory;

    public ScopesCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Scopes left, Scopes right, CompareCriticalType created, CompareCriticalType deleted) {
        Scopes leftValue = left == null ? new Scopes() : left;
        Scopes rightValue = right == null ? new Scopes() : right;

        ScopeCompareHolder scopeCompareHolder = compareHolderFactory.getScopeCompareHolder();

        return this.referableCompare(leftValue, rightValue, scopeCompareHolder, created, deleted);
    }
}
