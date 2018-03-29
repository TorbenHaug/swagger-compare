package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.parameters.Parameter;

public class ParameterCompareResult extends AbstractLeafCompareResult<Parameter> {
    public ParameterCompareResult(Parameter left, Parameter right){
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
