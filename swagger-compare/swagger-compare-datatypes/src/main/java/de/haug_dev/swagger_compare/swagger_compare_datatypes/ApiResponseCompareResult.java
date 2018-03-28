package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.responses.ApiResponse;

public class ApiResponseCompareResult extends AbstractLeafCompareResult<ApiResponse>{
    public ApiResponseCompareResult(ApiResponse left, ApiResponse right) {
        super(
                left,
                right,
                CompareCriticalType.NONE,
                CompareCriticalType.CRITICAL,
                CompareCriticalType.CRITICAL,
                CompareCriticalType.CRITICAL
        );
    }
}
