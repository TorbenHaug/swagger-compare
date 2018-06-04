package de.haug_dev.swagger_compare.swagger_compare_core.links;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.links.Link;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class LinksCompareHolderTest {
    @Test
    public void compareNullNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Link> leftMap = null;
        Map<String, Link> rightMap = null;

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getLinksCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareNullEmptyMap() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Link> leftMap = null;
        Map<String, Link> rightMap = new HashMap<>();

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getLinksCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareEmptyMapNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Link> leftMap = new HashMap<>();
        Map<String, Link> rightMap = null;

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getLinksCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareEmptyMapEmptyMap() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Link> leftMap = new HashMap<>();
        Map<String, Link> rightMap = new HashMap<>();

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getLinksCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareCreated() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        LinkCompareHolder subCompareHolder = mock(LinkCompareHolder.class);
        when(spiedCompareHolderFactory.getLinkCompareHolder()).thenReturn(subCompareHolder);

        Map<String, Link> leftMap = new HashMap<>();
        Link subLeft = null;
        Map<String, Link> rightMap = new HashMap<>();
        Link subRight = new Link();
        rightMap.put("test", subRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.CREATED, CompareCriticalType.INFO);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getLinksCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareDeleted() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        LinkCompareHolder subCompareHolder = mock(LinkCompareHolder.class);
        when(spiedCompareHolderFactory.getLinkCompareHolder()).thenReturn(subCompareHolder);

        Map<String, Link> leftMap = new HashMap<>();
        Link subLeft = new Link();
        leftMap.put("test", subLeft);
        Map<String, Link> rightMap = new HashMap<>();
        Link subRight = null;

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.DELETED, CompareCriticalType.INFO);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getLinksCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareUnchanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        LinkCompareHolder subCompareHolder = mock(LinkCompareHolder.class);
        when(spiedCompareHolderFactory.getLinkCompareHolder()).thenReturn(subCompareHolder);

        Map<String, Link> leftMap = new HashMap<>();
        Link subLeft = new Link();
        leftMap.put("test", subLeft);

        Map<String, Link> rightMap = new HashMap<>();
        Link subRight = new Link();
        rightMap.put("test", subRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getLinksCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareChanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        LinkCompareHolder subCompareHolder = mock(LinkCompareHolder.class);
        when(spiedCompareHolderFactory.getLinkCompareHolder()).thenReturn(subCompareHolder);

        Map<String, Link> leftMap = new HashMap<>();
        Link subLeft = new Link();
        subLeft.setDescription("Test1");
        leftMap.put("test", subLeft);

        Map<String, Link> rightMap = new HashMap<>();
        Link subRight = new Link();
        subRight.setDescription("Test2");
        rightMap.put("test", subRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(subLeft, subRight, CompareResultType.CHANGED, CompareCriticalType.INFO);

        when(subCompareHolder.compare(eq(subLeft), eq(subRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getLinksCompareHolder().compare(leftMap, rightMap, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }
}