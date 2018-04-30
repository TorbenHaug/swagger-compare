package de.haug_dev.swagger_compare.swagger_compare_core;

import io.swagger.v3.oas.models.servers.Server;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ServersCompareHolder extends AbstractCompareHolder<Map<String, Server>> {
}
