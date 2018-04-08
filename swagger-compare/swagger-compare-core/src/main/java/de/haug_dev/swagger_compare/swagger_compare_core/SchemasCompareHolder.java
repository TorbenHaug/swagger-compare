package de.haug_dev.swagger_compare.swagger_compare_core;

import io.swagger.v3.oas.models.media.Schema;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SchemasCompareHolder implements ICompareHolder<Map<String, Schema>> {
}
