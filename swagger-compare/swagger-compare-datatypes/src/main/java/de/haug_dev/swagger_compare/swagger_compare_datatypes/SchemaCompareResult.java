package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.media.Schema;

import java.util.Objects;

public class SchemaCompareResult {
    private final Schema left;
    private final Schema right;
    private final CompareResultType compareResultType;
    private final CompareCriticalType compareCriticalType;

    public SchemaCompareResult(Schema left, Schema right) {
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

    public Schema getLeft() {
        return left;
    }

    public Schema getRight() {
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
        if (!(o instanceof SchemaCompareResult)) return false;
        SchemaCompareResult that = (SchemaCompareResult) o;
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
        return "SchemaCompareResult{" +
                "left=" + left +
                ", right=" + right +
                ", compareResultType=" + compareResultType +
                ", compareCriticalType=" + compareCriticalType +
                '}';
    }
}
