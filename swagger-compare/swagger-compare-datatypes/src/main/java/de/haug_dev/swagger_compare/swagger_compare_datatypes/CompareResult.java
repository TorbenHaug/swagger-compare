package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class CompareResult {
    private final PathsCompareResult pathsCompareResult;
    private CompareResultType compareResultType;
    private CompareCriticalType compareCriticalType = CompareCriticalType.NONE;
    private ComponentsCompareResult componentsCompareResult;

    public CompareResult(PathsCompareResult pathsCompareResult, ComponentsCompareResult componentsCompareResult) {
        this.pathsCompareResult = pathsCompareResult;
        this.componentsCompareResult = componentsCompareResult;
        this.compareResultType = pathsCompareResult.getCompareResultType();
        if(this.compareResultType == CompareResultType.UNCHANGED){
            this.compareResultType = this.componentsCompareResult.getCompareResultType();
        }
        this.compareCriticalType = this.compareCriticalType
                .greater(this.pathsCompareResult.getCompareCriticalType())
                .greater(this.componentsCompareResult.getCompareCriticalType());


    }

    public PathsCompareResult getPathsCompareResult() {
        return pathsCompareResult;
    }

    public ComponentsCompareResult getComponentsCompareResult() {
        return componentsCompareResult;
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
