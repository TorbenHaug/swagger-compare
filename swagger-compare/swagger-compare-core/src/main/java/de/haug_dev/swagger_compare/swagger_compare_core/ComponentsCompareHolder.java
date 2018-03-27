package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsResponsesCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsSchemaCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsCompareResult;
import io.swagger.v3.oas.models.Components;

public class ComponentsCompareHolder {
    private final ComponentsSchemaCompareHolder componentsSchemaCompareHolder;
    private final ComponentsResponsesCompareHolder componentsResponsesCompareHolder;
    private Components components;

    public ComponentsCompareHolder(Components components) {
        this.components = components == null ? new Components(): components;
        this.componentsSchemaCompareHolder = new ComponentsSchemaCompareHolder(this.components.getSchemas());
        this.componentsResponsesCompareHolder = new ComponentsResponsesCompareHolder(this.components.getResponses());
    }

    public ComponentsCompareResult compare(ComponentsCompareHolder other) {
        ComponentsSchemaCompareResult componentsSchemaCompareResult = this.componentsSchemaCompareHolder.compare(other.componentsSchemaCompareHolder);
        ComponentsResponsesCompareResult componentsResponsesCompareResult = this.componentsResponsesCompareHolder.compare(other.componentsResponsesCompareHolder);
        return new ComponentsCompareResult(componentsSchemaCompareResult, componentsResponsesCompareResult);
    }
}
