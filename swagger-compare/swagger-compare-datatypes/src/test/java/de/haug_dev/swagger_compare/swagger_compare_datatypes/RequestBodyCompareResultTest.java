package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.parameters.RequestBody;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestBodyCompareResultTest {
    @Test
    public void testEqualValues() {
        RequestBody left = new RequestBody();
        RequestBody right = new RequestBody();
        RequestBodyCompareResult requestBodyCompareResult = new RequestBodyCompareResult(left, right);
        Assert.assertEquals(left, requestBodyCompareResult.getLeft());
        Assert.assertEquals(right, requestBodyCompareResult.getRight());
        Assert.assertEquals(CompareResultType.UNCHANGED, requestBodyCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.NONE, requestBodyCompareResult.getCompareCriticalType());
    }
    @Test
    public void testEqualNull() {
        RequestBody left = null;
        RequestBody right = null;
        RequestBodyCompareResult requestBodyCompareResult = new RequestBodyCompareResult(left, right);
        Assert.assertEquals(left, requestBodyCompareResult.getLeft());
        Assert.assertEquals(right, requestBodyCompareResult.getRight());
        Assert.assertEquals(CompareResultType.UNCHANGED, requestBodyCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.NONE, requestBodyCompareResult.getCompareCriticalType());
    }

    @Test
    public void testChangedValues() {
        RequestBody left = new RequestBody();
        RequestBody right = new RequestBody();
        right.$ref("/dddddd/");
        RequestBodyCompareResult requestBodyCompareResult = new RequestBodyCompareResult(left, right);
        Assert.assertEquals(left, requestBodyCompareResult.getLeft());
        Assert.assertEquals(right, requestBodyCompareResult.getRight());
        Assert.assertEquals(CompareResultType.CHANGED, requestBodyCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.CRITICAL, requestBodyCompareResult.getCompareCriticalType());
    }
    @Test
    public void testCreatedValues() {
        RequestBody left = null;
        RequestBody right = new RequestBody();
        RequestBodyCompareResult requestBodyCompareResult = new RequestBodyCompareResult(left, right);
        Assert.assertEquals(left, requestBodyCompareResult.getLeft());
        Assert.assertEquals(right, requestBodyCompareResult.getRight());
        Assert.assertEquals(CompareResultType.CREATED, requestBodyCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.CRITICAL, requestBodyCompareResult.getCompareCriticalType());
    }

    @Test
    public void testDeletedValues() {
        RequestBody left = new RequestBody();
        RequestBody right = null;
        RequestBodyCompareResult requestBodyCompareResult = new RequestBodyCompareResult(left, right);
        Assert.assertEquals(left, requestBodyCompareResult.getLeft());
        Assert.assertEquals(right, requestBodyCompareResult.getRight());
        Assert.assertEquals(CompareResultType.DELETED, requestBodyCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.CRITICAL, requestBodyCompareResult.getCompareCriticalType());
    }
}