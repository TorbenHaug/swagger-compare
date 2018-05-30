package de.haug_dev.swagger_compare.swagger_compare_core.schemas;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class SchemasCompareHolder extends AbstractCompareHolder<Map<String, Schema>> {

    private CompareHolderFactory compareHolderFactory;

    public SchemasCompareHolder(CompareHolderFactory compareHolderFactory){
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Map<String, Schema> left, Map<String, Schema> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, Schema> leftValue = left == null ? new HashMap<String, Schema>() : left;
        Map<String, Schema> rightValue = right == null ? new HashMap<String, Schema>() : right;

        SchemaCompareHolder schemaCompareHolder = compareHolderFactory.getSchemaCompareHolder();

        return referableCompare(leftValue, rightValue, schemaCompareHolder, created, deleted);
    }
}
