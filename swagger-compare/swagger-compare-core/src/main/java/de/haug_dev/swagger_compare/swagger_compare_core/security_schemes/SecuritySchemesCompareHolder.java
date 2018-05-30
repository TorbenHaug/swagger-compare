package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.HashMap;
import java.util.Map;

public class SecuritySchemesCompareHolder extends AbstractCompareHolder<Map<String, SecurityScheme>> {

    private CompareHolderFactory compareHolderFactory;

    public SecuritySchemesCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Map<String, SecurityScheme> left, Map<String, SecurityScheme> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, SecurityScheme> leftValue = (left == null) ? new HashMap<>() : left;
        Map<String, SecurityScheme> rightValue = (right == null) ? new HashMap<>() : right;

        SecuritySchemeCompareHolder securitySchemeCompareHolder = compareHolderFactory.getSecuritySchemeCompareHolder();

        return this.referableCompare(leftValue, rightValue, securitySchemeCompareHolder, created, deleted);
    }
}
