package de.haug_dev.swagger_compare.swagger_compare_core.callbacks;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.callbacks.Callback;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CallbacksCompareHolderTest {

    @Test
    public void compare() {
        Callback callbackLeft1 = new Callback();
        Callback callbackLeft2 = new Callback();
        Map<String, Callback> callbacksLeft = new HashMap<>();
        callbacksLeft.put("callback1", callbackLeft1);
        callbacksLeft.put("callbackLeft2", callbackLeft2);

        Callback callbackRight1 = new Callback();
        Callback callbackRight2 = new Callback();
        Map<String, Callback> callbacksRight = new HashMap<>();
        callbacksRight.put("callback1", callbackRight1);
        callbacksRight.put("callbackRight2", callbackRight2);

        LeafCompareResult compareResult1 = new LeafCompareResult(callbackLeft1, callbackRight1, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        LeafCompareResult compareResult2 = new LeafCompareResult(null, callbackRight2, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        LeafCompareResult compareResult3 = new LeafCompareResult(callbackLeft2, null, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        CallbackCompareHolder callbackCompareHolder = Mockito.mock(CallbackCompareHolder.class);
        Mockito.when(callbackCompareHolder.compare(callbackLeft1, callbackRight1)).thenReturn(compareResult1);
        Mockito.when(callbackCompareHolder.compare(null, callbackRight2)).thenReturn(compareResult2);
        Mockito.when(callbackCompareHolder.compare(callbackLeft2, null)).thenReturn(compareResult3);

        NodeCompareResult expected = new NodeCompareResult();
        expected.put("callback1", compareResult1);
        expected.put("callbackRight2", compareResult2);
        expected.put("callbackLeft2", compareResult3);


        CallbacksCompareHolder callbacksCompareHolder = new CallbacksCompareHolder(callbackCompareHolder);
        ICompareResult actual = callbacksCompareHolder.compare(callbacksLeft, callbacksRight);

        assertEquals(expected, actual);
    }
}