package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.SchemaCompareResult;
import io.swagger.v3.oas.models.media.Schema;
import org.junit.Test;

import static org.junit.Assert.*;

public class SchemaCompareHolderTest {

    @Test
    public void compareEqualSchema() {
        Schema<String> stringSchema1 = new Schema<>();
        Schema<String> stringSchema2 = new Schema<>();

        SchemaCompareHolder schemaCompareHolderLeft = new SchemaCompareHolder(stringSchema1);
        SchemaCompareHolder schemaCompareHolderRight = new SchemaCompareHolder(stringSchema2);

        SchemaCompareResult result = schemaCompareHolderLeft.compare(schemaCompareHolderRight);

        assertEquals(CompareResultType.UNCHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, result.getCompareCriticalType());
    }

    @Test
    public void compareChangedSchema() {
        Schema<String> stringSchema1 = new Schema<>();
        Schema<String> stringSchema2 = new Schema<>();
        stringSchema1.setDeprecated(true);

        SchemaCompareHolder schemaCompareHolderLeft = new SchemaCompareHolder(stringSchema1);
        SchemaCompareHolder schemaCompareHolderRight = new SchemaCompareHolder(stringSchema2);

        SchemaCompareResult result = schemaCompareHolderLeft.compare(schemaCompareHolderRight);

        assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
        assertEquals(CompareCriticalType.CRITICAL, result.getCompareCriticalType());
    }
}