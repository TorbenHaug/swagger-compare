package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.media.Schema;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ComponentsSchemaCompareResult {
    private Map<String, Schema> deleted = new HashMap<>();
    private Map<String, Schema> created = new HashMap<>();
    private Map<String, Schema> unchanged = new HashMap<>();
    private Map<String, SchemaCompareResult> changed = new HashMap<>();
    private CompareResultType compareResultType = CompareResultType.UNCHANGED;
    private CompareCriticalType compareCriticalType = CompareCriticalType.NONE;

    public void putDeleted(String key, Schema value) {
        this.deleted.put(key, value);
        if(this.compareResultType.equals(CompareResultType.UNCHANGED)){
            this.compareResultType = CompareResultType.CHANGED;
        }
        this.compareCriticalType = this.compareCriticalType.greater(CompareCriticalType.CRITICAL);
    }

    public void putCreated(String key, Schema value) {
        this.created.put(key, value);
        if(this.compareResultType.equals(CompareResultType.UNCHANGED)){
            this.compareResultType = CompareResultType.CHANGED;
        }
        this.compareCriticalType = this.compareCriticalType.greater(CompareCriticalType.INFO);
    }

    public void putUnchanged(String key, Schema value) {
        this.unchanged.put(key, value);
    }

    public void putChanged(String key, SchemaCompareResult value) {
        this.changed.put(key, value);
        if(this.compareResultType.equals(CompareResultType.UNCHANGED)){
            this.compareResultType = CompareResultType.CHANGED;
        }
        this.compareCriticalType = this.compareCriticalType.greater(value.getCompareCriticalType());
    }

    public Map<String, Schema> getDeleted() {
        return deleted;
    }

    public Map<String, Schema> getCreated() {
        return created;
    }

    public Map<String, Schema> getUnchanged() {
        return unchanged;
    }

    public Map<String, SchemaCompareResult> getChanged() {
        return changed;
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
        if (!(o instanceof ComponentsSchemaCompareResult)) return false;
        ComponentsSchemaCompareResult that = (ComponentsSchemaCompareResult) o;
        return Objects.equals(getDeleted(), that.getDeleted()) &&
                Objects.equals(getCreated(), that.getCreated()) &&
                Objects.equals(getUnchanged(), that.getUnchanged()) &&
                Objects.equals(getChanged(), that.getChanged()) &&
                getCompareResultType() == that.getCompareResultType() &&
                getCompareCriticalType() == that.getCompareCriticalType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDeleted(), getCreated(), getUnchanged(), getChanged(), getCompareResultType(), getCompareCriticalType());
    }

    @Override
    public String toString() {
        return "ComponentsSchemaCompareResult{" +
                "deleted=" + deleted +
                ", created=" + created +
                ", unchanged=" + unchanged +
                ", changed=" + changed +
                ", compareResultType=" + compareResultType +
                ", compareCriticalType=" + compareCriticalType +
                '}';
    }
}
