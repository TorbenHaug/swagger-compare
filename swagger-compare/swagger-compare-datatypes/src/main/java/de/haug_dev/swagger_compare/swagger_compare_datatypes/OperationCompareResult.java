package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class OperationCompareResult {

    private final CompareCriticalType compareCriticalType;
    private final CompareResultType compareResultType;
    private final ParametersCompareResult parametersCompareResult;
    private final DeprecatedCompareResult deprecatedCompareResult;
    private final RequestBodyCompareResult requestBodyCompareResult;
    private final ApiResponsesCompareResult apiResponsesCompareResult;

    public OperationCompareResult(ParametersCompareResult parametersCompareResult,
                                  DeprecatedCompareResult deprecatedCompareResult,
                                  RequestBodyCompareResult requestBodyCompareResult,
                                  ApiResponsesCompareResult apiResponsesCompareResult) {
        this.parametersCompareResult = parametersCompareResult;
        this.deprecatedCompareResult = deprecatedCompareResult;
        this.requestBodyCompareResult = requestBodyCompareResult;
        this.apiResponsesCompareResult = apiResponsesCompareResult;
        if(parametersCompareResult.getCompareResultType() != CompareResultType.UNCHANGED ||
                deprecatedCompareResult.getCompareResultType() != CompareResultType.UNCHANGED ||
                requestBodyCompareResult.getCompareResultType() != CompareResultType.UNCHANGED ||
                apiResponsesCompareResult.getCompareResultType() != CompareResultType.UNCHANGED) {
            compareResultType = CompareResultType.CHANGED;
        }else {
            compareResultType = CompareResultType.UNCHANGED;
        }
        CompareCriticalType tmpCompareCriticalType = CompareCriticalType.NONE;
        if(tmpCompareCriticalType.getLevel() < parametersCompareResult.getCompareCriticalType().getLevel()){
            tmpCompareCriticalType = parametersCompareResult.getCompareCriticalType();
        }
        if(tmpCompareCriticalType.getLevel() < deprecatedCompareResult.getCompareCriticalType().getLevel()){
            tmpCompareCriticalType = deprecatedCompareResult.getCompareCriticalType();
        }
        if(tmpCompareCriticalType.getLevel() < requestBodyCompareResult.getCompareCriticalType().getLevel()){
            tmpCompareCriticalType = requestBodyCompareResult.getCompareCriticalType();
        }
        if(tmpCompareCriticalType.getLevel() < apiResponsesCompareResult.getCompareCriticalType().getLevel()){
            tmpCompareCriticalType = apiResponsesCompareResult.getCompareCriticalType();
        }
        compareCriticalType = tmpCompareCriticalType;
    }

    public CompareCriticalType getCompareCriticalType() {
        return compareCriticalType;
    }

    public CompareResultType getCompareResultType() {
        return compareResultType;
    }

    public ParametersCompareResult getParametersCompareResult() {
        return parametersCompareResult;
    }

    public DeprecatedCompareResult getDeprecatedCompareResult() {
        return deprecatedCompareResult;
    }

    public RequestBodyCompareResult getRequestBodyCompareResult() {
        return requestBodyCompareResult;
    }

    public ApiResponsesCompareResult getApiResponsesCompareResult() {
        return apiResponsesCompareResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationCompareResult)) return false;
        OperationCompareResult that = (OperationCompareResult) o;
        return getCompareCriticalType() == that.getCompareCriticalType() &&
                getCompareResultType() == that.getCompareResultType() &&
                Objects.equals(getParametersCompareResult(), that.getParametersCompareResult()) &&
                Objects.equals(getDeprecatedCompareResult(), that.getDeprecatedCompareResult()) &&
                Objects.equals(getRequestBodyCompareResult(), that.getRequestBodyCompareResult()) &&
                Objects.equals(getApiResponsesCompareResult(), that.getApiResponsesCompareResult());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCompareCriticalType(), getCompareResultType(), getParametersCompareResult(), getDeprecatedCompareResult(), getRequestBodyCompareResult(), getApiResponsesCompareResult());
    }

    @Override
    public String toString() {
        return "OperationCompareResult{" +
                "compareCriticalType=" + compareCriticalType +
                ", compareResultType=" + compareResultType +
                ", parametersCompareResult=" + parametersCompareResult +
                ", deprecatedCompareResult=" + deprecatedCompareResult +
                ", requestBodyCompareResult=" + requestBodyCompareResult +
                ", apiResponsesCompareResult=" + apiResponsesCompareResult +
                '}';
    }
}
