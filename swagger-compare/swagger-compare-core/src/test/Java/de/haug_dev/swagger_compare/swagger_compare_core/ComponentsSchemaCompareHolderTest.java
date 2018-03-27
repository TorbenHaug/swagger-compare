package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsSchemaCompareResult;
import io.swagger.v3.oas.models.media.Schema;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ComponentsSchemaCompareHolderTest {

    @Test
    public void compareEmptySchemas() {
        HashMap<String, Schema> schemasLeft = new HashMap<>();
        HashMap<String, Schema> schemasRight = new HashMap<>();

        ComponentsSchemaCompareHolder componentsSchemaCompareHolderLeft = new ComponentsSchemaCompareHolder(schemasLeft);
        ComponentsSchemaCompareHolder componentsSchemaCompareHolderRight = new ComponentsSchemaCompareHolder(schemasRight);

        ComponentsSchemaCompareResult result = componentsSchemaCompareHolderLeft.compare(componentsSchemaCompareHolderRight);

        assertEquals(CompareResultType.UNCHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, result.getCompareCriticalType());
    }

    @Test
    public void compareDeletedSchemas() {
        Schema<String> stringSchema = new Schema<>();
        HashMap<String, Schema> schemasLeft = new HashMap<>();
        schemasLeft.put("testSchema", stringSchema);
        HashMap<String, Schema> schemasRight = new HashMap<>();

        ComponentsSchemaCompareHolder componentsSchemaCompareHolderLeft = new ComponentsSchemaCompareHolder(schemasLeft);
        ComponentsSchemaCompareHolder componentsSchemaCompareHolderRight = new ComponentsSchemaCompareHolder(schemasRight);

        ComponentsSchemaCompareResult result = componentsSchemaCompareHolderLeft.compare(componentsSchemaCompareHolderRight);

        assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.CRITICAL, result.getCompareCriticalType());
    }

    @Test
    public void compareCreateSchemas() {
        Schema<String> stringSchema = new Schema<>();
        HashMap<String, Schema> schemasLeft = new HashMap<>();
        HashMap<String, Schema> schemasRight = new HashMap<>();
        schemasRight.put("testSchema", stringSchema);

        ComponentsSchemaCompareHolder componentsSchemaCompareHolderLeft = new ComponentsSchemaCompareHolder(schemasLeft);
        ComponentsSchemaCompareHolder componentsSchemaCompareHolderRight = new ComponentsSchemaCompareHolder(schemasRight);

        ComponentsSchemaCompareResult result = componentsSchemaCompareHolderLeft.compare(componentsSchemaCompareHolderRight);

        assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.INFO, result.getCompareCriticalType());
    }

    @Test
    public void compareChangeSchemas() {
        Schema<String> stringSchema1 = new Schema<>();
        Schema<String> stringSchema2 = new Schema<>();
        stringSchema1.setDeprecated(true);
        HashMap<String, Schema> schemasLeft = new HashMap<>();
        schemasLeft.put("testSchema", stringSchema1);
        HashMap<String, Schema> schemasRight = new HashMap<>();
        schemasRight.put("testSchema", stringSchema2);

        ComponentsSchemaCompareHolder componentsSchemaCompareHolderLeft = new ComponentsSchemaCompareHolder(schemasLeft);
        ComponentsSchemaCompareHolder componentsSchemaCompareHolderRight = new ComponentsSchemaCompareHolder(schemasRight);

        ComponentsSchemaCompareResult result = componentsSchemaCompareHolderLeft.compare(componentsSchemaCompareHolderRight);

        assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.CRITICAL, result.getCompareCriticalType());
    }

}