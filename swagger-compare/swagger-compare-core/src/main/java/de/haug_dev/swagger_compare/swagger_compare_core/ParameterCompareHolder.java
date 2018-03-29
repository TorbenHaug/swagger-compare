package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.ParameterCompareResult;
import io.swagger.v3.oas.models.parameters.Parameter;

public class ParameterCompareHolder {
    private Parameter parameter;

    public ParameterCompareHolder(Parameter parameter) {
        this.parameter = parameter;
    }

    public ParameterCompareResult compare(ParameterCompareHolder other) {
        return new ParameterCompareResult(this.parameter, other.parameter);
    }
}
