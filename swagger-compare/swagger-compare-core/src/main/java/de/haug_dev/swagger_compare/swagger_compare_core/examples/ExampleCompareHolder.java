package de.haug_dev.swagger_compare.swagger_compare_core.examples;

import de.haug_dev.swagger_compare.swagger_compare_core.ICompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.examples.Example;
import org.springframework.stereotype.Component;

@Component
public class ExampleCompareHolder implements ICompareHolder<Example> {

    @Override
    public ICompareResult compare(Example left, Example right) {
        Example leftValue = left == null ? new Example() : left;
        Example rightValue = right == null ? new Example() : right;
        NodeCompareResult result = new NodeCompareResult();
        this.compare(leftValue.get$ref(), rightValue.get$ref(), "Ref", CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, result);
        this.compare(leftValue.getSummary(), rightValue.getSummary(), "Summary", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO, CompareCriticalType.INFO, result);
        this.compare(leftValue.getDescription(), rightValue.getDescription(), "Description", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO, CompareCriticalType.INFO, result);
        this.compare(leftValue.getValue(), rightValue.getValue(),"Value", CompareCriticalType.NONE, CompareCriticalType.WARNING, CompareCriticalType.WARNING, CompareCriticalType.WARNING, result);
        this.compare(leftValue.getExternalValue(), rightValue.getExternalValue(), "ExternalValue", CompareCriticalType.NONE, CompareCriticalType.WARNING, CompareCriticalType.WARNING, CompareCriticalType.WARNING, result);
        return result;
    }
}