package de.haug_dev.swagger_compare.swagger_compare_core.headers;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import io.swagger.v3.oas.models.headers.Header;
import org.springframework.stereotype.Component;

import java.util.Map;

public class HeadersCompareHolder extends AbstractCompareHolder<Map<String, Header>> {
}
