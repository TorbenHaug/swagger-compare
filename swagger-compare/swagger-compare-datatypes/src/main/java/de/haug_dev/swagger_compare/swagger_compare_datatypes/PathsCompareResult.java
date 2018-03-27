package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.PathItem;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class PathsCompareResult extends AbstractBasicCompareResult{
    private final Map<String, PathItem> unchanged = new TreeMap<>();
    private final Map<String, PathItemCompareResult> changed = new TreeMap<>();
    private final Map<String, PathItem> created = new TreeMap<>();
    private final Map<String, PathItem> deleted = new TreeMap<>();

    public void putUnchanged(String path, PathItem pathItem){
        unchanged.put(path,pathItem);
    }

    public void putChanged(String path, PathItemCompareResult pathItem){
        changed.put(path,pathItem);
        setCompareResultType(CompareResultType.CHANGED);
        setHighestCompareCriticalType(pathItem.getCompareCriticalType());
    }

    public void putCreated(String path, PathItem pathItem){
        created.put(path,pathItem);
        setCompareResultType(CompareResultType.CHANGED);
        setHighestCompareCriticalType(CompareCriticalType.INFO);
    }

    public void putDeleted(String path, PathItem pathItem){
        deleted.put(path,pathItem);
        setCompareResultType(CompareResultType.CHANGED);
        setHighestCompareCriticalType(CompareCriticalType.CRITICAL);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PathsCompareResult)) return false;
        if (!super.equals(o)) return false;
        PathsCompareResult that = (PathsCompareResult) o;
        return Objects.equals(getUnchanged(), that.getUnchanged()) &&
                Objects.equals(getChanged(), that.getChanged()) &&
                Objects.equals(getCreated(), that.getCreated()) &&
                Objects.equals(getDeleted(), that.getDeleted());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getUnchanged(), getChanged(), getCreated(), getDeleted());
    }

    @Override
    public String toString() {
        return "PathsCompareResult{" +
                "unchanged=" + unchanged +
                ", changed=" + changed +
                ", created=" + created +
                ", deleted=" + deleted +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                '}';
    }
}
