package de.haug_dev.swagger_compare.swagger_compare_core.callbacks;

import de.haug_dev.swagger_compare.swagger_compare_core.paths.PathItemCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.callbacks.Callback;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class CallbackCompareHolderTest {

    @Test
    public void compare() {
        PathItem pathItemLeft1 = new PathItem();
        PathItem pathItemLeft2 = new PathItem();
        Callback callbackLeft = new Callback();
        callbackLeft.put("callback1", pathItemLeft1);
        callbackLeft.put("callbackLeft2", pathItemLeft2);

        PathItem pathItemRight1 = new PathItem();
        PathItem pathItemRight2 = new PathItem();
        Callback callbackRight = new Callback();
        callbackRight.put("callback1", pathItemRight1);
        callbackRight.put("callbackRight2", pathItemRight2);

        LeafCompareResult compareResult1 = new LeafCompareResult(pathItemLeft1, pathItemRight1, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        LeafCompareResult compareResult2 = new LeafCompareResult(null, pathItemRight2, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        LeafCompareResult compareResult3 = new LeafCompareResult(pathItemLeft2, null, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        PathItemCompareHolder pathItemCompareHolder = Mockito.mock(PathItemCompareHolder.class);
        Mockito.when(pathItemCompareHolder.compare(pathItemLeft1, pathItemRight1)).thenReturn(compareResult1);
        Mockito.when(pathItemCompareHolder.compare(null, pathItemRight2)).thenReturn(compareResult2);
        Mockito.when(pathItemCompareHolder.compare(pathItemLeft2, null)).thenReturn(compareResult3);

        NodeCompareResult expected = new NodeCompareResult();
        expected.put("callback1", compareResult1);
        expected.put("callbackRight2", compareResult2);
        expected.put("callbackLeft2", compareResult3);


        CallbackCompareHolder callbackCompareHolder = new CallbackCompareHolder(pathItemCompareHolder);
        ICompareResult actual = callbackCompareHolder.compare(callbackLeft, callbackRight);

        assertEquals(expected, actual);
    }
}