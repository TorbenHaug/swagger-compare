package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.PathsCompareResult;
import io.swagger.v3.oas.models.OpenAPI;

public class CompareHolder {

    private final OpenAPI api;
    private final PathsCompareHolder pathsCompareHolder;

    public CompareHolder(OpenAPI api){
        this.api = api;
        this.pathsCompareHolder = new PathsCompareHolder(api.getPaths());
    }

    public CompareResult compare(CompareHolder newApi){
        PathsCompareResult pathsCompareResult = pathsCompareHolder.compare(newApi.pathsCompareHolder);
        return new CompareResult(pathsCompareResult);
    }


}
