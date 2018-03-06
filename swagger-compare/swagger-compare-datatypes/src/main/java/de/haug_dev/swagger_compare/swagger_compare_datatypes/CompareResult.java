package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class CompareResult {
    private final PathsCompareResult pathsCompareResult;
    private final CompareResultType compareResultType;
    private final CompareCriticalType compareCriticalType;

    public CompareResult(PathsCompareResult pathsCompareResult) {
        this.pathsCompareResult = pathsCompareResult;
        this.compareResultType = pathsCompareResult.getCompareResultType();
        this.compareCriticalType = pathsCompareResult.getCompareCriticalType();
    }

    public PathsCompareResult getPathsCompareResult() {
        return pathsCompareResult;
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
        if (!(o instanceof CompareResult)) return false;
        CompareResult that = (CompareResult) o;
        return Objects.equals(getPathsCompareResult(), that.getPathsCompareResult()) &&
                getCompareResultType() == that.getCompareResultType() &&
                getCompareCriticalType() == that.getCompareCriticalType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPathsCompareResult(), getCompareResultType(), getCompareCriticalType());
    }

    @Override
    public String toString() {
        return "CompareResult{" +
                "pathsCompareResult=" + pathsCompareResult +
                ", compareResultType=" + compareResultType +
                ", compareCriticalType=" + compareCriticalType +
                '}';
    }
}
