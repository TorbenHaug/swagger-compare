package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.ComponentsResponsesCompareResult;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.Map;

public class ComponentsResponsesCompareHolder {

    public ComponentsResponsesCompareHolder(Map<String, ApiResponse> responses) {
    }

    public ComponentsResponsesCompareResult compare(ComponentsResponsesCompareHolder componentsResponsesCompareHolder) {
        return new ComponentsResponsesCompareResult();
    }
}
