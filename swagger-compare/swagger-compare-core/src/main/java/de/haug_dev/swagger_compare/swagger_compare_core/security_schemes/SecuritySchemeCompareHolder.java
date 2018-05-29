package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecuritySchemeCompareHolder extends AbstractCompareHolder<SecurityScheme> {
    private OAuthFlowsObjectCompareHolder oAuthFlowsObjectCompareHolder;

    @Autowired
    public SecuritySchemeCompareHolder(OAuthFlowsObjectCompareHolder oAuthFlowsObjectCompareHolder) {
        this.oAuthFlowsObjectCompareHolder = oAuthFlowsObjectCompareHolder;
    }

    @Override
    public ICompareResult compare(SecurityScheme left, SecurityScheme right, CompareCriticalType created, CompareCriticalType deleted) {
        SecurityScheme leftValue = left == null ? new SecurityScheme() : left;
        SecurityScheme rightValue = right == null ? new SecurityScheme() : right;
        NodeCompareResult result = new NodeCompareResult(created, deleted);
        this.leafCompare(leftValue.get$ref(), rightValue.get$ref(), "Ref", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL,CompareCriticalType.CRITICAL, result);
        this.leafCompare(leftValue.getType(), rightValue.getType(), "Type", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL,CompareCriticalType.CRITICAL, result);
        this.leafCompare(leftValue.getDescription(), rightValue.getDescription(), "Description", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO,CompareCriticalType.INFO, result);
        this.leafCompare(leftValue.getName(), rightValue.getName(), "Name", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL,CompareCriticalType.CRITICAL, result);
        this.leafCompare(leftValue.getIn(), rightValue.getIn(), "In", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL,CompareCriticalType.CRITICAL, result);
        this.leafCompare(leftValue.getScheme(), rightValue.getScheme(), "Scheme", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL,CompareCriticalType.CRITICAL, result);
        this.leafCompare(leftValue.getBearerFormat(), rightValue.getBearerFormat(), "BearerFormat", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO,CompareCriticalType.INFO, result);
        this.nodeCompare(leftValue.getFlows(), rightValue.getFlows(), "Flows", oAuthFlowsObjectCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        this.leafCompare(leftValue.getOpenIdConnectUrl(), rightValue.getOpenIdConnectUrl(), "OpenIdConnectUrl", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL,CompareCriticalType.CRITICAL, result);
        return result;
    }
}
