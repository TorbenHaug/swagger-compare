package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.media.Schema;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ComponentsSchemaCompareResultTest {

    @Test
    public void testCreated() {
        ComponentsSchemaCompareResult result = new ComponentsSchemaCompareResult();
        result.putCreated("test", new Schema());
        HashMap<String, Schema> expected = new HashMap<>();
        expected.put("test", new Schema());
        assertEquals(expected, result.getCreated());
        assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.INFO, result.getCompareCriticalType());
    }

    @Test
    public void testDeleted() {
        ComponentsSchemaCompareResult result = new ComponentsSchemaCompareResult();
        result.putDeleted("test", new Schema());
        HashMap<String, Schema> expected = new HashMap<>();
        expected.put("test", new Schema());
        assertEquals(expected, result.getDeleted());
        assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.CRITICAL, result.getCompareCriticalType());
    }

    @Test
    public void testUnchanged() {
        ComponentsSchemaCompareResult result = new ComponentsSchemaCompareResult();
        result.putUnchanged("test", new Schema());
        HashMap<String, Schema> expected = new HashMap<>();
        expected.put("test", new Schema());
        assertEquals(expected, result.getUnchanged());
        assertEquals(CompareResultType.UNCHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, result.getCompareCriticalType());
    }

    @Test
    public void testChanged() {
        SchemaCompareResult schema = Mockito.mock(SchemaCompareResult.class);
        Mockito.when(schema.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
        Mockito.when(schema.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        ComponentsSchemaCompareResult result = new ComponentsSchemaCompareResult();
        result.putChanged("test", schema);
        HashMap<String, SchemaCompareResult> expected = new HashMap<>();
        expected.put("test", schema);
        assertEquals(expected, result.getChanged());
        assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.WARNING, result.getCompareCriticalType());
    }
}