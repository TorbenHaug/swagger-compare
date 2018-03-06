package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.PathItem;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class PathsCompareResult{
    private final Map<String, PathItem> unchanged = new TreeMap<>();
    private final Map<String, PathItemCompareResult> changed = new TreeMap<>();
    private final Map<String, PathItem> created = new TreeMap<>();
    private final Map<String, PathItem> deleted = new TreeMap<>();
    private CompareResultType compareResultType = CompareResultType.UNCHANGED;
    private CompareCriticalType compareCriticalType = CompareCriticalType.NONE;

    public void putUnchanged(String path, PathItem pathItem){
        unchanged.put(path,pathItem);
    }

    public void putChanged(String path, PathItemCompareResult pathItem){
        changed.put(path,pathItem);
        this.compareResultType = CompareResultType.CHANGED;
        if(this.compareCriticalType.getLevel() < pathItem.getCompareCriticalType().getLevel()){
            this.compareCriticalType = pathItem.getCompareCriticalType();
        }
    }

    public void putCreated(String path, PathItem pathItem){
        created.put(path,pathItem);
        this.compareResultType = CompareResultType.CHANGED;
        if(this.compareCriticalType.getLevel() < CompareCriticalType.INFO.getLevel()){
            this.compareCriticalType = CompareCriticalType.INFO;
        }
    }

    public void putDeleted(String path, PathItem pathItem){
        deleted.put(path,pathItem);
        this.compareResultType = CompareResultType.CHANGED;
        if(this.compareCriticalType.getLevel() < CompareCriticalType.CRITICAL.getLevel()){
            this.compareCriticalType = CompareCriticalType.CRITICAL;
        }
    }

    public Map<String, PathItem> getUnchanged() {
        return unchanged;
    }

    public Map<String, PathItemCompareResult> getChanged() {
        return changed;
    }

    public Map<String, PathItem> getCreated() {
        return created;
    }

    public Map<String, PathItem> getDeleted() {
        return deleted;
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
        if (!(o instanceof PathsCompareResult)) return false;
        PathsCompareResult that = (PathsCompareResult) o;
        return Objects.equals(getUnchanged(), that.getUnchanged()) &&
                Objects.equals(getChanged(), that.getChanged()) &&
                Objects.equals(getCreated(), that.getCreated()) &&
                Objects.equals(getDeleted(), that.getDeleted()) &&
                getCompareResultType() == that.getCompareResultType() &&
                getCompareCriticalType() == that.getCompareCriticalType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUnchanged(), getChanged(), getCreated(), getDeleted(), getCompareResultType(), getCompareCriticalType());
    }

    @Override
    public String toString() {
        return "PathsCompareResult{" +
                "unchanged=" + unchanged +
                ", changed=" + changed +
                ", created=" + created +
                ", deleted=" + deleted +
                ", compareResultType=" + compareResultType +
                ", compareCriticalType=" + compareCriticalType +
                '}';
    }
}
