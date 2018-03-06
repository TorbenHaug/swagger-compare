package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.parameters.RequestBody;

import java.util.Objects;

public class RequestBodyCompareResult {
    private final RequestBody left;
    private final RequestBody right;
    private final CompareResultType compareResultType;
    private final CompareCriticalType compareCriticalType;

    public RequestBodyCompareResult(RequestBody left, RequestBody right) {
        this.left = left;
        this.right = right;
        if(Objects.equals(left,right)){
            this.compareResultType = CompareResultType.UNCHANGED;
            this.compareCriticalType = CompareCriticalType.NONE;
        } else {
            this.compareResultType = CompareResultType.CHANGED;
            this.compareCriticalType = CompareCriticalType.CRITICAL;
        }
    }

    public RequestBody getLeft() {
        return left;
    }

    public RequestBody getRight() {
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
        if (!(o instanceof RequestBodyCompareResult)) return false;
        RequestBodyCompareResult that = (RequestBodyCompareResult) o;
        return Objects.equals(getLeft(), that.getLeft()) &&
                Objects.equals(getRight(), that.getRight()) &&
                getCompareResultType() == that.getCompareResultType() &&
                getCompareCriticalType() == that.getCompareCriticalType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getLeft(), getRight(), getCompareResultType(), getCompareCriticalType());
    }
}
