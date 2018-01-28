package de.haug_dev.swagger_compare.swagger_compare_dto;

import io.swagger.v3.oas.models.OpenAPI;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NormalizeResultPack)) return false;
        NormalizeResultPack that = (NormalizeResultPack) o;
        return Objects.equals(originalAPI, that.originalAPI) &&
                Objects.equals(normalizedAPI, that.normalizedAPI) &&
                Objects.equals(mappingNormalizedToOriginal, that.mappingNormalizedToOriginal);
    }

    @Override
    public int hashCode() {

        return Objects.hash(originalAPI, normalizedAPI, mappingNormalizedToOriginal);
    }

    @Override
    public String toString() {
        return "NormalizeResultPack{" +
                "originalAPI=" + originalAPI +
                ", normalizedAPI=" + normalizedAPI +
                ", mappingNormalizedToOriginal=" + mappingNormalizedToOriginal +
                '}';
    }
}
