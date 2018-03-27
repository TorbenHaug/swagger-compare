package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ComponentsCompareResultTest {

    @Test
    public void testUnchanged() {
        ComponentsSchemaCompareResult componentsSchemaCompareResult = Mockito.mock(ComponentsSchemaCompareResult.class);
        Mockito.when(componentsSchemaCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(componentsSchemaCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);

        ComponentsCompareResult result = new ComponentsCompareResult(componentsSchemaCompareResult);

        assertEquals(componentsSchemaCompareResult, result.getComponentsSchemaCompareResult());
        assertEquals(CompareCriticalType.NONE, result.getCompareCriticalType());
        assertEquals(CompareResultType.UNCHANGED, result.getCompareResultType());
    }
    @Test
    public void testChanged() {
        ComponentsSchemaCompareResult componentsSchemaCompareResult = Mockito.mock(ComponentsSchemaCompareResult.class);
        Mockito.when(componentsSchemaCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
        Mockito.when(componentsSchemaCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);

        ComponentsCompareResult result = new ComponentsCompareResult(componentsSchemaCompareResult);

        assertEquals(componentsSchemaCompareResult, result.getComponentsSchemaCompareResult());
        assertEquals(CompareCriticalType.WARNING, result.getCompareCriticalType());
        assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
    }
}