package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.NormalizeResultPack;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Normalizer {
    public NormalizeResultPack normalizeOpenAPI(OpenAPI api){
        Paths normalizedPathes = new Paths();
        DualHashBidiMap<String,String> mappingNormalizedToOriginal = new DualHashBidiMap<>();
        api.getPaths().forEach((key, value) -> {
            String normalizePath = normalizePath(key);
            normalizedPathes.put(normalizePath, value);
            mappingNormalizedToOriginal.put(normalizePath, key);
        });

        Assert.isTrue(api.getPaths().size() == normalizedPathes.size(), "OpenAPI-Document is not valid");
        OpenAPI resultAPI = new OpenAPI();
        resultAPI.setPaths(normalizedPathes);
        return new NormalizeResultPack(api, resultAPI, mappingNormalizedToOriginal);
    }

    private String normalizePath(String path){
        String repString = "{var}";
        String rx = "(\\{[^}]+\\})";

        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(rx);
        Matcher m = p.matcher(path);

        while (m.find()){
            if (repString != null) {
                m.appendReplacement(sb, repString);
            }
        }
        m.appendTail(sb);

        return sb.toString();
    }
}
