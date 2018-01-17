package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.dto.PathsResultItem;
import io.swagger.v3.oas.models.OpenAPI;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.Map;

public class NormalizeResultPack {
    public final OpenAPI originalAPI;
    public final OpenAPI normalizedAPI;
    public final DualHashBidiMap<String,String> mappingNormalizedToOriginal;

    public NormalizeResultPack(OpenAPI originalAPI, OpenAPI normalizedAPI, DualHashBidiMap<String, String> mappingNormalizedToOriginal) {
        this.originalAPI = originalAPI;
        this.normalizedAPI = normalizedAPI;
        this.mappingNormalizedToOriginal = mappingNormalizedToOriginal;
    }

    public String getOriginalPath(String key) {
        return mappingNormalizedToOriginal.get(key);
    }

    public String getNormalizedPath(PathsResultItem value) {
        return mappingNormalizedToOriginal.getKey(value);
    }
}
