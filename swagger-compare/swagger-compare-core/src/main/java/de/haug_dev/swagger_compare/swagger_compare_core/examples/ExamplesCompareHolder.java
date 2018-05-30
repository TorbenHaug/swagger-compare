package de.haug_dev.swagger_compare.swagger_compare_core.examples;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.examples.Example;

import java.util.HashMap;
import java.util.Map;

public class ExamplesCompareHolder extends AbstractCompareHolder<Map<String, Example>> {

    private ExampleCompareHolder exampleCompareHolder;

    public ExamplesCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.exampleCompareHolder = compareHolderFactory.getExampleCompareHolder();
    }

    @Override
    public ICompareResult compare(Map<String, Example> left, Map<String, Example> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, Example> leftValue = left == null ? new HashMap<>() : left;
        Map<String, Example> rightValue = right == null ? new HashMap<>() : right;
        return this.referableCompare(leftValue, rightValue, exampleCompareHolder, created, deleted);
    }
}
