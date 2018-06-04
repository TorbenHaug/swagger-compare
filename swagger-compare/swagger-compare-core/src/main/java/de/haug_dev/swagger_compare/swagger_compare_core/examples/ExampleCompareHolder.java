package de.haug_dev.swagger_compare.swagger_compare_core.examples;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.examples.Example;

public class ExampleCompareHolder extends AbstractCompareHolder<Example> {

    @Override
    public ICompareResult compare(Example left, Example right, CompareCriticalType created, CompareCriticalType deleted) {
        Example leftValue = left == null ? new Example() : left;
        Example rightValue = right == null ? new Example() : right;
        NodeCompareResult result = new NodeCompareResult(created, deleted);
        this.leafCompare(leftValue.get$ref(), rightValue.get$ref(), "Ref", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, result);
        this.leafCompare(leftValue.getSummary(), rightValue.getSummary(), "Summary", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO, CompareCriticalType.INFO, result);
        this.leafCompare(leftValue.getDescription(), rightValue.getDescription(), "Description", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO, CompareCriticalType.INFO, result);
        this.leafCompare(leftValue.getValue(), rightValue.getValue(), "Value", CompareCriticalType.NONE, CompareCriticalType.WARNING, CompareCriticalType.WARNING, CompareCriticalType.WARNING, result);
        this.leafCompare(leftValue.getExternalValue(), rightValue.getExternalValue(), "ExternalValue", CompareCriticalType.NONE, CompareCriticalType.WARNING, CompareCriticalType.WARNING, CompareCriticalType.WARNING, result);
        return result;
    }
}
