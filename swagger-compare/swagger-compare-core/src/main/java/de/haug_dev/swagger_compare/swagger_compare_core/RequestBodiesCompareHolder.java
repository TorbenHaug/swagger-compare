package de.haug_dev.swagger_compare.swagger_compare_core;

import io.swagger.v3.oas.models.parameters.RequestBody;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RequestBodiesCompareHolder implements ICompareHolder<Map<String, RequestBody>> {
}