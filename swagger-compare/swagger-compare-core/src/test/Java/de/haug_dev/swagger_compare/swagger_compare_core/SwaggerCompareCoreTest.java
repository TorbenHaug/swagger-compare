package de.haug_dev.swagger_compare.swagger_compare_core;


import de.haug_dev.swagger_compare.swagger_compare_core.processors.ChangedPathFinder;
import de.haug_dev.swagger_compare.swagger_compare_core.processors.CreatedPathFinder;
import de.haug_dev.swagger_compare.swagger_compare_core.processors.DeletedPathFinder;
import de.haug_dev.swagger_compare.swagger_compare_core.processors.UnchangedPathFinder;
import de.haug_dev.swagger_compare.swagger_compare_dto.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_dto.OpenAPICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_dto.PathsResultItem;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SwaggerCompareCoreTest {


    @Spy
    private UnchangedPathFinder unchangedPathFinder = new UnchangedPathFinder();

    @Spy
    private ChangedPathFinder changedPathFinder = new ChangedPathFinder();

    @Spy
    private DeletedPathFinder deletedPathFinder = new DeletedPathFinder();

    @Spy
    private CreatedPathFinder createdPathFinder = new CreatedPathFinder();

    @Spy
    private Normalizer normalizer = new Normalizer();

    @InjectMocks
    private SwaggerCompareCore swaggerCompareCore = new SwaggerCompareCore();

    @Test
    public void compare() {
        OpenAPI openAPILeft = new OpenAPI();
        Paths pathsLeft = new Paths();
        PathItem pathItemLeft = new PathItem();
        openAPILeft.setPaths(pathsLeft);
        pathsLeft.put("/unchanged/", pathItemLeft);
        pathsLeft.put("/unchanged/{unchangedVarName}/", pathItemLeft);
        pathsLeft.put("/unchanged2/{changedVarNameLeft}/", pathItemLeft);
        pathsLeft.put("/deleted/", pathItemLeft);
        pathsLeft.put("/changed/", pathItemLeft);

        OpenAPI openAPIRight = new OpenAPI();
        Paths pathsRight = new Paths();
        PathItem pathItemRight = new PathItem();
        PathItem pathItemRightChanged = new PathItem();
        pathItemRightChanged.setDelete(new Operation());
        openAPIRight.setPaths(pathsRight);
        pathsRight.put("/unchanged/", pathItemRight);
        pathsRight.put("/unchanged/{unchangedVarName}/", pathItemRight);
        pathsRight.put("/unchanged2/{changedVarNameRight}/", pathItemRight);
        pathsRight.put("/created/", pathItemRight);
        pathsRight.put("/changed/", pathItemRightChanged);

        OpenAPICompareResult result = swaggerCompareCore.compare(openAPILeft, openAPIRight);
        Set<PathsResultItem> actual = new HashSet<>(result.getPathsResult().getPathsResultItems());

        PathsResultItem pathsResultItem1 = new PathsResultItem("/unchanged/", "/unchanged/", CompareResultType.UNCHANGED);
        PathsResultItem pathsResultItem2 = new PathsResultItem("/unchanged/{unchangedVarName}/", "/unchanged/{unchangedVarName}/", CompareResultType.UNCHANGED);
        PathsResultItem pathsResultItem3 = new PathsResultItem("/unchanged2/{changedVarNameLeft}/", "/unchanged2/{changedVarNameRight}/", CompareResultType.UNCHANGED);
        PathsResultItem pathsResultItem4 = new PathsResultItem("/deleted/", null, CompareResultType.DELETED);
        PathsResultItem pathsResultItem5 = new PathsResultItem(null, "/created/", CompareResultType.CREATED);
        PathsResultItem pathsResultItem6 = new PathsResultItem("/changed/", "/changed/", CompareResultType.CHANGED);
        Set<PathsResultItem> expected = new HashSet<>(Arrays.asList(pathsResultItem1,pathsResultItem2,pathsResultItem3,pathsResultItem4,pathsResultItem5,pathsResultItem6));

        assertEquals(expected, actual);


    }
}