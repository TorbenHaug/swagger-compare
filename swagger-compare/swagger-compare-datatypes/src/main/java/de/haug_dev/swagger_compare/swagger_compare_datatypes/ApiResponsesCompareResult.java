package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponses;

import java.util.Objects;

public class ApiResponsesCompareResult {
    private final ApiResponses left;
    private final ApiResponses right;
    private final CompareResultType compareResultType;
    private final CompareCriticalType compareCriticalType;

    public ApiResponsesCompareResult(ApiResponses left, ApiResponses right) {
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

    public ApiResponses getLeft() {
        return left;
    }

    public ApiResponses getRight() {
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
        if (!(o instanceof ApiResponsesCompareResult)) return false;
        ApiResponsesCompareResult that = (ApiResponsesCompareResult) o;
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
        return "ApiResponsesCompareResult{" +
                "left=" + left +
                ", right=" + right +
                ", compareResultType=" + compareResultType +
                ", compareCriticalType=" + compareCriticalType +
                '}';
    }
}
