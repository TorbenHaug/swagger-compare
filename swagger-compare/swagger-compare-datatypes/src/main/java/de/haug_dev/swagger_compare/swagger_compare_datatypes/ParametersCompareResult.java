package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.Objects;
import java.util.Set;

public class ParametersCompareResult {
    private final Set<Parameter> unchanged;
    private final Set<Parameter> created;
    private final Set<Parameter> deleted;
    private final CompareCriticalType compareCriticalType;
    private final CompareResultType compareResultType;

    public ParametersCompareResult(Set<Parameter> unchanged, Set<Parameter> created, Set<Parameter> deleted) {
        this.unchanged = unchanged;
        this.created = created;
        this.deleted = deleted;
        if(!created.isEmpty() || !deleted.isEmpty()){
            this.compareResultType = CompareResultType.CHANGED;
            this.compareCriticalType = CompareCriticalType.CRITICAL;
        } else {
            this.compareResultType = CompareResultType.UNCHANGED;
            this.compareCriticalType = CompareCriticalType.NONE;
        }
    }

    public Set<Parameter> getUnchanged() {
        return unchanged;
    }

    public Set<Parameter> getCreated() {
        return created;
    }

    public Set<Parameter> getDeleted() {
        return deleted;
    }

    public CompareCriticalType getCompareCriticalType() {
        return compareCriticalType;
    }

    public CompareResultType getCompareResultType() {
        return compareResultType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParametersCompareResult)) return false;
        ParametersCompareResult that = (ParametersCompareResult) o;
        return Objects.equals(getUnchanged(), that.getUnchanged()) &&
                Objects.equals(getCreated(), that.getCreated()) &&
                Objects.equals(getDeleted(), that.getDeleted());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUnchanged(), getCreated(), getDeleted());
    }

    @Override
    public String toString() {
        return "ParametersCompareResult{" +
                "unchanged=" + unchanged +
                ", created=" + created +
                ", deleted=" + deleted +
                ", compareCriticalType=" + compareCriticalType +
                ", compareResultType=" + compareResultType +
                '}';
    }
}
