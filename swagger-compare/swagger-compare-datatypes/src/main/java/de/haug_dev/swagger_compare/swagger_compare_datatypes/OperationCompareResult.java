package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class OperationCompareResult extends AbstractBasicCompareResult{

    private final ParametersCompareResult parametersCompareResult;
    private final DeprecatedCompareResult deprecatedCompareResult;
    private final RequestBodyCompareResult requestBodyCompareResult;
    private final ResponsesCompareResult responsesCompareResult;

    public OperationCompareResult(ParametersCompareResult parametersCompareResult,
                                  DeprecatedCompareResult deprecatedCompareResult,
                                  RequestBodyCompareResult requestBodyCompareResult,
                                  ResponsesCompareResult apiResponsesCompareResult) {
        this.parametersCompareResult = parametersCompareResult;
        this.deprecatedCompareResult = deprecatedCompareResult;
        this.requestBodyCompareResult = requestBodyCompareResult;
        this.responsesCompareResult = apiResponsesCompareResult;
        if(parametersCompareResult.getCompareResultType() != CompareResultType.UNCHANGED ||
                deprecatedCompareResult.getCompareResultType() != CompareResultType.UNCHANGED ||
                requestBodyCompareResult.getCompareResultType() != CompareResultType.UNCHANGED ||
                apiResponsesCompareResult.getCompareResultType() != CompareResultType.UNCHANGED) {
            setCompareResultType(CompareResultType.CHANGED);
        }else {
            setCompareResultType(CompareResultType.UNCHANGED);
        }
        setHighestCompareCriticalType(this.parametersCompareResult.getCompareCriticalType());
        setHighestCompareCriticalType(this.deprecatedCompareResult.getCompareCriticalType());
        setHighestCompareCriticalType(this.requestBodyCompareResult.getCompareCriticalType());
        setHighestCompareCriticalType(this.responsesCompareResult.getCompareCriticalType());
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

    public ResponsesCompareResult getResponsesCompareResult() {
        return responsesCompareResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationCompareResult)) return false;
        if (!super.equals(o)) return false;
        OperationCompareResult that = (OperationCompareResult) o;
        return Objects.equals(getParametersCompareResult(), that.getParametersCompareResult()) &&
                Objects.equals(getDeprecatedCompareResult(), that.getDeprecatedCompareResult()) &&
                Objects.equals(getRequestBodyCompareResult(), that.getRequestBodyCompareResult()) &&
                Objects.equals(getResponsesCompareResult(), that.getResponsesCompareResult());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getParametersCompareResult(), getDeprecatedCompareResult(), getRequestBodyCompareResult(), getResponsesCompareResult());
    }

    @Override
    public String toString() {
        return "OperationCompareResult{" +
                "parametersCompareResult=" + parametersCompareResult +
                ", deprecatedCompareResult=" + deprecatedCompareResult +
                ", requestBodyCompareResult=" + requestBodyCompareResult +
                ", responsesCompareResult=" + responsesCompareResult +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                '}';
    }
}
