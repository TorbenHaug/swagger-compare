package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CompareResultTest {

    @Test
    public void testEqual() {
        PathsCompareResult pathsCompareResult = Mockito.mock(PathsCompareResult.class);
        Mockito.when(pathsCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(pathsCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        CompareResult compareResult = new CompareResult(pathsCompareResult);
        assertEquals(CompareResultType.UNCHANGED, compareResult.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, compareResult.getCompareCriticalType());
    }

    @Test
    public void testChanged() {
        PathsCompareResult pathsCompareResult = Mockito.mock(PathsCompareResult.class);
        Mockito.when(pathsCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        Mockito.when(pathsCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
        CompareResult compareResult = new CompareResult(pathsCompareResult);
        assertEquals(CompareResultType.CHANGED, compareResult.getCompareResultType());
        assertEquals(CompareCriticalType.WARNING, compareResult.getCompareCriticalType());
    }
}