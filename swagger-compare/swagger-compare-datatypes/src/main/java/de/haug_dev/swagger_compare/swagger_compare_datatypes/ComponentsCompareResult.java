package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class ComponentsCompareResult extends AbstractBasicCompareResult{
    private ComponentsSchemaCompareResult componentsSchemaCompareResult;
    private ComponentsResponsesCompareResult componentsResponsesCompareResult;

    public ComponentsCompareResult(ComponentsSchemaCompareResult componentsSchemaCompareResult, ComponentsResponsesCompareResult componentsResponsesCompareResult) {
        this.componentsSchemaCompareResult = componentsSchemaCompareResult;
        this.componentsResponsesCompareResult = componentsResponsesCompareResult;
        if(!this.componentsSchemaCompareResult.getCompareResultType().equals(CompareResultType.UNCHANGED) ||
                !this.componentsResponsesCompareResult.getCompareResultType().equals(CompareResultType.UNCHANGED)){
            setCompareResultType(CompareResultType.CHANGED);
        }
        setHighestCompareCriticalType(this.componentsSchemaCompareResult.getCompareCriticalType());
        setHighestCompareCriticalType(this.componentsResponsesCompareResult.getCompareCriticalType());
    }

    public ComponentsSchemaCompareResult getComponentsSchemaCompareResult() {
        return componentsSchemaCompareResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComponentsCompareResult)) return false;
        if (!super.equals(o)) return false;
        ComponentsCompareResult that = (ComponentsCompareResult) o;
        return Objects.equals(getComponentsSchemaCompareResult(), that.getComponentsSchemaCompareResult()) &&
                Objects.equals(componentsResponsesCompareResult, that.componentsResponsesCompareResult);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getComponentsSchemaCompareResult(), componentsResponsesCompareResult);
    }

    @Override
    public String toString() {
        return "ComponentsCompareResult{" +
                "componentsSchemaCompareResult=" + componentsSchemaCompareResult +
                ", componentsResponsesCompareResult=" + componentsResponsesCompareResult +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                '}';
    }
}
