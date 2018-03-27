package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsCompareResult;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.media.Schema;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComponentsCompareHolderTest {

    @Test
    public void compareWithTwoEmptyComponents() {
        Components componentsLeft = new Components();
        Components componentsRight = new Components();

        ComponentsCompareHolder componentsCompareHolderLeft = new ComponentsCompareHolder(componentsLeft);
        ComponentsCompareHolder componentsCompareHolderRight = new ComponentsCompareHolder(componentsRight);

        ComponentsCompareResult result = componentsCompareHolderLeft.compare(componentsCompareHolderRight);

        assertEquals(CompareResultType.UNCHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, result.getCompareCriticalType());
    }

    @Test
    public void compareWithTwoNullComponents() {
        Components componentsLeft = null;
        Components componentsRight = null;

        ComponentsCompareHolder componentsCompareHolderLeft = new ComponentsCompareHolder(componentsLeft);
        ComponentsCompareHolder componentsCompareHolderRight = new ComponentsCompareHolder(componentsRight);

        ComponentsCompareResult result = componentsCompareHolderLeft.compare(componentsCompareHolderRight);

        assertEquals(CompareResultType.UNCHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, result.getCompareCriticalType());
    }

    @Test
    public void compareWithOneNullAndOneEmptyComponents() {
        Components componentsLeft = null;
        Components componentsRight = new Components();

        ComponentsCompareHolder componentsCompareHolderLeft = new ComponentsCompareHolder(componentsLeft);
        ComponentsCompareHolder componentsCompareHolderRight = new ComponentsCompareHolder(componentsRight);

        ComponentsCompareResult result = componentsCompareHolderLeft.compare(componentsCompareHolderRight);

        assertEquals(CompareResultType.UNCHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, result.getCompareCriticalType());
    }

    @Test
    public void compareWithOneEmptyAndOneNullComponents() {
        Components componentsLeft = new Components();
        Components componentsRight = null;

        ComponentsCompareHolder componentsCompareHolderLeft = new ComponentsCompareHolder(componentsLeft);
        ComponentsCompareHolder componentsCompareHolderRight = new ComponentsCompareHolder(componentsRight);

        ComponentsCompareResult result = componentsCompareHolderLeft.compare(componentsCompareHolderRight);

        assertEquals(CompareResultType.UNCHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, result.getCompareCriticalType());
    }

    @Test
    public void compareWithOneChangedAndOneNullComponents() {
        Schema<String> schemaLeft = new Schema<>();
        schemaLeft.deprecated(true);
        Components componentsLeft = new Components();
        componentsLeft.addSchemas("schemaLeft", schemaLeft);
        Components componentsRight = null;

        ComponentsCompareHolder componentsCompareHolderLeft = new ComponentsCompareHolder(componentsLeft);
        ComponentsCompareHolder componentsCompareHolderRight = new ComponentsCompareHolder(componentsRight);

        ComponentsCompareResult result = componentsCompareHolderLeft.compare(componentsCompareHolderRight);

        assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.CRITICAL, result.getCompareCriticalType());
    }
}