package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AbstractCompareHolderTest {

    AbstractCompareHolder<Object> compareHolder = new TestCompareHolder();

    @Test
    public void testCompareEqualValues1() {
        Object left = new Object();
        Object right = left;

        ICompareResult actual = compareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        LeafCompareResult expected = new LeafCompareResult(left, right, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        assertEquals(expected, actual);
    }

    @Test
    public void testCompareEqualValues2() {
        Object left = null;
        Object right = null;

        ICompareResult actual = compareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        LeafCompareResult expected = new LeafCompareResult(left, right, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        assertEquals(expected, actual);
    }

    @Test
    public void testCompareCreatedValues() {
        Object left = null;
        Object right = new Object();

        ICompareResult actual = compareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        LeafCompareResult expected = new LeafCompareResult(left, right, CompareResultType.CREATED, CompareCriticalType.INFO);

        assertEquals(expected, actual);
    }

    @Test
    public void testCompareDeletedValues() {
        Object left = new Object();
        Object right = null;

        ICompareResult actual = compareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        LeafCompareResult expected = new LeafCompareResult(left, right, CompareResultType.DELETED, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testCompareChangedValues() {
        Object left = new Object();
        Object right = new Object();

        ICompareResult actual = compareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        LeafCompareResult expected = new LeafCompareResult(left, right, CompareResultType.CHANGED, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testNodeCompareWithNullNull() {
        Map<String, Object> left = null;
        Map<String, Object> right = null;

        ICompareHolder<Map<String, Object>> nodeCompareHolder = Mockito.mock(ICompareHolder.class);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.nodeCompare(left, right, "test", nodeCompareHolder, actual, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testNodeCompareWithNullEmptyMap() {
        Map<String, Object> left = null;
        Map<String, Object> right = new HashMap<>();

        ICompareHolder<Map<String, Object>> nodeCompareHolder = Mockito.mock(ICompareHolder.class);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.nodeCompare(left, right, "test", nodeCompareHolder, actual, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testNodeCompareWithEmptyMapNull() {
        Map<String, Object> left = new HashMap<>();
        Map<String, Object> right = null;

        ICompareHolder<Map<String, Object>> nodeCompareHolder = Mockito.mock(ICompareHolder.class);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.nodeCompare(left, right, "test", nodeCompareHolder, actual, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testNodeCompareWithEmptyMapEmptyMap() {
        Map<String, Object> left = new HashMap<>();
        Map<String, Object> right = new HashMap<>();

        ICompareHolder<Map<String, Object>> nodeCompareHolder = Mockito.mock(ICompareHolder.class);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.nodeCompare(left, right, "test", nodeCompareHolder, actual, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testNodeCompareCreated() {
        Object testObject = new Object();
        Map<String, Object> left = new HashMap<>();
        Map<String, Object> right = new HashMap<>();
        right.put("test", testObject);

        ICompareResult expectedResult = new LeafCompareResult(left, right, CompareResultType.UNCHANGED, CompareCriticalType.INFO);
        ICompareHolder<Map<String, Object>> nodeCompareHolder = Mockito.mock(ICompareHolder.class);
        Mockito.when(nodeCompareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL)).thenReturn(expectedResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("test", expectedResult);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.nodeCompare(left, right, "test", nodeCompareHolder, actual, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testNodeCompareDeleted() {
        Object testObject = new Object();
        Map<String, Object> left = new HashMap<>();
        Map<String, Object> right = new HashMap<>();
        left.put("test", testObject);

        ICompareResult expectedResult = new LeafCompareResult(left, right, CompareResultType.UNCHANGED, CompareCriticalType.INFO);
        ICompareHolder<Map<String, Object>> nodeCompareHolder = Mockito.mock(ICompareHolder.class);
        Mockito.when(nodeCompareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL)).thenReturn(expectedResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("test", expectedResult);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.nodeCompare(left, right, "test", nodeCompareHolder, actual, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testNodeCompareUnchanged() {
        Object testObject = new Object();
        Map<String, Object> left = new HashMap<>();
        Map<String, Object> right = new HashMap<>();
        right.put("test", testObject);
        left.put("test", testObject);

        ICompareResult expectedResult = new LeafCompareResult(left, right, CompareResultType.UNCHANGED, CompareCriticalType.INFO);
        ICompareHolder<Map<String, Object>> nodeCompareHolder = Mockito.mock(ICompareHolder.class);
        Mockito.when(nodeCompareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL)).thenReturn(expectedResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("test", expectedResult);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.nodeCompare(left, right, "test", nodeCompareHolder, actual, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testNodeCompareChanged() {
        Object testObject1 = new Object();
        Object testObject2 = new Object();
        Map<String, Object> left = new HashMap<>();
        Map<String, Object> right = new HashMap<>();
        right.put("test", testObject1);
        left.put("test", testObject2);

        ICompareResult expectedResult = new LeafCompareResult(left, right, CompareResultType.UNCHANGED, CompareCriticalType.INFO);
        ICompareHolder<Map<String, Object>> nodeCompareHolder = Mockito.mock(ICompareHolder.class);
        Mockito.when(nodeCompareHolder.compare(left, right, CompareCriticalType.INFO, CompareCriticalType.CRITICAL)).thenReturn(expectedResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("test", expectedResult);

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.nodeCompare(left, right, "test", nodeCompareHolder, actual, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testReferableCompareCreated() {
        Object testObject1 = new Object();
        Object testObject2 = new Object();
        Map<String, Object> left = new HashMap<>();
        Map<String, Object> right = new HashMap<>();
        right.put("test", testObject1);

        ICompareResult expectedResult = new LeafCompareResult(null, testObject1, CompareResultType.UNCHANGED, CompareCriticalType.INFO);
        ICompareHolder<Object> nodeCompareHolder = Mockito.mock(ICompareHolder.class);
        Mockito.when(nodeCompareHolder.compare(null, testObject1, CompareCriticalType.INFO, CompareCriticalType.CRITICAL)).thenReturn(expectedResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("test", expectedResult);

        NodeCompareResult actual = compareHolder.referableCompare(left, right, nodeCompareHolder, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testReferableCompareDeleted() {
        Object testObject1 = new Object();
        Object testObject2 = new Object();
        Map<String, Object> left = new HashMap<>();
        Map<String, Object> right = new HashMap<>();
        left.put("test", testObject1);

        ICompareResult expectedResult = new LeafCompareResult(testObject2, testObject1, CompareResultType.UNCHANGED, CompareCriticalType.INFO);
        ICompareHolder<Object> nodeCompareHolder = Mockito.mock(ICompareHolder.class);
        Mockito.when(nodeCompareHolder.compare(testObject1, null, CompareCriticalType.INFO, CompareCriticalType.CRITICAL)).thenReturn(expectedResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("test", expectedResult);

        NodeCompareResult actual = compareHolder.referableCompare(left, right, nodeCompareHolder, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testReferableCompareUnchanged() {
        Object testObject1 = new Object();
        Object testObject2 = new Object();
        Map<String, Object> left = new HashMap<>();
        Map<String, Object> right = new HashMap<>();
        left.put("test", testObject1);
        right.put("test", testObject1);

        ICompareResult expectedResult = new LeafCompareResult(testObject2, testObject1, CompareResultType.UNCHANGED, CompareCriticalType.INFO);
        ICompareHolder<Object> nodeCompareHolder = Mockito.mock(ICompareHolder.class);
        Mockito.when(nodeCompareHolder.compare(testObject1, testObject1, CompareCriticalType.INFO, CompareCriticalType.CRITICAL)).thenReturn(expectedResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("test", expectedResult);

        NodeCompareResult actual = compareHolder.referableCompare(left, right, nodeCompareHolder, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testReferableCompareChanged() {
        Object testObject1 = new Object();
        Object testObject2 = new Object();
        Map<String, Object> left = new HashMap<>();
        Map<String, Object> right = new HashMap<>();
        left.put("test", testObject1);
        right.put("test", testObject2);

        ICompareResult expectedResult = new LeafCompareResult(testObject2, testObject1, CompareResultType.UNCHANGED, CompareCriticalType.INFO);
        ICompareHolder<Object> nodeCompareHolder = Mockito.mock(ICompareHolder.class);
        Mockito.when(nodeCompareHolder.compare(testObject1, testObject2, CompareCriticalType.INFO, CompareCriticalType.CRITICAL)).thenReturn(expectedResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("test", expectedResult);

        NodeCompareResult actual = compareHolder.referableCompare(left, right, nodeCompareHolder, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testLeafCompareEqualValues1() {
        Object left = new Object();
        Object right = left;

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.leafCompare(left, right, "test", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL, actual);
        LeafCompareResult expectedLeaf = new LeafCompareResult(left, right, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        assertEquals(expected, actual);
    }

    @Test
    public void testLeafCompareEqualValues2() {
        Object left = null;
        Object right = null;

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.leafCompare(left, right, "test", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL, actual);
        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void testLeafCompareCreatedValues() {
        Object left = null;
        Object right = new Object();

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.leafCompare(left, right, "test", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL, actual);
        LeafCompareResult expectedLeaf = new LeafCompareResult(left, right, CompareResultType.CREATED, CompareCriticalType.INFO);
        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        assertEquals(expected, actual);
    }

    @Test
    public void testLeafCompareDeletedValues() {
        Object left = new Object();
        Object right = null;

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.WARNING);
        compareHolder.leafCompare(left, right, "test", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL, actual);
        LeafCompareResult expectedLeaf = new LeafCompareResult(left, right, CompareResultType.DELETED, CompareCriticalType.WARNING);
        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.WARNING);
        expected.put("test", expectedLeaf);

        assertEquals(expected, actual);
    }

    @Test
    public void testLeafCompareChangedValues() {
        Object left = new Object();
        Object right = new Object();

        NodeCompareResult actual = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        compareHolder.leafCompare(left, right, "test", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL, actual);
        LeafCompareResult expectedLeaf = new LeafCompareResult(left, right, CompareResultType.CHANGED, CompareCriticalType.CRITICAL);
        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        assertEquals(expected, actual);
    }

    class TestCompareHolder extends AbstractCompareHolder<Object> {
    }
}