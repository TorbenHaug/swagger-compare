package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.security.OAuthFlow;

public class OAuthFlowObjectCompareHolder extends AbstractCompareHolder<OAuthFlow> {

    private CompareHolderFactory compareHolderFactory;

    public OAuthFlowObjectCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(OAuthFlow left, OAuthFlow right, CompareCriticalType created, CompareCriticalType deleted) {
        OAuthFlow leftValue = left == null ? new OAuthFlow() : left;
        OAuthFlow rightValue = right == null ? new OAuthFlow() : right;

        ScopesCompareHolder scopesCompareHolder = compareHolderFactory.getScopesCompareHolder();

        NodeCompareResult result = new NodeCompareResult(created, deleted);
        this.leafCompare(leftValue.getAuthorizationUrl(), rightValue.getAuthorizationUrl(), "AuthorizationUrl", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, result);
        this.leafCompare(leftValue.getTokenUrl(), rightValue.getTokenUrl(), "TokenUrl", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, result);
        this.leafCompare(leftValue.getRefreshUrl(), rightValue.getRefreshUrl(), "RefreshUrl", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, result);
        this.nodeCompare(leftValue.getScopes(), rightValue.getScopes(), "Scopes", scopesCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        return result;
    }
}
