package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.NormalizeResultPack;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalizerTest {

    Normalizer normalizer = new Normalizer();

    @Test
    public void normalizeOpenAPI() {
        OpenAPI openAPI = new OpenAPI();
        Paths paths = new Paths();
        PathItem pathItem1 = new PathItem();
        PathItem pathItem2 = new PathItem();
        openAPI.setPaths(paths);
        paths.put("/test/{test}/", pathItem1);
        paths.put("/test/", pathItem2);

        OpenAPI openAPIRes = new OpenAPI();
        Paths pathsRes = new Paths();
        PathItem pathItem1res = new PathItem();
        PathItem pathItem2res = new PathItem();
        openAPIRes.setPaths(pathsRes);
        pathsRes.put("/test/{var}/", pathItem1res);
        pathsRes.put("/test/", pathItem2res);
        DualHashBidiMap<String, String> resMap = new DualHashBidiMap<>();
        resMap.put("/test/{var}/","/test/{test}/");
        resMap.put("/test/","/test/");

        NormalizeResultPack result = normalizer.normalizeOpenAPI(openAPI);
        NormalizeResultPack expected = new NormalizeResultPack(openAPI, openAPIRes, resMap);
        assertEquals(expected,result);
    }
}