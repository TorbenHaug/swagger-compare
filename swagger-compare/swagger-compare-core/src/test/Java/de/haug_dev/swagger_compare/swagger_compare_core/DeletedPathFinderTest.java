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

class DeletedPathFinderTest {

    Normalizer normalizer = new Normalizer();

    @Test
    void testOnePathOneTheLeftSide_ExpectOneResult() {

        OpenAPI leftOpenAPI = new OpenAPI();
        OpenAPI rightOpenAPI = new OpenAPI();

        Paths leftPaths = new Paths();
        Paths rightPaths = new Paths();

        leftOpenAPI.setPaths(leftPaths);
        rightOpenAPI.setPaths(rightPaths);

        PathItem leftPathItem = new PathItem();

        leftPaths.put("/test2/", leftPathItem);

        NormalizeResultPack leftNormalized = normalizer.normalizeOpenAPI(leftOpenAPI);
        NormalizeResultPack rightNormalized = normalizer.normalizeOpenAPI(rightOpenAPI);

        PathsResultItem expectedPathResultItem1 = new PathsResultItem("/test2/",null,  CompareResultType.DELETED);
        List<PathsResultItem> expected = new ArrayList<>();
        expected.add(expectedPathResultItem1);

        DeletedPathFinder deletedPathFinder = new DeletedPathFinder();
        List<PathsResultItem> actual = deletedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

        assertEquals(expected, actual);
    }

    @Test
    void testOnePathEqualPathItem_ExpectEmptyList() {

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

        DeletedPathFinder deletedPathFinder = new DeletedPathFinder();
        List<PathsResultItem> actual = deletedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

        assertEquals(expected, actual);
    }

    @Test
    void testOnePathNotEqual_ExpectOnePathInResult() {

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

        PathsResultItem expectedPathResultItem1 = new PathsResultItem("/test/",null,  CompareResultType.DELETED);
        List<PathsResultItem> expected = new ArrayList<>();
        expected.add(expectedPathResultItem1);


        DeletedPathFinder deletedPathFinder = new DeletedPathFinder();
        List<PathsResultItem> actual = deletedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

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

        PathsResultItem expectedPathResultItem1 = new PathsResultItem("/test2/",null,  CompareResultType.DELETED);
        List<PathsResultItem> expected = new ArrayList<>();
        expected.add(expectedPathResultItem1);


        DeletedPathFinder deletedPathFinder = new DeletedPathFinder();
        List<PathsResultItem> actual = deletedPathFinder.process(leftOpenAPI.getPaths(), rightOpenAPI.getPaths(), leftNormalized, rightNormalized);

        assertEquals(expected, actual);

    }
}