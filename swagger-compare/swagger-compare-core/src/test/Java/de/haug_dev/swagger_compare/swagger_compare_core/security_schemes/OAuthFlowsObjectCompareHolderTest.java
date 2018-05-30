package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class OAuthFlowsObjectCompareHolderTest {

    @Test
    public void compareNullNull() {
        OAuthFlows leftValue = null;
        OAuthFlows rightValue = null;

        OAuthFlowObjectCompareHolder oAuthFlowObjectCompareHolder = mock(OAuthFlowObjectCompareHolder.class);
        when(oAuthFlowObjectCompareHolder.compare(any(), any(), any(), any())).thenReturn(new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL));
        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getOAuthFlowObjectCompareHolder()).thenReturn(oAuthFlowObjectCompareHolder);
        OAuthFlowsObjectCompareHolder oAuthFlowsObjectCompareHolder = new OAuthFlowsObjectCompareHolder(compareHolderFactory);
        OAuthFlowsObjectCompareHolder spyOAuthFlowsObjectCompareHolder = spy(oAuthFlowsObjectCompareHolder);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        ICompareResult actual = spyOAuthFlowsObjectCompareHolder.compare(leftValue, rightValue, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareValueValue() {
        OAuthFlows leftValue = new OAuthFlows();
        leftValue.setAuthorizationCode(mock(OAuthFlow.class));
        leftValue.setClientCredentials(mock(OAuthFlow.class));
        leftValue.setImplicit(mock(OAuthFlow.class));
        leftValue.setPassword(mock(OAuthFlow.class));
        OAuthFlows rightValue = new OAuthFlows();
        rightValue.setAuthorizationCode(mock(OAuthFlow.class));
        rightValue.setClientCredentials(mock(OAuthFlow.class));
        rightValue.setImplicit(mock(OAuthFlow.class));
        rightValue.setPassword(mock(OAuthFlow.class));

        OAuthFlowObjectCompareHolder oAuthFlowObjectCompareHolder = mock(OAuthFlowObjectCompareHolder.class);
        when(oAuthFlowObjectCompareHolder.compare(any(), any(), any(), any())).thenReturn(new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL));
        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getOAuthFlowObjectCompareHolder()).thenReturn(oAuthFlowObjectCompareHolder);
        OAuthFlowsObjectCompareHolder oAuthFlowsObjectCompareHolder = new OAuthFlowsObjectCompareHolder(compareHolderFactory);
        OAuthFlowsObjectCompareHolder spyOAuthFlowsObjectCompareHolder = spy(oAuthFlowsObjectCompareHolder);

        spyOAuthFlowsObjectCompareHolder.compare(leftValue, rightValue, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        Mockito.verify(spyOAuthFlowsObjectCompareHolder).nodeCompare(eq(leftValue.getImplicit()), eq(rightValue.getImplicit()), eq("Implicit"), eq(oAuthFlowObjectCompareHolder), any(), any(), any());
        Mockito.verify(spyOAuthFlowsObjectCompareHolder).nodeCompare(eq(leftValue.getPassword()), eq(rightValue.getPassword()), eq("Password"), eq(oAuthFlowObjectCompareHolder), any(), any(), any());
        Mockito.verify(spyOAuthFlowsObjectCompareHolder).nodeCompare(eq(leftValue.getClientCredentials()), eq(rightValue.getClientCredentials()), eq("ClientCredentials"), eq(oAuthFlowObjectCompareHolder), any(), any(), any());
        Mockito.verify(spyOAuthFlowsObjectCompareHolder).nodeCompare(eq(leftValue.getAuthorizationCode()), eq(rightValue.getAuthorizationCode()), eq("AuthorizationCode"), eq(oAuthFlowObjectCompareHolder), any(), any(), any());

    }
}