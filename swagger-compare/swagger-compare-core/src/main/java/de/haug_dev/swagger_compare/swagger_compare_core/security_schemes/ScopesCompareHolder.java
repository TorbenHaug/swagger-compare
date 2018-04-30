package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.security.Scopes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScopesCompareHolder extends AbstractCompareHolder<Scopes> {

    private ScopeCompareHolder scopeCompareHolder;

    @Autowired
    public ScopesCompareHolder(ScopeCompareHolder scopeCompareHolder) {
        this.scopeCompareHolder = scopeCompareHolder;
    }

    @Override
    public ICompareResult compare(Scopes left, Scopes right) {
        Scopes leftValue = left == null ? new Scopes() : left;
        Scopes rightValue = right == null ? new Scopes() : right;
        return this.referableCompare(leftValue,rightValue, scopeCompareHolder);
    }
}
