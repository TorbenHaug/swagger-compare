package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.Operation;

import java.util.ArrayList;

public class OperationCompareHolder {
    private final ParametersCompareHolder parametersCompareHolder;
    private final ResponsesCompareHolder responsesCompareHolder;
    private Operation operation;

    public OperationCompareHolder(Operation operation) {
        this.operation = (operation == null ? new Operation() : operation);
        this.parametersCompareHolder = new ParametersCompareHolder(this.operation.getParameters());
        this.responsesCompareHolder = new ResponsesCompareHolder(this.operation.getResponses());
    }

    public OperationCompareResult compare(OperationCompareHolder other) {
        ParametersCompareResult parametersCompareResult = this.parametersCompareHolder.compare(other.parametersCompareHolder);
        DeprecatedCompareResult deprecatedCompareResult = new DeprecatedCompareResult(this.operation.getDeprecated(), other.operation.getDeprecated());
        RequestBodyCompareResult requestBodyCompareResult = new RequestBodyCompareResult(this.operation.getRequestBody(), other.operation.getRequestBody());
        ResponsesCompareResult responsesCompareResult = this.responsesCompareHolder.compare(other.responsesCompareHolder);
        return new OperationCompareResult(parametersCompareResult, deprecatedCompareResult, requestBodyCompareResult, responsesCompareResult);
    }
}
