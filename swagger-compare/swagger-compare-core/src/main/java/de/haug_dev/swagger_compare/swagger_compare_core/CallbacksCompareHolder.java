package de.haug_dev.swagger_compare.swagger_compare_core;

import io.swagger.v3.oas.models.callbacks.Callback;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CallbacksCompareHolder implements ICompareHolder<Map<String, Callback>> {
}
