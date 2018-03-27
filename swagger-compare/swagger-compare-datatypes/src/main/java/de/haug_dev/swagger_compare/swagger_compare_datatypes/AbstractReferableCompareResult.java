package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractReferableCompareResult<BasicType, ExtendedCompareResultType extends IBasicCompareResult> extends AbstractBasicCompareResult{
    private Map<String, BasicType> deleted = new HashMap<>();
    private Map<String, BasicType> created = new HashMap<>();
    private Map<String, BasicType> unchanged = new HashMap<>();
    private Map<String, ExtendedCompareResultType> changed = new HashMap<>();

    public void putDeleted(String key, BasicType value) {
        this.deleted.put(key, value);
        if(this.getCompareResultType().equals(CompareResultType.UNCHANGED)){
            setCompareResultType(CompareResultType.CHANGED);
        }
        setHighestCompareCriticalType(CompareCriticalType.CRITICAL);
    }

    public void putCreated(String key, BasicType value) {
        this.created.put(key, value);
        if(this.getCompareResultType().equals(CompareResultType.UNCHANGED)){
            setCompareResultType(CompareResultType.CHANGED);
        }
        setHighestCompareCriticalType(CompareCriticalType.INFO);
    }

    public void putUnchanged(String key, BasicType value) {
        this.unchanged.put(key, value);
    }

    public void putChanged(String key, ExtendedCompareResultType value) {
        this.changed.put(key, value);
        if(this.getCompareResultType().equals(CompareResultType.UNCHANGED)){
            setCompareResultType(CompareResultType.CHANGED);
        }
        setHighestCompareCriticalType(value.getCompareCriticalType());
    }

    public Map<String, BasicType> getDeleted() {
        return deleted;
    }

    public Map<String, BasicType> getCreated() {
        return created;
    }

    public Map<String, BasicType> getUnchanged() {
        return unchanged;
    }

    public Map<String, ExtendedCompareResultType> getChanged() {
        return changed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractReferableCompareResult)) return false;
        if (!super.equals(o)) return false;
        AbstractReferableCompareResult<?, ?> that = (AbstractReferableCompareResult<?, ?>) o;
        return Objects.equals(getDeleted(), that.getDeleted()) &&
                Objects.equals(getCreated(), that.getCreated()) &&
                Objects.equals(getUnchanged(), that.getUnchanged()) &&
                Objects.equals(getChanged(), that.getChanged());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDeleted(), getCreated(), getUnchanged(), getChanged());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "deleted=" + deleted +
                ", created=" + created +
                ", unchanged=" + unchanged +
                ", changed=" + changed +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                '}';
    }
}
