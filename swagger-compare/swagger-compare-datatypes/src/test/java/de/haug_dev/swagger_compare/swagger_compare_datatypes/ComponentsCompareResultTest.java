package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ComponentsCompareResultTest {

//    @Test
//    public void testUnchanged() {
//        ComponentsSchemaCompareResult componentsSchemaCompareResult = Mockito.mock(ComponentsSchemaCompareResult.class);
//        Mockito.when(componentsSchemaCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
//        Mockito.when(componentsSchemaCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
//
//        ResponsesCompareResult responsesCompareResult = Mockito.mock(ResponsesCompareResult.class);
//        Mockito.when(responsesCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
//        Mockito.when(responsesCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
//
//        ComponentsCompareResult result = new ComponentsCompareResult(componentsSchemaCompareResult, responsesCompareResult);
//
//        assertEquals(componentsSchemaCompareResult, result.getComponentsSchemaCompareResult());
//        assertEquals(CompareCriticalType.NONE, result.getCompareCriticalType());
//        assertEquals(CompareResultType.UNCHANGED, result.getCompareResultType());
//    }
//
//    @Test
//    public void testChangedComponentsSchemaCompareResult() {
//        ComponentsSchemaCompareResult componentsSchemaCompareResult = Mockito.mock(ComponentsSchemaCompareResult.class);
//        Mockito.when(componentsSchemaCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
//        Mockito.when(componentsSchemaCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
//
//        ResponsesCompareResult responsesCompareResult = Mockito.mock(ResponsesCompareResult.class);
//        Mockito.when(responsesCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
//        Mockito.when(responsesCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
//
//        ComponentsCompareResult result = new ComponentsCompareResult(componentsSchemaCompareResult, responsesCompareResult);
//
//        assertEquals(componentsSchemaCompareResult, result.getComponentsSchemaCompareResult());
//        assertEquals(CompareCriticalType.WARNING, result.getCompareCriticalType());
//        assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
//    }
//
//    @Test
//    public void testChangedComponentsResponsesCompareResult() {
//        ComponentsSchemaCompareResult componentsSchemaCompareResult = Mockito.mock(ComponentsSchemaCompareResult.class);
//        Mockito.when(componentsSchemaCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
//        Mockito.when(componentsSchemaCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
//
//        ResponsesCompareResult responsesCompareResult = Mockito.mock(ResponsesCompareResult.class);
//        Mockito.when(responsesCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
//        Mockito.when(responsesCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
//
//        ComponentsCompareResult result = new ComponentsCompareResult(componentsSchemaCompareResult, responsesCompareResult);
//
//        assertEquals(componentsSchemaCompareResult, result.getComponentsSchemaCompareResult());
//        assertEquals(CompareCriticalType.WARNING, result.getCompareCriticalType());
//        assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
//    }
}