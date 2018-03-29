package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.ParametersCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ResponsesCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsSchemaCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsCompareResult;
import io.swagger.v3.oas.models.Components;

public class ComponentsCompareHolder {
    private final ComponentsSchemaCompareHolder componentsSchemaCompareHolder;
    private final ResponsesCompareHolder responsesCompareHolder;
    private final ParametersCompareHolder parametersCompareHolder;
    private Components components;

    public ComponentsCompareHolder(Components components) {
        this.components = components == null ? new Components(): components;
        this.componentsSchemaCompareHolder = new ComponentsSchemaCompareHolder(this.components.getSchemas());
        this.responsesCompareHolder = new ResponsesCompareHolder(this.components.getResponses());
        this.parametersCompareHolder = new ParametersCompareHolder(this.components.getParameters());
    }

    public ComponentsCompareResult compare(ComponentsCompareHolder other) {
        ComponentsSchemaCompareResult componentsSchemaCompareResult = this.componentsSchemaCompareHolder.compare(other.componentsSchemaCompareHolder);
        ResponsesCompareResult responsesCompareResult = this.responsesCompareHolder.compare(other.responsesCompareHolder);
        ParametersCompareResult parametersCompareResult = this.parametersCompareHolder.compare(other.parametersCompareHolder);
        return new ComponentsCompareResult(componentsSchemaCompareResult, responsesCompareResult, parametersCompareResult);
    }
}
