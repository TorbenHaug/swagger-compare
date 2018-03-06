package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class RefCompareResult {

    private final String left;
    private final String right;
    private final CompareResultType compareResultType;
    private final CompareCriticalType compareCriticalType;

    public RefCompareResult(String left, String right) {
        this.left = left;
        this.right = right;
        if(Objects.equals(left,right)){
            this.compareResultType = CompareResultType.UNCHANGED;
            this.compareCriticalType = CompareCriticalType.NONE;
        }else{
            if(left == null){
                this.compareResultType = CompareResultType.CREATED;
                this.compareCriticalType = CompareCriticalType.CRITICAL;
            } else if(right == null){
                this.compareResultType = CompareResultType.DELETED;
                this.compareCriticalType = CompareCriticalType.CRITICAL;
            } else {

                this.compareResultType = CompareResultType.CHANGED;
                this.compareCriticalType = CompareCriticalType.CRITICAL;
            }
        }
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
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
        if (!(o instanceof RefCompareResult)) return false;
        RefCompareResult that = (RefCompareResult) o;
        return Objects.equals(getLeft(), that.getLeft()) &&
                Objects.equals(getRight(), that.getRight()) &&
                getCompareResultType() == that.getCompareResultType() &&
                getCompareCriticalType() == that.getCompareCriticalType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeft(), getRight(), getCompareResultType(), getCompareCriticalType());
    }

    @Override
    public String toString() {
        return "RefCompareResult{" +
                "left='" + left + '\'' +
                ", right='" + right + '\'' +
                ", compareResultType=" + compareResultType +
                ", compareCriticalType=" + compareCriticalType +
                '}';
    }
}
