package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import org.junit.Assert;
import org.junit.Test;

public class RefCompareResultTest {

    @Test
    public void testEqualValues() {
        String left = "test";
        String right = "test";
        RefCompareResult refCompareResult = new RefCompareResult(left, right);
        Assert.assertEquals(left, refCompareResult.getLeft());
        Assert.assertEquals(right, refCompareResult.getRight());
        Assert.assertEquals(CompareResultType.UNCHANGED, refCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.NONE, refCompareResult.getCompareCriticalType());
    }
    @Test
    public void testEqualNull() {
        String left = null;
        String right = null;
        RefCompareResult refCompareResult = new RefCompareResult(left, right);
        Assert.assertEquals(left, refCompareResult.getLeft());
        Assert.assertEquals(right, refCompareResult.getRight());
        Assert.assertEquals(CompareResultType.UNCHANGED, refCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.NONE, refCompareResult.getCompareCriticalType());
    }

    @Test
    public void testChangedValues() {
        String left = "test";
        String right = "test1";
        RefCompareResult refCompareResult = new RefCompareResult(left, right);
        Assert.assertEquals(left, refCompareResult.getLeft());
        Assert.assertEquals(right, refCompareResult.getRight());
        Assert.assertEquals(CompareResultType.CHANGED, refCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.CRITICAL, refCompareResult.getCompareCriticalType());
    }
    @Test
    public void testCreatedValues() {
        String left = null;
        String right = "test1";
        RefCompareResult refCompareResult = new RefCompareResult(left, right);
        Assert.assertEquals(left, refCompareResult.getLeft());
        Assert.assertEquals(right, refCompareResult.getRight());
        Assert.assertEquals(CompareResultType.CREATED, refCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.CRITICAL, refCompareResult.getCompareCriticalType());
    }

    @Test
    public void testDeletedValues() {
        String left = "test";
        String right = null;
        RefCompareResult refCompareResult = new RefCompareResult(left, right);
        Assert.assertEquals(left, refCompareResult.getLeft());
        Assert.assertEquals(right, refCompareResult.getRight());
        Assert.assertEquals(CompareResultType.DELETED, refCompareResult.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.CRITICAL, refCompareResult.getCompareCriticalType());
    }
}