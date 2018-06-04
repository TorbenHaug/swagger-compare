package de.haug_dev.swagger_compare.swagger_compare_core.servers;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.servers.ServerVariable;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class ServerVariablesCompareHolderTest {
    @Test
    public void compareNullNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, ServerVariable> leftMap = null;
        Map<String, ServerVariable> rightMap = null;

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getServerVariablesCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareNullEmptyMap() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, ServerVariable> leftMap = null;
        Map<String, ServerVariable> rightMap = new HashMap<>();

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getServerVariablesCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareEmptyMapNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, ServerVariable> leftMap = new HashMap<>();
        Map<String, ServerVariable> rightMap = null;

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getServerVariablesCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareEmptyMapEmptyMap() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, ServerVariable> leftMap = new HashMap<>();
        Map<String, ServerVariable> rightMap = new HashMap<>();

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getServerVariablesCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareCreated() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        ServerVariableCompareHolder subCompareHolder = mock(ServerVariableCompareHolder.class);
        when(spiedCompareHolderFactory.getServerVariableCompareHolder()).thenReturn(subCompareHolder);

        Map<String, ServerVariable> leftMap = new HashMap<>();
        ServerVariable subLeft = null;
        Map<String, ServerVariable> rightMap = new HashMap<>();
        ServerVariable subRight = new ServerVariable();
        rightMap.put("test", subRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.CREATED, CompareCriticalType.INFO);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getServerVariablesCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareDeleted() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        ServerVariableCompareHolder subCompareHolder = mock(ServerVariableCompareHolder.class);
        when(spiedCompareHolderFactory.getServerVariableCompareHolder()).thenReturn(subCompareHolder);

        Map<String, ServerVariable> leftMap = new HashMap<>();
        ServerVariable subLeft = new ServerVariable();
        leftMap.put("test", subLeft);
        Map<String, ServerVariable> rightMap = new HashMap<>();
        ServerVariable subRight = null;

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.DELETED, CompareCriticalType.INFO);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getServerVariablesCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareUnchanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        ServerVariableCompareHolder subCompareHolder = mock(ServerVariableCompareHolder.class);
        when(spiedCompareHolderFactory.getServerVariableCompareHolder()).thenReturn(subCompareHolder);

        Map<String, ServerVariable> leftMap = new HashMap<>();
        ServerVariable subLeft = new ServerVariable();
        leftMap.put("test", subLeft);

        Map<String, ServerVariable> rightMap = new HashMap<>();
        ServerVariable subRight = new ServerVariable();
        rightMap.put("test", subRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getServerVariablesCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareChanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        ServerVariableCompareHolder subCompareHolder = mock(ServerVariableCompareHolder.class);
        when(spiedCompareHolderFactory.getServerVariableCompareHolder()).thenReturn(subCompareHolder);

        Map<String, ServerVariable> leftMap = new HashMap<>();
        ServerVariable subLeft = new ServerVariable();
        subLeft.setDescription("Test1");
        leftMap.put("test", subLeft);

        Map<String, ServerVariable> rightMap = new HashMap<>();
        ServerVariable subRight = new ServerVariable();
        subRight.setDescription("Test2");
        rightMap.put("test", subRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.CHANGED, CompareCriticalType.INFO);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getServerVariablesCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }
}