package de.haug_dev.swagger_compare.swagger_compare_core;

import io.swagger.v3.oas.models.examples.Example;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExamplesCompareHolder implements ICompareHolder<Map<String, Example>> {
}
