package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.dto.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_core.dto.PathsResultItem;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChangedPathFinderTest {

    Normalizer normalizer = new Normalizer();

    @Test
    void testOnePathEqualPaths_ExpectEmptyList() {

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

        List<PathsResultItem> expected = new ArrayList<>();

        ChangedPathFinder unchangedPathFinder = new ChangedPathFinder();
        List<PathsResultItem> actual = unchangedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

        assertEquals(expected, actual);
    }

    @Test
    void testOnePathNotEqualPathItem_ExpectListWithOneItem() {

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

        PathsResultItem expectedPathResultItem1 = new PathsResultItem("/test/", "/test/", CompareResultType.CHANGED);
        List<PathsResultItem> expected = new ArrayList<>();
        expected.add(expectedPathResultItem1);

        ChangedPathFinder changedPathFinder = new ChangedPathFinder();
        List<PathsResultItem> actual = changedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

        assertEquals(expected, actual);
    }

    @Test
    void testOnePathEqual_ExpectNoPathInResult() {

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

        List<PathsResultItem> expected = new ArrayList<>();


        ChangedPathFinder changedPathFinder = new ChangedPathFinder();
        List<PathsResultItem> actual = changedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

        assertEquals(expected, actual);

    }

    @Test
    void testTwoPathOneNotEqual_ExpectOnePathInResult() {

        OpenAPI leftOpenAPI = new OpenAPI();
        OpenAPI rightOpenAPI = new OpenAPI();

        Paths leftPaths = new Paths();
        Paths rightPaths = new Paths();

        leftOpenAPI.setPaths(leftPaths);
        rightOpenAPI.setPaths(rightPaths);

        PathItem leftPathItem = new PathItem();
        PathItem rightPathItem = new PathItem();

        PathItem leftPathItem2 = new PathItem();
        PathItem rightPathItem2 = new PathItem();

        leftPaths.put("/test/", leftPathItem);
        rightPaths.put("/test/", rightPathItem);

        leftPaths.put("/test2/", leftPathItem2);
        rightPaths.put("/test2/", rightPathItem2);

        Parameter rightParameter = new Parameter();
        ArrayList<Parameter> rightParameters = new ArrayList<>();
        rightParameters.add(rightParameter);
        rightPathItem.setParameters(rightParameters);

        NormalizeResultPack leftNormalized = normalizer.normalizeOpenAPI(leftOpenAPI);
        NormalizeResultPack rightNormalized = normalizer.normalizeOpenAPI(rightOpenAPI);

        PathsResultItem expectedPathResultItem1 = new PathsResultItem("/test/", "/test/", CompareResultType.CHANGED);
        List<PathsResultItem> expected = new ArrayList<>();
        expected.add(expectedPathResultItem1);


        ChangedPathFinder changedPathFinder = new ChangedPathFinder();
        List<PathsResultItem> actual = changedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

        assertEquals(expected, actual);

    }
}