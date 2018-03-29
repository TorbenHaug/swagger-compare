package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class ComponentsCompareResult extends AbstractBasicCompareResult{
    private ComponentsSchemaCompareResult componentsSchemaCompareResult;
    private ResponsesCompareResult responsesCompareResult;
    private ParametersCompareResult parametersCompareResult;

    public ComponentsCompareResult(ComponentsSchemaCompareResult componentsSchemaCompareResult, ResponsesCompareResult responsesCompareResult, ParametersCompareResult parametersCompareResult) {
        this.componentsSchemaCompareResult = componentsSchemaCompareResult;
        this.responsesCompareResult = responsesCompareResult;
        this.parametersCompareResult = parametersCompareResult;
        if(!this.componentsSchemaCompareResult.getCompareResultType().equals(CompareResultType.UNCHANGED) ||
                !this.responsesCompareResult.getCompareResultType().equals(CompareResultType.UNCHANGED)||
                !this.parametersCompareResult.getCompareResultType().equals(CompareResultType.UNCHANGED)){
            setCompareResultType(CompareResultType.CHANGED);
        }
        setHighestCompareCriticalType(this.componentsSchemaCompareResult.getCompareCriticalType());
        setHighestCompareCriticalType(this.responsesCompareResult.getCompareCriticalType());
        setHighestCompareCriticalType(this.parametersCompareResult.getCompareCriticalType());
    }

    public ComponentsSchemaCompareResult getComponentsSchemaCompareResult() {
        return componentsSchemaCompareResult;
    }

    public ResponsesCompareResult getResponsesCompareResult() {
        return responsesCompareResult;
    }

    public ParametersCompareResult getParametersCompareResult() {
        return parametersCompareResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComponentsCompareResult)) return false;
        if (!super.equals(o)) return false;
        ComponentsCompareResult that = (ComponentsCompareResult) o;
        return Objects.equals(getComponentsSchemaCompareResult(), that.getComponentsSchemaCompareResult()) &&
                Objects.equals(getResponsesCompareResult(), that.getResponsesCompareResult()) &&
                Objects.equals(getParametersCompareResult(), that.getParametersCompareResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getComponentsSchemaCompareResult(), getResponsesCompareResult(), getParametersCompareResult());
    }

    @Override
    public String toString() {
        return "ComponentsCompareResult{" +
                "componentsSchemaCompareResult=" + componentsSchemaCompareResult +
                ", responsesCompareResult=" + responsesCompareResult +
                ", parametersCompareResult=" + parametersCompareResult +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                '}';
    }
}
