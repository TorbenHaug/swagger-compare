package de.haug_dev.swagger_compare.swagger_compare_core;


import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwaggerCompareCoreTest {

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
        pathItemRightChanged.set$ref("Test");
        openAPIRight.setPaths(pathsRight);
        pathsRight.put("/unchanged/", pathItemRight);
        pathsRight.put("/unchanged/{unchangedVarName}/", pathItemRight);
        pathsRight.put("/unchanged2/{changedVarNameRight}/", pathItemRight);
        pathsRight.put("/created/", pathItemRight);
        pathsRight.put("/changed/", pathItemRightChanged);
        CompareResult actual = swaggerCompareCore.compare(openAPILeft, openAPIRight);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());


    }
}