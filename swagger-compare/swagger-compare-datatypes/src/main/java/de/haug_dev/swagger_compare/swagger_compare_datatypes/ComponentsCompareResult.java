package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class ComponentsCompareResult extends AbstractBasicCompareResult{
    private ComponentsSchemaCompareResult componentsSchemaCompareResult;
    private ResponsesCompareResult responsesCompareResult;

    public ComponentsCompareResult(ComponentsSchemaCompareResult componentsSchemaCompareResult, ResponsesCompareResult responsesCompareResult) {
        this.componentsSchemaCompareResult = componentsSchemaCompareResult;
        this.responsesCompareResult = responsesCompareResult;
        if(!this.componentsSchemaCompareResult.getCompareResultType().equals(CompareResultType.UNCHANGED) ||
                !this.responsesCompareResult.getCompareResultType().equals(CompareResultType.UNCHANGED)){
            setCompareResultType(CompareResultType.CHANGED);
        }
        setHighestCompareCriticalType(this.componentsSchemaCompareResult.getCompareCriticalType());
        setHighestCompareCriticalType(this.responsesCompareResult.getCompareCriticalType());
    }

    public ComponentsSchemaCompareResult getComponentsSchemaCompareResult() {
        return componentsSchemaCompareResult;
    }

    public ResponsesCompareResult getResponsesCompareResult() {
        return responsesCompareResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComponentsCompareResult)) return false;
        if (!super.equals(o)) return false;
        ComponentsCompareResult that = (ComponentsCompareResult) o;
        return Objects.equals(getComponentsSchemaCompareResult(), that.getComponentsSchemaCompareResult()) &&
                Objects.equals(responsesCompareResult, that.responsesCompareResult);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getComponentsSchemaCompareResult(), responsesCompareResult);
    }

    @Override
    public String toString() {
        return "ComponentsCompareResult{" +
                "componentsSchemaCompareResult=" + componentsSchemaCompareResult +
                ", responsesCompareResult=" + responsesCompareResult +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                '}';
    }
}
