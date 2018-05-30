package de.haug_dev.swagger_compare.swagger_compare_core.responses;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.HashMap;
import java.util.Map;

public class ResponsesCompareHolder extends AbstractCompareHolder<Map<String, ApiResponse>> {


    private CompareHolderFactory compareHolderFactory;

    public ResponsesCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Map<String, ApiResponse> left, Map<String, ApiResponse> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, ApiResponse> leftValue = left == null ? new HashMap<String, ApiResponse>() : left;
        Map<String, ApiResponse> rightValue = right == null ? new HashMap<String, ApiResponse>() : right;

        ResponseCompareHolder responseCompareHolder = compareHolderFactory.getResponseCompareHolder();

        return referableCompare(leftValue, rightValue, responseCompareHolder, created, deleted);
    }
}
