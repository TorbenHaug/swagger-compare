package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.security.OAuthFlows;

public class OAuthFlowsObjectCompareHolder extends AbstractCompareHolder<OAuthFlows> {

    private CompareHolderFactory compareHolderFactory;

    public OAuthFlowsObjectCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(OAuthFlows left, OAuthFlows right, CompareCriticalType created, CompareCriticalType deleted) {
        OAuthFlows leftValue = left == null ? new OAuthFlows() : left;
        OAuthFlows rightValue = right == null ? new OAuthFlows() : right;

        OAuthFlowObjectCompareHolder oAuthFlowObjectCompareHolderImplicit = compareHolderFactory.getOAuthFlowObjectCompareHolder();
        OAuthFlowObjectCompareHolder oAuthFlowObjectCompareHolderPassword = compareHolderFactory.getOAuthFlowObjectCompareHolder();
        OAuthFlowObjectCompareHolder oAuthFlowObjectCompareHolderClientCredentials = compareHolderFactory.getOAuthFlowObjectCompareHolder();
        OAuthFlowObjectCompareHolder oAuthFlowObjectCompareHolderAuthorizationCode = compareHolderFactory.getOAuthFlowObjectCompareHolder();

        NodeCompareResult result = new NodeCompareResult(created, deleted);
        this.nodeCompare(leftValue.getImplicit(), rightValue.getImplicit(), "Implicit", oAuthFlowObjectCompareHolderImplicit, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getPassword(), rightValue.getPassword(), "Password", oAuthFlowObjectCompareHolderPassword, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getClientCredentials(), rightValue.getClientCredentials(), "ClientCredentials", oAuthFlowObjectCompareHolderClientCredentials, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getAuthorizationCode(), rightValue.getAuthorizationCode(), "AuthorizationCode", oAuthFlowObjectCompareHolderAuthorizationCode, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        return result;
    }
}
