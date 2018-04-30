package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.security.OAuthFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OAuthFlowObjectCompareHolder extends AbstractCompareHolder<OAuthFlow> {

    private ScopesCompareHolder scopesCompareHolder;

    @Autowired
    public OAuthFlowObjectCompareHolder(ScopesCompareHolder scopesCompareHolder) {
        this.scopesCompareHolder = scopesCompareHolder;
    }

    @Override
    public ICompareResult compare(OAuthFlow left, OAuthFlow right) {
        OAuthFlow leftValue = left == null ? new OAuthFlow() : left;
        OAuthFlow rightValue = right == null ? new OAuthFlow() : right;
        NodeCompareResult result = new NodeCompareResult();
        this.leafCompare(leftValue.getAuthorizationUrl(), rightValue.getAuthorizationUrl(), "AuthorizationUrl", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, result);
        this.leafCompare(leftValue.getTokenUrl(), rightValue.getTokenUrl(), "TokenUrl", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, result);
        this.leafCompare(leftValue.getRefreshUrl(), rightValue.getRefreshUrl(), "RefreshUrl", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, result);
        this.nodeCompare(leftValue.getScopes(), rightValue.getScopes(), "Scopes", scopesCompareHolder, result);
        return result;
    }
}
