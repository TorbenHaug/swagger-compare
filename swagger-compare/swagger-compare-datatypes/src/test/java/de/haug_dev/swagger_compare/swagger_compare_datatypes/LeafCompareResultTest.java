package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class LeafCompareResultTest {

    @Test
    public void testCreateClass() {
        Object valueLeft = Mockito.mock(Object.class);
        Object valueRight = Mockito.mock(Object.class);

        LeafCompareResult actual = new LeafCompareResult(valueLeft, valueRight, CompareResultType.CREATED, CompareCriticalType.INFO);

        assertEquals(valueLeft, actual.getValueLeft());
        assertEquals(valueRight, actual.getValueRight());
        assertEquals(CompareResultType.CREATED, actual.getCompareResultType());
        assertEquals(CompareCriticalType.INFO, actual.getCompareCriticalType());
        assertEquals(CompareType.LEAF, actual.getCompareType());
    }
}