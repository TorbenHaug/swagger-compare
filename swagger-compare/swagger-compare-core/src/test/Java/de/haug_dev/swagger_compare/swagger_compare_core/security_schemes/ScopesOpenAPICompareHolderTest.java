package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.security.Scopes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ScopesOpenAPICompareHolderTest {

    @Test
    public void compareNullNull() {
        Scopes leftValue = null;
        Scopes rightValue = null;

        ScopeCompareHolder scopeCompareHolder = mock(ScopeCompareHolder.class);
        when(scopeCompareHolder.compare(any(), any(), any(), any())).thenReturn(new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL));

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getScopeCompareHolder()).thenReturn(scopeCompareHolder);

        ScopesCompareHolder scopesCompareHolder = new ScopesCompareHolder(compareHolderFactory);
        ScopesCompareHolder spyScopesCompareHolder = spy(scopesCompareHolder);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        ICompareResult actual = spyScopesCompareHolder.compare(leftValue, rightValue, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareValueValue() {
        Scopes leftValue = mock(Scopes.class);
        Scopes rightValue = mock(Scopes.class);

        ScopeCompareHolder scopeCompareHolder = mock(ScopeCompareHolder.class);
        when(scopeCompareHolder.compare(any(), any(), any(), any())).thenReturn(new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL));

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getScopeCompareHolder()).thenReturn(scopeCompareHolder);

        ScopesCompareHolder scopesCompareHolder = new ScopesCompareHolder(compareHolderFactory);
        ScopesCompareHolder spyScopesCompareHolder = spy(scopesCompareHolder);

        spyScopesCompareHolder.compare(leftValue, rightValue, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        verify(spyScopesCompareHolder).referableCompare(eq(leftValue), eq(rightValue), any(), any(), any());
    }
}