package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.dto.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_core.dto.PathsResultItem;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UnchangedPathFinderTest {

    Normalizer normalizer = new Normalizer();

    @Test
    void testOnePathNotEqualPaths_ExpectEmptyList() {

        OpenAPI leftOpenAPI = new OpenAPI();
        OpenAPI rightOpenAPI = new OpenAPI();

        Paths leftPaths = new Paths();
        Paths rightPaths = new Paths();

        leftOpenAPI.setPaths(leftPaths);
        rightOpenAPI.setPaths(rightPaths);

        PathItem leftPathItem = new PathItem();
        PathItem rightPathItem = new PathItem();

        leftPaths.put("/test/", leftPathItem);
        rightPaths.put("/test2/", rightPathItem);

        NormalizeResultPack leftNormalized = normalizer.normalizeOpenAPI(leftOpenAPI);
        NormalizeResultPack rightNormalized = normalizer.normalizeOpenAPI(rightOpenAPI);

        List<PathsResultItem> expected = new ArrayList<>();

        UnchangedPathFinder unchangedPathFinder = new UnchangedPathFinder();
        List<PathsResultItem> actual = unchangedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

        assertEquals(expected, actual);
    }

    @Test
    void testOnePathNotEqualPathItem_ExpectEmptyList() {

        OpenAPI leftOpenAPI = new OpenAPI();
        OpenAPI rightOpenAPI = new OpenAPI();

        Paths leftPaths = new Paths();
        Paths rightPaths = new Paths();

        leftOpenAPI.setPaths(leftPaths);
        rightOpenAPI.setPaths(rightPaths);

        PathItem leftPathItem = new PathItem();
        PathItem rightPathItem = new PathItem();

        Parameter rightParameter = new Parameter();
        ArrayList<Parameter> rightParameters = new ArrayList<>();
        rightParameters.add(rightParameter);
        rightPathItem.setParameters(rightParameters);

        leftPaths.put("/test/", leftPathItem);
        rightPaths.put("/test/", rightPathItem);

        NormalizeResultPack leftNormalized = normalizer.normalizeOpenAPI(leftOpenAPI);
        NormalizeResultPack rightNormalized = normalizer.normalizeOpenAPI(rightOpenAPI);

        List<PathsResultItem> expected = new ArrayList<>();

        UnchangedPathFinder unchangedPathFinder = new UnchangedPathFinder();
        List<PathsResultItem> actual = unchangedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

        assertEquals(expected, actual);
    }

    @Test
    void testOnePathEqual_ExpectOnePathInResult() {

        OpenAPI leftOpenAPI = new OpenAPI();
        OpenAPI rightOpenAPI = new OpenAPI();

        Paths leftPaths = new Paths();
        Paths rightPaths = new Paths();

        leftOpenAPI.setPaths(leftPaths);
        rightOpenAPI.setPaths(rightPaths);

        PathItem leftPathItem = new PathItem();
        PathItem rightPathItem = new PathItem();

        leftPaths.put("/test/", leftPathItem);
        rightPaths.put("/test/", rightPathItem);

        NormalizeResultPack leftNormalized = normalizer.normalizeOpenAPI(leftOpenAPI);
        NormalizeResultPack rightNormalized = normalizer.normalizeOpenAPI(rightOpenAPI);

        PathsResultItem expectedPathResultItem1 = new PathsResultItem("/test/", "/test/", CompareResultType.UNCHANGED);
        List<PathsResultItem> expected = new ArrayList<>();
        expected.add(expectedPathResultItem1);


        UnchangedPathFinder unchangedPathFinder = new UnchangedPathFinder();
        List<PathsResultItem> actual = unchangedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

        assertEquals(expected, actual);

    }

    @Test
    void testTwoPathOneEqual_ExpectOnePathInResult() {

        OpenAPI leftOpenAPI = new OpenAPI();
        OpenAPI rightOpenAPI = new OpenAPI();

        Paths leftPaths = new Paths();
        Paths rightPaths = new Paths();

        leftOpenAPI.setPaths(leftPaths);
        rightOpenAPI.setPaths(rightPaths);

        PathItem leftPathItem = new PathItem();
        PathItem rightPathItem = new PathItem();

        leftPaths.put("/test/", leftPathItem);
        rightPaths.put("/test/", rightPathItem);

        leftPaths.put("/test2/", leftPathItem);
        rightPaths.put("/test3/", rightPathItem);

        NormalizeResultPack leftNormalized = normalizer.normalizeOpenAPI(leftOpenAPI);
        NormalizeResultPack rightNormalized = normalizer.normalizeOpenAPI(rightOpenAPI);

        PathsResultItem expectedPathResultItem1 = new PathsResultItem("/test/", "/test/", CompareResultType.UNCHANGED);
        List<PathsResultItem> expected = new ArrayList<>();
        expected.add(expectedPathResultItem1);


        UnchangedPathFinder unchangedPathFinder = new UnchangedPathFinder();
        List<PathsResultItem> actual = unchangedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

        assertEquals(expected, actual);

    }
}