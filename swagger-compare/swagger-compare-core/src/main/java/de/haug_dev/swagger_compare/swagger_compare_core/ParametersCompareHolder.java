package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ParameterCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ParametersCompareResult;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.*;

public class ParametersCompareHolder {
    private Map<String, Parameter> parameters;

    public ParametersCompareHolder(Collection<Parameter> parameters) {
        this.parameters = new TreeMap<>();
        if(parameters != null){
            parameters.forEach((p) -> {
                this.parameters.put(p.getName(), p);
            });
        }
    }

    public ParametersCompareHolder(Map<String,Parameter> parameters) {
        this.parameters = new TreeMap<>();
        if(parameters != null){
            this.parameters.putAll(parameters);
        }
    }

    public ParametersCompareResult compare(ParametersCompareHolder other) {
        ParametersCompareResult result = new ParametersCompareResult();
        Set<String> deleted = diffKeys(this.parameters.keySet(), other.parameters.keySet());
        deleted.forEach((k) -> {
            result.putDeleted(k, this.parameters.get(k));
        });

        Set<String> created = diffKeys(other.parameters.keySet(), this.parameters.keySet());
        created.forEach((k) -> {
            result.putCreated(k, other.parameters.get(k));
        });

        Set<String> parametersToCompare = diffKeys(this.parameters.keySet(), deleted);
        parametersToCompare.forEach((k) -> {
            ParameterCompareHolder left = new ParameterCompareHolder(this.parameters.get(k));
            ParameterCompareHolder right = new ParameterCompareHolder(other.parameters.get(k));
            ParameterCompareResult schemaCompareResult = left.compare(right);
            if(schemaCompareResult.getCompareResultType().equals(CompareResultType.UNCHANGED)){
                result.putUnchanged(k, this.parameters.get(k));
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
