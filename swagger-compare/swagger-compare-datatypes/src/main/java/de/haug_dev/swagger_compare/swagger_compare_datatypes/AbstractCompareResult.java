package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class AbstractCompareResult implements ICompareResult {

    private CompareResultType compareResultType = CompareResultType.UNCHANGED;
    private CompareCriticalType compareCriticalType = CompareCriticalType.NONE;
    private final CompareType compareType;

    public AbstractCompareResult(CompareType compareType){
        this.compareType = compareType;
    }

    @Override
    public CompareCriticalType getCompareCriticalType() {
        return this.compareCriticalType;
    }

    protected void setHighestCompareCriticalType(CompareCriticalType compareCriticalType) {
        this.compareCriticalType = this.compareCriticalType.greater(compareCriticalType);
    }

    @Override
    public CompareResultType getCompareResultType() {
        return this.compareResultType;
    }

    protected void setCompareResultType(CompareResultType compareResultType) {
        this.compareResultType = compareResultType;
    }

    @Override
    public CompareType getCompareType() {
        return this.compareType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCompareResult)) return false;
        AbstractCompareResult that = (AbstractCompareResult) o;
        return getCompareResultType() == that.getCompareResultType() &&
                getCompareCriticalType() == that.getCompareCriticalType() &&
                getCompareType() == that.getCompareType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCompareResultType(), getCompareCriticalType(), getCompareType());
    }

    @Override
    public String toString() {
        return "AbstractCompareResult{" +
                "compareResultType=" + compareResultType +
                ", compareCriticalType=" + compareCriticalType +
                ", compareType=" + compareType +
                '}';
    }
}
