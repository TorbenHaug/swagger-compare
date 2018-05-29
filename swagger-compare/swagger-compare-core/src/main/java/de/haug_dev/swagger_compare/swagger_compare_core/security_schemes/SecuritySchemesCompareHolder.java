package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SecuritySchemesCompareHolder extends AbstractCompareHolder<Map<String, SecurityScheme>> {

    private SecuritySchemeCompareHolder securitySchemeCompareHolder;

    @Autowired
    public SecuritySchemesCompareHolder(SecuritySchemeCompareHolder securitySchemeCompareHolder) {
        this.securitySchemeCompareHolder = securitySchemeCompareHolder;
    }

    @Override
    public ICompareResult compare(Map<String, SecurityScheme> left, Map<String, SecurityScheme> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, SecurityScheme> leftValue = (left == null) ? new HashMap<>() : left;
        Map<String, SecurityScheme> rightValue = (right == null) ? new HashMap<>() : right;
        return this.referableCompare(leftValue, rightValue, securitySchemeCompareHolder, created, deleted);
    }
}
