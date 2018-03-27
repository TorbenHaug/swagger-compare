package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class CompareResult extends AbstractBasicCompareResult{
    private final PathsCompareResult pathsCompareResult;
    private ComponentsCompareResult componentsCompareResult;

    public CompareResult(PathsCompareResult pathsCompareResult, ComponentsCompareResult componentsCompareResult) {
        this.pathsCompareResult = pathsCompareResult;
        this.componentsCompareResult = componentsCompareResult;
        setCompareResultType(pathsCompareResult.getCompareResultType());
        if(this.getCompareResultType() == CompareResultType.UNCHANGED){
            setCompareResultType(this.componentsCompareResult.getCompareResultType());
        }
        setHighestCompareCriticalType(this.pathsCompareResult.getCompareCriticalType());
        setHighestCompareCriticalType(this.componentsCompareResult.getCompareCriticalType());
    }

    public PathsCompareResult getPathsCompareResult() {
        return pathsCompareResult;
    }

    public ComponentsCompareResult getComponentsCompareResult() {
        return componentsCompareResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompareResult)) return false;
        if (!super.equals(o)) return false;
        CompareResult that = (CompareResult) o;
        return Objects.equals(getPathsCompareResult(), that.getPathsCompareResult()) &&
                Objects.equals(getComponentsCompareResult(), that.getComponentsCompareResult());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getPathsCompareResult(), getComponentsCompareResult());
    }

    @Override
    public String toString() {
        return "CompareResult{" +
                "pathsCompareResult=" + pathsCompareResult +
                ", componentsCompareResult=" + componentsCompareResult +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                '}';
    }
}
