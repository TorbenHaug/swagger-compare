package de.haug_dev.swagger_compare.swagger_compare_core.callbacks;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.callbacks.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CallbacksCompareHolder extends AbstractCompareHolder<Map<String, Callback>> {

    private CallbackCompareHolder callbackCompareHolder;

    @Autowired
    public CallbacksCompareHolder(CallbackCompareHolder callbackCompareHolder){
        this.callbackCompareHolder = callbackCompareHolder;
    }

    @Override
    public ICompareResult compare(Map<String, Callback> left, Map<String, Callback> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, Callback> leftValue = left == null ? new HashMap<>() : left;
        Map<String, Callback> rightValue = right == null ? new HashMap<>() : right;
        return this.referableCompare(leftValue, rightValue, callbackCompareHolder, created, deleted);
    }
}
