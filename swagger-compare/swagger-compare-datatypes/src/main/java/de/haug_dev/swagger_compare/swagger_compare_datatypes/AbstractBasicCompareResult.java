package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public abstract class AbstractBasicCompareResult implements IBasicCompareResult {

    private CompareResultType compareResultType = CompareResultType.UNCHANGED;
    private CompareCriticalType compareCriticalType = CompareCriticalType.NONE;

    @Override
    public CompareCriticalType getCompareCriticalType() {
        return this.compareCriticalType;
    }

    protected void setHighestCompareCriticalType(CompareCriticalType compareCriticalType){
        this.compareCriticalType = this.compareCriticalType.greater(compareCriticalType);
    }

    @Override
    public CompareResultType getCompareResultType() {
        return this.compareResultType;
    }

    protected void setCompareResultType(CompareResultType compareResultType){
        this.compareResultType = compareResultType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractBasicCompareResult)) return false;
        AbstractBasicCompareResult that = (AbstractBasicCompareResult) o;
        return getCompareResultType() == that.getCompareResultType() &&
                getCompareCriticalType() == that.getCompareCriticalType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCompareResultType(), getCompareCriticalType());
    }


}
