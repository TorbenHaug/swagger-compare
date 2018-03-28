package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.ResponsesCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsSchemaCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsCompareResult;
import io.swagger.v3.oas.models.Components;

public class ComponentsCompareHolder {
    private final ComponentsSchemaCompareHolder componentsSchemaCompareHolder;
    private final ResponsesCompareHolder responsesCompareHolder;
    private Components components;

    public ComponentsCompareHolder(Components components) {
        this.components = components == null ? new Components(): components;
        this.componentsSchemaCompareHolder = new ComponentsSchemaCompareHolder(this.components.getSchemas());
        this.responsesCompareHolder = new ResponsesCompareHolder(this.components.getResponses());
    }

    public ComponentsCompareResult compare(ComponentsCompareHolder other) {
        ComponentsSchemaCompareResult componentsSchemaCompareResult = this.componentsSchemaCompareHolder.compare(other.componentsSchemaCompareHolder);
        ResponsesCompareResult responsesCompareResult = this.responsesCompareHolder.compare(other.responsesCompareHolder);
        return new ComponentsCompareResult(componentsSchemaCompareResult, responsesCompareResult);
    }
}
