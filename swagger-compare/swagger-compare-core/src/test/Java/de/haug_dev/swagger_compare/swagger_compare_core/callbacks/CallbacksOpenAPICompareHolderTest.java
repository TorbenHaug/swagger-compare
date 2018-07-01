package de.haug_dev.swagger_compare.swagger_compare_core.callbacks;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.callbacks.Callback;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CallbacksOpenAPICompareHolderTest {

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
        Mockito.when(callbackCompareHolder.compare(eq(callbackLeft1), eq(callbackRight1), any(), any())).thenReturn(compareResult1);
        Mockito.when(callbackCompareHolder.compare(eq(null), eq(callbackRight2), any(), any())).thenReturn(compareResult2);
        Mockito.when(callbackCompareHolder.compare(eq(callbackLeft2), eq(null), any(), any())).thenReturn(compareResult3);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("callback1", compareResult1);
        expected.put("callbackRight2", compareResult2);
        expected.put("callbackLeft2", compareResult3);


        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getCallbackCompareHolder()).thenReturn(callbackCompareHolder);

        CallbacksCompareHolder callbacksCompareHolder = new CallbacksCompareHolder(compareHolderFactory);
        ICompareResult actual = callbacksCompareHolder.compare(callbacksLeft, callbacksRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }
}