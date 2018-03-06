package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.ParametersCompareResult;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ParametersCompareHolder {
    private Set<Parameter> parameters;

    public ParametersCompareHolder(Collection<Parameter> parameters) {
        if(parameters == null){
            this.parameters = new HashSet<>();
        }else {
            this.parameters = new HashSet<>(parameters);
        }
    }

    public ParametersCompareResult compare(ParametersCompareHolder other) {
        Set<Parameter> unchanged = new HashSet<>(this.parameters);
        unchanged.retainAll(other.parameters);
        Set<Parameter> deleted = new HashSet<>(this.parameters);
        deleted.removeAll(other.parameters);
        Set<Parameter> created = new HashSet<>(other.parameters);
        created.removeAll(this.parameters);
        return new ParametersCompareResult(unchanged, created, deleted);
    }
}
