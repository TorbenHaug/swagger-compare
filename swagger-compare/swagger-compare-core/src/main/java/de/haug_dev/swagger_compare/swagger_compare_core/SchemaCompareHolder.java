package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.SchemaCompareResult;
import io.swagger.v3.oas.models.media.Schema;

public class SchemaCompareHolder {
    private Schema schema;

    public SchemaCompareHolder(Schema schema) {
        this.schema = schema;
    }

    public SchemaCompareResult compare(SchemaCompareHolder other) {
        return new SchemaCompareResult(this.schema, other.schema);
    }
}
