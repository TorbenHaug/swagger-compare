package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.Objects;
import java.util.Set;

public class ParametersCompareResult extends AbstractBasicCompareResult{
    private final Set<Parameter> unchanged;
    private final Set<Parameter> created;
    private final Set<Parameter> deleted;

    public ParametersCompareResult(Set<Parameter> unchanged, Set<Parameter> created, Set<Parameter> deleted) {
        this.unchanged = unchanged;
        this.created = created;
        this.deleted = deleted;
        if(!created.isEmpty() || !deleted.isEmpty()){
            setCompareResultType(CompareResultType.CHANGED);
            setHighestCompareCriticalType(CompareCriticalType.CRITICAL);
        } else {
            setCompareResultType(CompareResultType.UNCHANGED);
            setHighestCompareCriticalType(CompareCriticalType.NONE);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParametersCompareResult)) return false;
        if (!super.equals(o)) return false;
        ParametersCompareResult that = (ParametersCompareResult) o;
        return Objects.equals(getUnchanged(), that.getUnchanged()) &&
                Objects.equals(getCreated(), that.getCreated()) &&
                Objects.equals(getDeleted(), that.getDeleted());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getUnchanged(), getCreated(), getDeleted());
    }

    @Override
    public String toString() {
        return "ParametersCompareResult{" +
                "unchanged=" + unchanged +
                ", created=" + created +
                ", deleted=" + deleted +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                '}';
    }
}
