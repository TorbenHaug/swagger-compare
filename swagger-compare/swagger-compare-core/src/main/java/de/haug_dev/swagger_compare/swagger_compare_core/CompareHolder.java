package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.PathsCompareResult;
import io.swagger.v3.oas.models.OpenAPI;

public class CompareHolder {

    private final OpenAPI api;
    private final PathsCompareHolder pathsCompareHolder;
    private final ComponentsCompareHolder componentsCompareHolder;

    public CompareHolder(OpenAPI api){
        this.api = api;
        this.pathsCompareHolder = new PathsCompareHolder(api.getPaths());
        this.componentsCompareHolder = new ComponentsCompareHolder(api.getComponents());
    }

    public CompareResult compare(CompareHolder other){
        PathsCompareResult pathsCompareResult = pathsCompareHolder.compare(other.pathsCompareHolder);
        ComponentsCompareResult componentsCompareResult = componentsCompareHolder.compare(other.componentsCompareHolder);
        return new CompareResult(pathsCompareResult, componentsCompareResult);
    }


}
