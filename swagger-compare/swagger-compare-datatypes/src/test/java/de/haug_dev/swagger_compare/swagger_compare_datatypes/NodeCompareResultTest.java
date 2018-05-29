package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.TreeMap;

import static org.junit.Assert.*;

public class NodeCompareResultTest {

    @Test
    public void testEmptyNode() {

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.WARNING);

        TreeMap<String, ICompareResult> expectedValues = new TreeMap<>();

        assertEquals(expectedValues, actual.getValues());
        assertEquals(CompareResultType.UNCHANGED, actual.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, actual.getCompareCriticalType());
        assertEquals(CompareType.NODE, actual.getCompareType());
    }

    @Test
    public void testNodeAddOneValue() {

        ICompareResult compareResult1 = Mockito.mock(ICompareResult.class);
        Mockito.when(compareResult1.getCompareCriticalType()).thenReturn(CompareCriticalType.INFO);
        Mockito.when(compareResult1.getCompareResultType()).thenReturn(CompareResultType.CREATED);
        Mockito.when(compareResult1.getCompareType()).thenReturn(CompareType.LEAF);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.WARNING);
        actual.put("compareResult1", compareResult1);

        TreeMap<String, ICompareResult> expectedValues = new TreeMap<>();
        expectedValues.put("compareResult1", compareResult1);

        assertEquals(expectedValues, actual.getValues());
        assertEquals(CompareResultType.CREATED, actual.getCompareResultType());
        assertEquals(CompareCriticalType.INFO, actual.getCompareCriticalType());
        assertEquals(CompareType.NODE, actual.getCompareType());
    }

    @Test
    public void testNodeAddTwoValues1() {

        ICompareResult compareResult1 = Mockito.mock(ICompareResult.class);
        Mockito.when(compareResult1.getCompareCriticalType()).thenReturn(CompareCriticalType.INFO);
        Mockito.when(compareResult1.getCompareResultType()).thenReturn(CompareResultType.CREATED);
        Mockito.when(compareResult1.getCompareType()).thenReturn(CompareType.LEAF);

        ICompareResult compareResult2 = Mockito.mock(ICompareResult.class);
        Mockito.when(compareResult2.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
        Mockito.when(compareResult2.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        Mockito.when(compareResult2.getCompareType()).thenReturn(CompareType.LEAF);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.WARNING);
        actual.put("compareResult1", compareResult1);
        actual.put("compareResult2", compareResult2);

        TreeMap<String, ICompareResult> expectedValues = new TreeMap<>();
        expectedValues.put("compareResult1", compareResult1);
        expectedValues.put("compareResult2", compareResult2);

        assertEquals(expectedValues, actual.getValues());
        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
        assertEquals(CompareCriticalType.WARNING, actual.getCompareCriticalType());
        assertEquals(CompareType.NODE, actual.getCompareType());
    }

    @Test
    public void testNodeAddTwoValues2() {

        ICompareResult compareResult1 = Mockito.mock(ICompareResult.class);
        Mockito.when(compareResult1.getCompareCriticalType()).thenReturn(CompareCriticalType.INFO);
        Mockito.when(compareResult1.getCompareResultType()).thenReturn(CompareResultType.CREATED);
        Mockito.when(compareResult1.getCompareType()).thenReturn(CompareType.LEAF);

        ICompareResult compareResult2 = Mockito.mock(ICompareResult.class);
        Mockito.when(compareResult2.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
        Mockito.when(compareResult2.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        Mockito.when(compareResult2.getCompareType()).thenReturn(CompareType.LEAF);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.WARNING);
        actual.put("compareResult2", compareResult2);
        actual.put("compareResult1", compareResult1);

        TreeMap<String, ICompareResult> expectedValues = new TreeMap<>();
        expectedValues.put("compareResult1", compareResult1);
        expectedValues.put("compareResult2", compareResult2);

        assertEquals(expectedValues, actual.getValues());
        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
        assertEquals(CompareCriticalType.WARNING, actual.getCompareCriticalType());
        assertEquals(CompareType.NODE, actual.getCompareType());
    }

    @Test
    public void testNodeAddTwoValuesSameResultType() {

        ICompareResult compareResult1 = Mockito.mock(ICompareResult.class);
        Mockito.when(compareResult1.getCompareCriticalType()).thenReturn(CompareCriticalType.INFO);
        Mockito.when(compareResult1.getCompareResultType()).thenReturn(CompareResultType.CREATED);
        Mockito.when(compareResult1.getCompareType()).thenReturn(CompareType.LEAF);

        ICompareResult compareResult2 = Mockito.mock(ICompareResult.class);
        Mockito.when(compareResult2.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
        Mockito.when(compareResult2.getCompareResultType()).thenReturn(CompareResultType.CREATED);
        Mockito.when(compareResult2.getCompareType()).thenReturn(CompareType.LEAF);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.WARNING);
        actual.put("compareResult2", compareResult2);
        actual.put("compareResult1", compareResult1);

        TreeMap<String, ICompareResult> expectedValues = new TreeMap<>();
        expectedValues.put("compareResult1", compareResult1);
        expectedValues.put("compareResult2", compareResult2);

        assertEquals(expectedValues, actual.getValues());
        assertEquals(CompareResultType.CREATED, actual.getCompareResultType());
        assertEquals(CompareCriticalType.INFO, actual.getCompareCriticalType());
        assertEquals(CompareType.NODE, actual.getCompareType());
    }
}