package de.haug_dev.swagger_compare.swagger_compare_core.schemas;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.media.Schema;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SchemasCompareHolderTest {
    @Test
    public void compareNullNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Schema> leftMap = null;
        Map<String, Schema> rightMap = null;

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getSchemasCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareNullEmptyMap() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Schema> leftMap = null;
        Map<String, Schema> rightMap = new HashMap<>();

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getSchemasCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareEmptyMapNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Schema> leftMap = new HashMap<>();
        Map<String, Schema> rightMap = null;

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getSchemasCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareEmptyMapEmptyMap() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Schema> leftMap = new HashMap<>();
        Map<String, Schema> rightMap = new HashMap<>();

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getSchemasCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareCreated() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        SchemaCompareHolder subCompareHolder = mock(SchemaCompareHolder.class);
        when(spiedCompareHolderFactory.getSchemaCompareHolder()).thenReturn(subCompareHolder);

        Map<String, Schema> leftMap = new HashMap<>();
        Schema subLeft = null;
        Map<String, Schema> rightMap = new HashMap<>();
        Schema subRight = new Schema();
        rightMap.put("test", subRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.CREATED, CompareCriticalType.INFO);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getSchemasCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareDeleted() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        SchemaCompareHolder subCompareHolder = mock(SchemaCompareHolder.class);
        when(spiedCompareHolderFactory.getSchemaCompareHolder()).thenReturn(subCompareHolder);

        Map<String, Schema> leftMap = new HashMap<>();
        Schema subLeft = new Schema();
        leftMap.put("test", subLeft);
        Map<String, Schema> rightMap = new HashMap<>();
        Schema subRight = null;

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.DELETED, CompareCriticalType.INFO);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getSchemasCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareUnchanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        SchemaCompareHolder subCompareHolder = mock(SchemaCompareHolder.class);
        when(spiedCompareHolderFactory.getSchemaCompareHolder()).thenReturn(subCompareHolder);

        Map<String, Schema> leftMap = new HashMap<>();
        Schema subLeft = new Schema();
        leftMap.put("test", subLeft);

        Map<String, Schema> rightMap = new HashMap<>();
        Schema subRight = new Schema();
        rightMap.put("test", subRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getSchemasCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareChanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        SchemaCompareHolder subCompareHolder = mock(SchemaCompareHolder.class);
        when(spiedCompareHolderFactory.getSchemaCompareHolder()).thenReturn(subCompareHolder);

        Map<String, Schema> leftMap = new HashMap<>();
        Schema subLeft = new Schema();
        subLeft.setDescription("Test1");
        leftMap.put("test", subLeft);

        Map<String, Schema> rightMap = new HashMap<>();
        Schema subRight = new Schema();
        subRight.setDescription("Test2");
        rightMap.put("test", subRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.CHANGED, CompareCriticalType.INFO);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getSchemasCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }
}