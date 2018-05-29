package de.haug_dev.swagger_compare.swagger_compare_core.security_schemes;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.security.OAuthFlows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OAuthFlowsObjectCompareHolder extends AbstractCompareHolder<OAuthFlows> {

    private OAuthFlowObjectCompareHolder oAuthFlowObjectCompareHolder;

    @Autowired
    public OAuthFlowsObjectCompareHolder(OAuthFlowObjectCompareHolder oAuthFlowObjectCompareHolder) {
        this.oAuthFlowObjectCompareHolder = oAuthFlowObjectCompareHolder;
    }

    @Override
    public ICompareResult compare(OAuthFlows left, OAuthFlows right, CompareCriticalType created, CompareCriticalType deleted) {
        OAuthFlows leftValue = left == null ? new OAuthFlows() : left;
        OAuthFlows rightValue = right == null ? new OAuthFlows() : right;
        NodeCompareResult result = new NodeCompareResult(created, deleted);
        this.nodeCompare(leftValue.getImplicit(), rightValue.getImplicit(), "Implicit", oAuthFlowObjectCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getPassword(), rightValue.getPassword(), "Password", oAuthFlowObjectCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getClientCredentials(), rightValue.getClientCredentials(), "ClientCredentials", oAuthFlowObjectCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftValue.getAuthorizationCode(), rightValue.getAuthorizationCode(), "AuthorizationCode", oAuthFlowObjectCompareHolder, result, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        return result;
    }
}
