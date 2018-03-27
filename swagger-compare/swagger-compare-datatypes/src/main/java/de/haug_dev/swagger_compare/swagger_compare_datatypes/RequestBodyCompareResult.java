package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.parameters.RequestBody;

import java.util.Objects;

public class RequestBodyCompareResult extends AbstractLeafCompareResult<RequestBody>{

    public RequestBodyCompareResult(RequestBody left, RequestBody right) {
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
