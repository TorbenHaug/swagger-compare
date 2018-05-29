package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class ScopeCompareHolderTest {

    @Test
    public void compareValueValue() {
        String leftValue = "left";
        String rightValue = "right";

        ScopeCompareHolder scopesCompareHolder = new ScopeCompareHolder();
        ScopeCompareHolder spyScopesCompareHolder = spy(scopesCompareHolder);

        spyScopesCompareHolder.compare(leftValue, rightValue, CompareCriticalType.INFO, CompareCriticalType.WARNING);

        verify(spyScopesCompareHolder).leafCompare(eq(leftValue), eq(rightValue), eq(CompareCriticalType.NONE), eq(CompareCriticalType.INFO), eq(CompareCriticalType.WARNING), eq(CompareCriticalType.CRITICAL));
    }
}