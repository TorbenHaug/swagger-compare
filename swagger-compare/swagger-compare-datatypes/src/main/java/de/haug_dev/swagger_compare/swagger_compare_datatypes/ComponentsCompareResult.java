package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class ComponentsCompareResult {
    private ComponentsSchemaCompareResult componentsSchemaCompareResult;
    private CompareResultType compareResultType = CompareResultType.UNCHANGED;
    private CompareCriticalType compareCriticalType = CompareCriticalType.NONE;

    public ComponentsCompareResult(ComponentsSchemaCompareResult componentsSchemaCompareResult) {
        this.componentsSchemaCompareResult = componentsSchemaCompareResult;
        if(!this.componentsSchemaCompareResult.getCompareResultType().equals(CompareResultType.UNCHANGED)){
            this.compareResultType = CompareResultType.CHANGED;
        }
        this.compareCriticalType = this.compareCriticalType.
                greater(componentsSchemaCompareResult.getCompareCriticalType());
    }

    public ComponentsSchemaCompareResult getComponentsSchemaCompareResult() {
        return componentsSchemaCompareResult;
    }

    public CompareResultType getCompareResultType() {
        return compareResultType;
    }

    public CompareCriticalType getCompareCriticalType() {
        return compareCriticalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComponentsCompareResult)) return false;
        ComponentsCompareResult that = (ComponentsCompareResult) o;
        return Objects.equals(getComponentsSchemaCompareResult(), that.getComponentsSchemaCompareResult()) &&
                getCompareResultType() == that.getCompareResultType() &&
                getCompareCriticalType() == that.getCompareCriticalType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getComponentsSchemaCompareResult(), getCompareResultType(), getCompareCriticalType());
    }

    @Override
    public String toString() {
        return "ComponentsCompareResult{" +
                "componentsSchemaCompareResult=" + componentsSchemaCompareResult +
                ", compareResultType=" + compareResultType +
                ", compareCriticalType=" + compareCriticalType +
                '}';
    }
}
