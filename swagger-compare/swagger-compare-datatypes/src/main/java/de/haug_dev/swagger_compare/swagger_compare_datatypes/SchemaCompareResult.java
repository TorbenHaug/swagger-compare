package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.media.Schema;

import java.util.Objects;

public class SchemaCompareResult extends AbstractLeafCompareResult<Schema>{

    public SchemaCompareResult(Schema left, Schema right) {
        super(
                left,
                right,
                CompareCriticalType.NONE,
                CompareCriticalType.CRITICAL,
                CompareCriticalType.CRITICAL,
                CompareCriticalType.CRITICAL
        );
    }

}
