package de.haug_dev.swagger_compare.swagger_compare_core.headers;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.headers.Header;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class HeadersCompareHolderTest {

    @Test
    public void compareNullNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Header> headersLeft = null;
        Map<String, Header> headersRight = null;

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getHeadersCompareHolder().compare(headersLeft, headersRight, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareNullEmptyMap() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Header> headersLeft = null;
        Map<String, Header> headersRight = new HashMap<>();

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getHeadersCompareHolder().compare(headersLeft, headersRight, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareEmptyMapNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Header> headersLeft = new HashMap<>();
        Map<String, Header> headersRight = null;

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getHeadersCompareHolder().compare(headersLeft, headersRight, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareEmptyMapEmptyMap() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);

        Map<String, Header> headersLeft = new HashMap<>();
        Map<String, Header> headersRight = new HashMap<>();

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getHeadersCompareHolder().compare(headersLeft, headersRight, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareCreated() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        HeaderCompareHolder headerCompareHolder = mock(HeaderCompareHolder.class);
        when(spiedCompareHolderFactory.getHeaderCompareHolder()).thenReturn(headerCompareHolder);

        Map<String, Header> headersLeft = new HashMap<>();
        Header headerLeft = null;
        Map<String, Header> headersRight = new HashMap<>();
        Header headerRight = new Header();
        headersRight.put("test", headerRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(headerLeft, headerRight, CompareResultType.CREATED, CompareCriticalType.INFO);

        when(headerCompareHolder.compare(eq(headerLeft), eq(headerRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getHeadersCompareHolder().compare(headersLeft, headersRight, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareDeleted() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        HeaderCompareHolder headerCompareHolder = mock(HeaderCompareHolder.class);
        when(spiedCompareHolderFactory.getHeaderCompareHolder()).thenReturn(headerCompareHolder);

        Map<String, Header> headersLeft = new HashMap<>();
        Header headerLeft = new Header();
        headersLeft.put("test", headerLeft);
        Map<String, Header> headersRight = new HashMap<>();
        Header headerRight = null;

        ILeafCompareResult expectedLeaf = new LeafCompareResult(headerLeft, headerRight, CompareResultType.DELETED, CompareCriticalType.INFO);

        when(headerCompareHolder.compare(eq(headerLeft), eq(headerRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getHeadersCompareHolder().compare(headersLeft, headersRight, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareUnchanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        HeaderCompareHolder headerCompareHolder = mock(HeaderCompareHolder.class);
        when(spiedCompareHolderFactory.getHeaderCompareHolder()).thenReturn(headerCompareHolder);

        Map<String, Header> headersLeft = new HashMap<>();
        Header headerLeft = new Header();
        headersLeft.put("test", headerLeft);

        Map<String, Header> headersRight = new HashMap<>();
        Header headerRight = new Header();
        headersRight.put("test", headerRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(headerLeft, headerRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        when(headerCompareHolder.compare(eq(headerLeft), eq(headerRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getHeadersCompareHolder().compare(headersLeft, headersRight, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareChanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        HeaderCompareHolder headerCompareHolder = mock(HeaderCompareHolder.class);
        when(spiedCompareHolderFactory.getHeaderCompareHolder()).thenReturn(headerCompareHolder);

        Map<String, Header> headersLeft = new HashMap<>();
        Header headerLeft = new Header();
        headerLeft.setDescription("Test1");
        headersLeft.put("test", headerLeft);

        Map<String, Header> headersRight = new HashMap<>();
        Header headerRight = new Header();
        headerRight.setDescription("Test2");
        headersRight.put("test", headerRight);

        ILeafCompareResult expectedLeaf = new LeafCompareResult(headerLeft, headerRight, CompareResultType.CHANGED, CompareCriticalType.INFO);

        when(headerCompareHolder.compare(eq(headerLeft), eq(headerRight), any(), any())).thenReturn(expectedLeaf);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("test", expectedLeaf);

        ICompareResult actual = spiedCompareHolderFactory.getHeadersCompareHolder().compare(headersLeft, headersRight, CompareCriticalType.WARNING,CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }
}