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
        ComponentsCompareResult compontsCompareResult = Mockito.mock(ComponentsCompareResult.class);
        Mockito.when(compontsCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(compontsCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        CompareResult compareResult = new CompareResult(pathsCompareResult, compontsCompareResult);
        assertEquals(CompareResultType.UNCHANGED, compareResult.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, compareResult.getCompareCriticalType());
    }

    @Test
    public void testChangedPathsCompareResult() {
        PathsCompareResult pathsCompareResult = Mockito.mock(PathsCompareResult.class);
        Mockito.when(pathsCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        Mockito.when(pathsCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
        ComponentsCompareResult compontsCompareResult = Mockito.mock(ComponentsCompareResult.class);
        Mockito.when(compontsCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(compontsCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        CompareResult compareResult = new CompareResult(pathsCompareResult, compontsCompareResult);
        assertEquals(CompareResultType.CHANGED, compareResult.getCompareResultType());
        assertEquals(CompareCriticalType.WARNING, compareResult.getCompareCriticalType());
    }

    @Test
    public void testChangedComponentsCompareResult() {
        PathsCompareResult pathsCompareResult = Mockito.mock(PathsCompareResult.class);
        Mockito.when(pathsCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(pathsCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        ComponentsCompareResult compontsCompareResult = Mockito.mock(ComponentsCompareResult.class);
        Mockito.when(compontsCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        Mockito.when(compontsCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
        CompareResult compareResult = new CompareResult(pathsCompareResult, compontsCompareResult);
        assertEquals(CompareResultType.CHANGED, compareResult.getCompareResultType());
        assertEquals(CompareCriticalType.WARNING, compareResult.getCompareCriticalType());
    }
}