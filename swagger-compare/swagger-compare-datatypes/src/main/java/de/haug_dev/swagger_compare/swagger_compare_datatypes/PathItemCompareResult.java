package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.Operation;

import java.util.Map;
import java.util.Objects;

public class PathItemCompareResult extends AbstractBasicCompareResult{
    private final ParametersCompareResult parametersCompareResult;
    private final RefCompareResult refCompareResult;
    private final Map<String, Operation> createdOperations;
    private final Map<String, Operation> deletedOperations;
    private final Map<String, Operation> unchangedOperations;
    private final Map<String, OperationCompareResult> changedOperations;

    public PathItemCompareResult(
            ParametersCompareResult parametersCompareResult,
            RefCompareResult refCompareResult,
            Map<String, Operation> createdOperations,
            Map<String, Operation> deletedOperations,
            Map<String, Operation> unchangedOperations,
            Map<String, OperationCompareResult> changedOperations) {
        this.parametersCompareResult = parametersCompareResult;
        this.refCompareResult = refCompareResult;
        this.createdOperations = createdOperations;
        this.deletedOperations = deletedOperations;
        this.unchangedOperations = unchangedOperations;
        this.changedOperations = changedOperations;
        if(this.parametersCompareResult.getCompareResultType() == CompareResultType.UNCHANGED &&
                this.refCompareResult.getCompareResultType() == CompareResultType.UNCHANGED &&
                createdOperations.isEmpty() &&
                deletedOperations.isEmpty() &&
                changedOperations.isEmpty()) {
            setCompareResultType(CompareResultType.UNCHANGED);
            setHighestCompareCriticalType(CompareCriticalType.NONE);
        } else {
            setCompareResultType(CompareResultType.CHANGED);
            setHighestCompareCriticalType(parametersCompareResult.getCompareCriticalType());
            setHighestCompareCriticalType(refCompareResult.getCompareCriticalType());
            if(!createdOperations.isEmpty()){
                setHighestCompareCriticalType(CompareCriticalType.INFO);
            }
            if(!deletedOperations.isEmpty()){
                setHighestCompareCriticalType(CompareCriticalType.CRITICAL);
            }
            if(!changedOperations.isEmpty()){
                for(OperationCompareResult operationCompareResult: changedOperations.values()) {
                    setHighestCompareCriticalType(operationCompareResult.getCompareCriticalType());
                }
            }
        }
    }

    public RefCompareResult getRefCompareResult() {
        return refCompareResult;
    }

    public ParametersCompareResult getParametersCompareResult() {
        return parametersCompareResult;
    }

    public Map<String, Operation> getCreatedOperations() {
        return createdOperations;
    }

    public Map<String, Operation> getDeletedOperations() {
        return deletedOperations;
    }

    public Map<String, Operation> getUnchangedOperations() {
        return unchangedOperations;
    }

    public Map<String, OperationCompareResult> getChangedOperations() {
        return changedOperations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PathItemCompareResult)) return false;
        if (!super.equals(o)) return false;
        PathItemCompareResult that = (PathItemCompareResult) o;
        return Objects.equals(getParametersCompareResult(), that.getParametersCompareResult()) &&
                Objects.equals(getRefCompareResult(), that.getRefCompareResult()) &&
                Objects.equals(getCreatedOperations(), that.getCreatedOperations()) &&
                Objects.equals(getDeletedOperations(), that.getDeletedOperations()) &&
                Objects.equals(getUnchangedOperations(), that.getUnchangedOperations()) &&
                Objects.equals(getChangedOperations(), that.getChangedOperations());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getParametersCompareResult(), getRefCompareResult(), getCreatedOperations(), getDeletedOperations(), getUnchangedOperations(), getChangedOperations());
    }

    @Override
    public String toString() {
        return "PathItemCompareResult{" +
                "parametersCompareResult=" + parametersCompareResult +
                ", refCompareResult=" + refCompareResult +
                ", createdOperations=" + createdOperations +
                ", deletedOperations=" + deletedOperations +
                ", unchangedOperations=" + unchangedOperations +
                ", changedOperations=" + changedOperations +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                '}';
    }
}
