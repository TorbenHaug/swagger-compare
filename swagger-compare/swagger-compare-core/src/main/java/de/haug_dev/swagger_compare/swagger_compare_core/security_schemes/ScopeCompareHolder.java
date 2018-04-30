package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import org.springframework.stereotype.Component;

@Component
public class ScopeCompareHolder extends AbstractCompareHolder<String> {
    @Override
    public ICompareResult compare(String left, String right) {
        return this.leafCompare(left, right, CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
    }
}
