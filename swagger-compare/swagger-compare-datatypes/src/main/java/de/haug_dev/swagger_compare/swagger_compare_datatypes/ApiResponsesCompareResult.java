package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponses;

import java.util.Objects;

public class ApiResponsesCompareResult extends AbstractLeafCompareResult<ApiResponses>{

    public ApiResponsesCompareResult(ApiResponses left, ApiResponses right) {
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
