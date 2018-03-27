package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsSchemaCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.SchemaCompareResult;
import io.swagger.v3.oas.models.media.Schema;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ComponentsSchemaCompareHolder {
    private Map<String, Schema> schemas;

    public ComponentsSchemaCompareHolder(Map<String, Schema> schemas) {
        this.schemas = schemas == null ? new HashMap<>(): schemas;
    }

    public ComponentsSchemaCompareResult compare(ComponentsSchemaCompareHolder other){
        ComponentsSchemaCompareResult result = new ComponentsSchemaCompareResult();
        Set<String> deleted = diffKeys(this.schemas.keySet(), other.schemas.keySet());
        deleted.forEach((k) -> {
            result.putDeleted(k, this.schemas.get(k));
        });

        Set<String> created = diffKeys(other.schemas.keySet(), this.schemas.keySet());
        created.forEach((k) -> {
            result.putCreated(k, other.schemas.get(k));
        });

        Set<String> schemasToCompare = diffKeys(this.schemas.keySet(), deleted);
        schemasToCompare.forEach((k) -> {
            SchemaCompareHolder left = new SchemaCompareHolder(this.schemas.get(k));
            SchemaCompareHolder right = new SchemaCompareHolder(other.schemas.get(k));
            SchemaCompareResult schemaCompareResult = left.compare(right);
            if(schemaCompareResult.getCompareResultType().equals(CompareResultType.UNCHANGED)){
                result.putUnchanged(k, this.schemas.get(k));
            } else {
                result.putChanged(k, schemaCompareResult);
            }
        });

        return result;
    }

    protected Set<String> diffKeys(Set<String> left, Set<String> right){
        Set<String> keys = new HashSet<>(left);
        keys.removeAll(right);
        return keys;
    }
}
