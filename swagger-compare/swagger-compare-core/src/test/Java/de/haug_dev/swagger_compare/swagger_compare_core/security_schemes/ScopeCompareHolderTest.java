package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
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

        spyScopesCompareHolder.compare(leftValue, rightValue);

        verify(spyScopesCompareHolder).leafCompare(eq(leftValue), eq(rightValue), CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
    }
}