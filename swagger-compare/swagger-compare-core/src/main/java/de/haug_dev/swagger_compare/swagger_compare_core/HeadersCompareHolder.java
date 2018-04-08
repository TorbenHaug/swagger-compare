package de.haug_dev.swagger_compare.swagger_compare_core;

import io.swagger.v3.oas.models.headers.Header;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HeadersCompareHolder implements ICompareHolder<Map<String, Header>> {
}
