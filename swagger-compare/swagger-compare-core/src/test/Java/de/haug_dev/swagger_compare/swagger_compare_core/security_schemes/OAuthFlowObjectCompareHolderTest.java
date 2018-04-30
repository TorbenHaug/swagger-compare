package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.Scopes;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class OAuthFlowObjectCompareHolderTest {

    @Test
    public void compareNullNull() {
        OAuthFlow leftValue = null;
        OAuthFlow rightValue = null;

        ScopesCompareHolder scopesCompareHolder = mock(ScopesCompareHolder.class);
        when(scopesCompareHolder.compare(any(), any())).thenReturn(new NodeCompareResult());
        OAuthFlowObjectCompareHolder oAuthFlowObjectCompareHolder = new OAuthFlowObjectCompareHolder(scopesCompareHolder);
        OAuthFlowObjectCompareHolder spyOAuthFlowsObjectCompareHolder = spy(oAuthFlowObjectCompareHolder);

        NodeCompareResult expected = new NodeCompareResult();
        ICompareResult actual = spyOAuthFlowsObjectCompareHolder.compare(leftValue, rightValue);

        assertEquals(expected, actual);
    }

    @Test
    public void compareValueValue() {
        OAuthFlow leftValue = new OAuthFlow();
        leftValue.setAuthorizationUrl("leftAuthorizationUrl");
        leftValue.setRefreshUrl("leftRefreshUrl");
        leftValue.setTokenUrl("leftTokenUrl");
        leftValue.setScopes(mock(Scopes.class));

        OAuthFlow rightValue = new OAuthFlow();
        rightValue.setAuthorizationUrl("rightAuthorizationUrl");
        rightValue.setRefreshUrl("rightRefreshUrl");
        rightValue.setTokenUrl("rightTokenUrl");
        rightValue.setScopes(mock(Scopes.class));

        ScopesCompareHolder scopesCompareHolder = mock(ScopesCompareHolder.class);
        when(scopesCompareHolder.compare(any(), any())).thenReturn(new NodeCompareResult());
        OAuthFlowObjectCompareHolder oAuthFlowObjectCompareHolder = new OAuthFlowObjectCompareHolder(scopesCompareHolder);
        OAuthFlowObjectCompareHolder spyOAuthFlowsObjectCompareHolder = spy(oAuthFlowObjectCompareHolder);

        spyOAuthFlowsObjectCompareHolder.compare(leftValue, rightValue);

        verify(spyOAuthFlowsObjectCompareHolder).leafCompare(eq(leftValue.getAuthorizationUrl()), eq(rightValue.getAuthorizationUrl()), eq("AuthorizationUrl"), eq(CompareCriticalType.NONE), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), any());
        verify(spyOAuthFlowsObjectCompareHolder).leafCompare(eq(leftValue.getTokenUrl()), eq(rightValue.getTokenUrl()), eq("TokenUrl"), eq(CompareCriticalType.NONE), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), any());
        verify(spyOAuthFlowsObjectCompareHolder).leafCompare(eq(leftValue.getRefreshUrl()), eq(rightValue.getRefreshUrl()), eq("RefreshUrl"), eq(CompareCriticalType.NONE), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), any());
        verify(spyOAuthFlowsObjectCompareHolder).nodeCompare(eq(leftValue.getScopes()), eq(rightValue.getScopes()), eq("Scopes"), eq(scopesCompareHolder), any());


    }
}