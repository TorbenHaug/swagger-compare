package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.LeafCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import org.junit.Test;

import static org.junit.Assert.*;

public class ICompareHolderTest {

    ICompareHolder<Object> compareHolder = new ICompareHolder<Object>() {};

    @Test
    public void testCompareEqualValues1() {
        Object left = new Object();
        Object right = left;

        ICompareResult actual = compareHolder.compare(left, right);
        LeafCompareResult expected = new LeafCompareResult(left, right, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        assertEquals(expected, actual);
    }

    @Test
    public void testCompareEqualValues2() {
        Object left = null;
        Object right = null;

        ICompareResult actual = compareHolder.compare(left, right);
        LeafCompareResult expected = new LeafCompareResult(left, right, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        assertEquals(expected, actual);
    }

    @Test
    public void testCompareCreatedValues() {
        Object left = null;
        Object right = new Object();

        ICompareResult actual = compareHolder.compare(left, right);
        LeafCompareResult expected = new LeafCompareResult(left, right, CompareResultType.CREATED, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testCompareDeletedValues() {
        Object left = new Object();
        Object right = null;

        ICompareResult actual = compareHolder.compare(left, right);
        LeafCompareResult expected = new LeafCompareResult(left, right, CompareResultType.DELETED, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testCompareChangedValues() {
        Object left = new Object();
        Object right = new Object();

        ICompareResult actual = compareHolder.compare(left, right);
        LeafCompareResult expected = new LeafCompareResult(left, right, CompareResultType.CHANGED, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }


}