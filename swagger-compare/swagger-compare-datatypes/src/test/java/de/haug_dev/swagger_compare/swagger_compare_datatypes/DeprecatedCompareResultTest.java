package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeprecatedCompareResultTest {

    @Test
    public void testNothingChanged1() {
        Boolean left = null;
        Boolean right = null;
        DeprecatedCompareResult deprecatedCompareResult = new DeprecatedCompareResult(left, right);
        assertEquals(CompareResultType.UNCHANGED, deprecatedCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, deprecatedCompareResult.getCompareCriticalType());
    }

    @Test
    public void testNothingChanged2() {
        Boolean left = true;
        Boolean right = true;
        DeprecatedCompareResult deprecatedCompareResult = new DeprecatedCompareResult(left, right);
        assertEquals(CompareResultType.UNCHANGED, deprecatedCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, deprecatedCompareResult.getCompareCriticalType());
    }

    @Test
    public void testNothingChanged3() {
        Boolean left = false;
        Boolean right = false;
        DeprecatedCompareResult deprecatedCompareResult = new DeprecatedCompareResult(left, right);
        assertEquals(CompareResultType.UNCHANGED, deprecatedCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, deprecatedCompareResult.getCompareCriticalType());
    }

    @Test
    public void testNotDeprecated1() {
        Boolean left = true;
        Boolean right = false;
        DeprecatedCompareResult deprecatedCompareResult = new DeprecatedCompareResult(left, right);
        assertEquals(CompareResultType.CHANGED, deprecatedCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.INFO, deprecatedCompareResult.getCompareCriticalType());
    }

    @Test
    public void testNotDeprecated2() {
        Boolean left = null;
        Boolean right = false;
        DeprecatedCompareResult deprecatedCompareResult = new DeprecatedCompareResult(left, right);
        assertEquals(CompareResultType.CHANGED, deprecatedCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.INFO, deprecatedCompareResult.getCompareCriticalType());
    }

    @Test
    public void testNotDeprecated3() {
        Boolean left = true;
        Boolean right = null;
        DeprecatedCompareResult deprecatedCompareResult = new DeprecatedCompareResult(left, right);
        assertEquals(CompareResultType.CHANGED, deprecatedCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.INFO, deprecatedCompareResult.getCompareCriticalType());
    }

    @Test
    public void testDeprecated1() {
        Boolean left = false;
        Boolean right = true;
        DeprecatedCompareResult deprecatedCompareResult = new DeprecatedCompareResult(left, right);
        assertEquals(CompareResultType.CHANGED, deprecatedCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.WARNING, deprecatedCompareResult.getCompareCriticalType());
    }
    @Test
    public void testDeprecated2() {
        Boolean left = null;
        Boolean right = true;
        DeprecatedCompareResult deprecatedCompareResult = new DeprecatedCompareResult(left, right);
        assertEquals(CompareResultType.CHANGED, deprecatedCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.WARNING, deprecatedCompareResult.getCompareCriticalType());
    }

}