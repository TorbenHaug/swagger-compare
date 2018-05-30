package de.haug_dev.swagger_compare.swagger_compare_core.request_bodies;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.parameters.RequestBody;

import java.util.HashMap;
import java.util.Map;

public class RequestBodiesCompareHolder extends AbstractCompareHolder<Map<String, RequestBody>> {

    private CompareHolderFactory compareHolderFactory;

    public RequestBodiesCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Map<String, RequestBody> left, Map<String, RequestBody> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, RequestBody> leftValue = left == null ? new HashMap<String, RequestBody>() : left;
        Map<String, RequestBody> rightValue = right == null ? new HashMap<String, RequestBody>() : right;

        RequestBodyCompareHolder requestBodyCompareHolder = compareHolderFactory.getRequestBodyCompareHolder();

        return referableCompare(leftValue, rightValue, requestBodyCompareHolder, created, deleted);
    }
}
