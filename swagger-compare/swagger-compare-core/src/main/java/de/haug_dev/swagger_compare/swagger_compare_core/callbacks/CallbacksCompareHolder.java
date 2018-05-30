package de.haug_dev.swagger_compare.swagger_compare_core.callbacks;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.callbacks.Callback;

import java.util.HashMap;
import java.util.Map;

public class CallbacksCompareHolder extends AbstractCompareHolder<Map<String, Callback>> {


    private CompareHolderFactory compareHolderFactory;

    public CallbacksCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Map<String, Callback> left, Map<String, Callback> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, Callback> leftValue = left == null ? new HashMap<>() : left;
        Map<String, Callback> rightValue = right == null ? new HashMap<>() : right;

        CallbackCompareHolder callbackCompareHolder = compareHolderFactory.getCallbackCompareHolder();

        return this.referableCompare(leftValue, rightValue, callbackCompareHolder, created, deleted);
    }
}
