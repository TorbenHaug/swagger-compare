package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SecuritySchemeCompareHolderTest {

    @Test
    public void compareNullNull() {
        SecurityScheme left = null;
        SecurityScheme right = null;
        OAuthFlowsObjectCompareHolder oAuthFlowsObjectCompareHolder = Mockito.mock(OAuthFlowsObjectCompareHolder.class);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getOAuthFlowsObjectCompareHolder()).thenReturn(oAuthFlowsObjectCompareHolder);

        SecuritySchemeCompareHolder securitySchemeCompareHolder = new SecuritySchemeCompareHolder(compareHolderFactory);
        SecuritySchemeCompareHolder spySecuritySchemeCompareHolder = Mockito.spy(securitySchemeCompareHolder);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        ICompareResult actual = spySecuritySchemeCompareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareValueValue() {
        SecurityScheme leftValue = new SecurityScheme();
        leftValue.set$ref("refLeft");
        leftValue.setType(SecurityScheme.Type.OPENIDCONNECT);
        leftValue.setDescription("descriptionLeft");
        leftValue.setName("nameLeft");
        leftValue.setIn(SecurityScheme.In.COOKIE);
        leftValue.setScheme("schemeLeft");
        leftValue.setBearerFormat("bearLeft");
        leftValue.setFlows(new OAuthFlows());
        leftValue.setOpenIdConnectUrl("urlLeft");

        SecurityScheme rightValue = new SecurityScheme();
        rightValue.set$ref("refRight");
        rightValue.setType(SecurityScheme.Type.OPENIDCONNECT);
        rightValue.setDescription("descriptionRight");
        rightValue.setName("nameRight");
        rightValue.setIn(SecurityScheme.In.COOKIE);
        rightValue.setScheme("schemeRight");
        rightValue.setBearerFormat("bearRight");
        rightValue.setFlows(new OAuthFlows());
        rightValue.setOpenIdConnectUrl("urlRight");
        OAuthFlowsObjectCompareHolder oAuthFlowsObjectCompareHolder = Mockito.mock(OAuthFlowsObjectCompareHolder.class);
        Mockito.when(oAuthFlowsObjectCompareHolder.compare(any(), any(), any(), any())).thenReturn(new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL));

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getOAuthFlowsObjectCompareHolder()).thenReturn(oAuthFlowsObjectCompareHolder);

        SecuritySchemeCompareHolder securitySchemeCompareHolder = new SecuritySchemeCompareHolder(compareHolderFactory);
        SecuritySchemeCompareHolder spySecuritySchemeCompareHolder = Mockito.spy(securitySchemeCompareHolder);

        spySecuritySchemeCompareHolder.compare(leftValue, rightValue, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        Mockito.verify(spySecuritySchemeCompareHolder).leafCompare(eq(leftValue.get$ref()), eq(rightValue.get$ref()), eq("Ref"), eq(CompareCriticalType.NONE), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), any());
        Mockito.verify(spySecuritySchemeCompareHolder).leafCompare(eq(leftValue.getType()), eq(rightValue.getType()), eq("Type"), eq(CompareCriticalType.NONE), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), any());
        Mockito.verify(spySecuritySchemeCompareHolder).leafCompare(eq(leftValue.getDescription()), eq(rightValue.getDescription()), eq("Description"), eq(CompareCriticalType.NONE), eq(CompareCriticalType.INFO), eq(CompareCriticalType.INFO), eq(CompareCriticalType.INFO), any());
        Mockito.verify(spySecuritySchemeCompareHolder).leafCompare(eq(leftValue.getName()), eq(rightValue.getName()), eq("Name"), eq(CompareCriticalType.NONE), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), any());
        Mockito.verify(spySecuritySchemeCompareHolder).leafCompare(eq(leftValue.getIn()), eq(rightValue.getIn()), eq("In"), eq(CompareCriticalType.NONE), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), any());
        Mockito.verify(spySecuritySchemeCompareHolder).leafCompare(eq(leftValue.getScheme()), eq(rightValue.getScheme()), eq("Scheme"), eq(CompareCriticalType.NONE), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), any());
        Mockito.verify(spySecuritySchemeCompareHolder).leafCompare(eq(leftValue.getBearerFormat()), eq(rightValue.getBearerFormat()), eq("BearerFormat"), eq(CompareCriticalType.NONE), eq(CompareCriticalType.INFO), eq(CompareCriticalType.INFO), eq(CompareCriticalType.INFO), any());
        Mockito.verify(spySecuritySchemeCompareHolder).nodeCompare(eq(leftValue.getFlows()), eq(rightValue.getFlows()), eq("Flows"), eq(oAuthFlowsObjectCompareHolder), any(), any(), any());
        Mockito.verify(spySecuritySchemeCompareHolder).leafCompare(eq(leftValue.getOpenIdConnectUrl()), eq(rightValue.getOpenIdConnectUrl()), eq("OpenIdConnectUrl"), eq(CompareCriticalType.NONE), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), eq(CompareCriticalType.CRITICAL), any());


    }
}