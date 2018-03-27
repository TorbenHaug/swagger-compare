package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsSchemaCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsCompareResult;
import io.swagger.v3.oas.models.Components;

public class ComponentsCompareHolder {
    private final ComponentsSchemaCompareHolder componentsSchemaCompareHolder;
    private Components components;

    public ComponentsCompareHolder(Components components) {
        this.components = components == null ? new Components(): components;
        this.componentsSchemaCompareHolder = new ComponentsSchemaCompareHolder(this.components.getSchemas());
    }

    public ComponentsCompareResult compare(ComponentsCompareHolder other) {
        ComponentsSchemaCompareResult componentsSchemaCompareResult = this.componentsSchemaCompareHolder.compare(other.componentsSchemaCompareHolder);
        return new ComponentsCompareResult(componentsSchemaCompareResult);
    }
}
