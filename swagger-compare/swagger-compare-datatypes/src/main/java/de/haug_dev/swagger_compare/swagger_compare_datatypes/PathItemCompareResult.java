package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.Operation;

import java.util.Map;
import java.util.Objects;

public class PathItemCompareResult {
    private final ParametersCompareResult parametersCompareResult;
    private final RefCompareResult refCompareResult;
    private final Map<String, Operation> createdOperations;
    private final Map<String, Operation> deletedOperations;
    private final Map<String, Operation> unchangedOperations;
    private final Map<String, OperationCompareResult> changedOperations;
    private final CompareResultType compareResultType;
    private final CompareCriticalType compareCriticalType;

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
            this.compareResultType = CompareResultType.UNCHANGED;
            this.compareCriticalType = CompareCriticalType.NONE;
        } else {
            this.compareResultType = CompareResultType.CHANGED;
            CompareCriticalType tmpCompareCriticalType = CompareCriticalType.NONE;
            if(tmpCompareCriticalType.getLevel() < parametersCompareResult.getCompareCriticalType().getLevel()){
                tmpCompareCriticalType = parametersCompareResult.getCompareCriticalType();
            }
            if(tmpCompareCriticalType.getLevel() < refCompareResult.getCompareCriticalType().getLevel()){
                tmpCompareCriticalType = refCompareResult.getCompareCriticalType();
            }
            if(tmpCompareCriticalType.getLevel() < CompareCriticalType.INFO.getLevel() && !createdOperations.isEmpty()){
                tmpCompareCriticalType = CompareCriticalType.INFO;
            }
            if(tmpCompareCriticalType.getLevel() < CompareCriticalType.CRITICAL.getLevel() && !deletedOperations.isEmpty()){
                tmpCompareCriticalType = CompareCriticalType.CRITICAL;
            }
            if(!changedOperations.isEmpty()){
                for(OperationCompareResult operationCompareResult: changedOperations.values()) {
                    if(tmpCompareCriticalType.getLevel() < operationCompareResult.getCompareCriticalType().getLevel()) {
                        tmpCompareCriticalType = operationCompareResult.getCompareCriticalType();
                    }
                }
            }

            this.compareCriticalType = tmpCompareCriticalType;
        }
    }

    public RefCompareResult getRefCompareResult() {
        return refCompareResult;
    }

    public ParametersCompareResult getParametersCompareResult() {
        return parametersCompareResult;
    }

    public CompareResultType getCompareResultType() {
        return compareResultType;
    }

    public CompareCriticalType getCompareCriticalType() {
        return compareCriticalType;
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
        PathItemCompareResult that = (PathItemCompareResult) o;
        return Objects.equals(getParametersCompareResult(), that.getParametersCompareResult()) &&
                Objects.equals(getRefCompareResult(), that.getRefCompareResult()) &&
                Objects.equals(createdOperations, that.createdOperations) &&
                Objects.equals(deletedOperations, that.deletedOperations) &&
                Objects.equals(unchangedOperations, that.unchangedOperations) &&
                Objects.equals(changedOperations, that.changedOperations) &&
                getCompareResultType() == that.getCompareResultType() &&
                getCompareCriticalType() == that.getCompareCriticalType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getParametersCompareResult(), getRefCompareResult(), createdOperations, deletedOperations, unchangedOperations, changedOperations, getCompareResultType(), getCompareCriticalType());
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
                ", compareResultType=" + compareResultType +
                ", compareCriticalType=" + compareCriticalType +
                '}';
    }
}
