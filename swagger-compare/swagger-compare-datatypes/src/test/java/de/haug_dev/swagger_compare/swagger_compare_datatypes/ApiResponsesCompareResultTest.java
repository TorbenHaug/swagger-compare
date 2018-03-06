package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.responses.ApiResponses;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApiResponsesCompareResultTest {

    @Test
    public void testEqualValues1() {
        ApiResponses left = null;
        ApiResponses right = null;
        ApiResponsesCompareResult refCompareResult = new ApiResponsesCompareResult(left, right);
        Assert.assertEquals(left, refCompareResult.getLeft());
        Assert.assertEquals(right, refCompareResult.getRight());
        Assert.assertEquals(CompareResultType.UNCHANGED, refCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.NONE, refCompareResult.getCompareCriticalType());
    }

    @Test
    public void testEqualValues2() {
        ApiResponses left = new ApiResponses();
        ApiResponses right = new ApiResponses();
        ApiResponsesCompareResult refCompareResult = new ApiResponsesCompareResult(left, right);
        Assert.assertEquals(left, refCompareResult.getLeft());
        Assert.assertEquals(right, refCompareResult.getRight());
        Assert.assertEquals(CompareResultType.UNCHANGED, refCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.NONE, refCompareResult.getCompareCriticalType());
    }

    @Test
    public void testChangedValues1() {
        ApiResponses left = null;
        ApiResponses right = new ApiResponses();
        ApiResponsesCompareResult refCompareResult = new ApiResponsesCompareResult(left, right);
        Assert.assertEquals(left, refCompareResult.getLeft());
        Assert.assertEquals(right, refCompareResult.getRight());
        Assert.assertEquals(CompareResultType.CHANGED, refCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.CRITICAL, refCompareResult.getCompareCriticalType());
    }

    @Test
    public void testChangedValues2() {
        ApiResponses left = new ApiResponses();
        ApiResponses right = null;
        ApiResponsesCompareResult refCompareResult = new ApiResponsesCompareResult(left, right);
        Assert.assertEquals(left, refCompareResult.getLeft());
        Assert.assertEquals(right, refCompareResult.getRight());
        Assert.assertEquals(CompareResultType.CHANGED, refCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.CRITICAL, refCompareResult.getCompareCriticalType());
    }

}