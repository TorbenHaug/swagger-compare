package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class DeprecatedCompareResult {
    private final CompareResultType compareResultType;
    private final CompareCriticalType compareCriticalType;
    private Boolean left;
    private Boolean right;

    public DeprecatedCompareResult(Boolean left, Boolean right) {
        this.left = left;
        this.right = right;
        if(Objects.equals(left,right)){
            this.compareResultType = CompareResultType.UNCHANGED;
            this.compareCriticalType = CompareCriticalType.NONE;
        }else{
            if((left == null|| left.equals(false)) && right.equals(true)){
                this.compareResultType = CompareResultType.CHANGED;
                this.compareCriticalType = CompareCriticalType.WARNING;
            } else {
                this.compareResultType = CompareResultType.CHANGED;
                this.compareCriticalType = CompareCriticalType.INFO;
            }
        }
    }

    public CompareResultType getCompareResultType() {
        return compareResultType;
    }

    public CompareCriticalType getCompareCriticalType() {
        return compareCriticalType;
    }

    public Boolean getLeft() {
        return left;
    }

    public Boolean getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeprecatedCompareResult)) return false;
        DeprecatedCompareResult that = (DeprecatedCompareResult) o;
        return getCompareResultType() == that.getCompareResultType() &&
                getCompareCriticalType() == that.getCompareCriticalType() &&
                Objects.equals(getLeft(), that.getLeft()) &&
                Objects.equals(getRight(), that.getRight());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCompareResultType(), getCompareCriticalType(), getLeft(), getRight());
    }

    @Override
    public String toString() {
        return "DeprecatedCompareResult{" +
                "compareResultType=" + compareResultType +
                ", compareCriticalType=" + compareCriticalType +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
