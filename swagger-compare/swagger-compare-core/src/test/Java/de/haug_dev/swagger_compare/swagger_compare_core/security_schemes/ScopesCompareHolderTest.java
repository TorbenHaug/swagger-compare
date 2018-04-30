package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.Scopes;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ScopesCompareHolderTest {

    @Test
    public void compareNullNull() {
        Scopes leftValue = null;
        Scopes rightValue = null;

        ScopeCompareHolder scopeCompareHolder = mock(ScopeCompareHolder.class);
        when(scopeCompareHolder.compare(any(), any())).thenReturn(new NodeCompareResult());
        ScopesCompareHolder scopesCompareHolder = new ScopesCompareHolder(scopeCompareHolder);
        ScopesCompareHolder spyScopesCompareHolder = spy(scopesCompareHolder);

        NodeCompareResult expected = new NodeCompareResult();
        ICompareResult actual = spyScopesCompareHolder.compare(leftValue, rightValue);

        assertEquals(expected, actual);
    }

    @Test
    public void compareValueValue() {
        Scopes leftValue = mock(Scopes.class);
        Scopes rightValue = mock(Scopes.class);

        ScopeCompareHolder scopeCompareHolder = mock(ScopeCompareHolder.class);
        when(scopeCompareHolder.compare(any(), any())).thenReturn(new NodeCompareResult());
        ScopesCompareHolder scopesCompareHolder = new ScopesCompareHolder(scopeCompareHolder);
        ScopesCompareHolder spyScopesCompareHolder = spy(scopesCompareHolder);

        spyScopesCompareHolder.compare(leftValue, rightValue);

        verify(spyScopesCompareHolder).referableCompare(eq(leftValue), eq(rightValue), any());
    }
}