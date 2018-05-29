package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

public class SecuritySchemesCompareHolderTest {

    @Test
    public void compareNullNull() {
        Map<String, SecurityScheme> left = null;
        Map<String, SecurityScheme> right = null;

        SecuritySchemeCompareHolder securitySchemeCompareHolder = Mockito.mock(SecuritySchemeCompareHolder.class);
        SecuritySchemesCompareHolder securitySchemesCompareHolder = new SecuritySchemesCompareHolder(securitySchemeCompareHolder);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        ICompareResult actual = securitySchemesCompareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);

    }

    @Test
    public void compareEmptyEmpty() {
        Map<String, SecurityScheme> left = new HashMap<>();
        Map<String, SecurityScheme> right = new HashMap<>();

        SecuritySchemeCompareHolder securitySchemeCompareHolder = Mockito.mock(SecuritySchemeCompareHolder.class);
        SecuritySchemesCompareHolder securitySchemesCompareHolder = new SecuritySchemesCompareHolder(securitySchemeCompareHolder);
        SecuritySchemesCompareHolder spySecuritySchemesCompareHolder = Mockito.spy(securitySchemesCompareHolder);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        ICompareResult actual = spySecuritySchemesCompareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        Mockito.verify(spySecuritySchemesCompareHolder).referableCompare(eq(left), eq(right), eq(securitySchemeCompareHolder), any(), any());
        assertEquals(expected, actual);
    }


}