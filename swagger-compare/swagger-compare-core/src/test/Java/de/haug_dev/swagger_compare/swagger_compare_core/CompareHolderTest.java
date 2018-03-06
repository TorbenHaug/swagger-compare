package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.PathsCompareResult;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompareHolderTest {
    @Test
    public void testPathes() {
        Paths pathsLeft = new Paths();
        PathItem pathItemLeft = new PathItem();
        pathsLeft.put("/unchanged/", pathItemLeft);
        pathsLeft.put("/unchanged/{unchangedVarName}/", pathItemLeft);
        pathsLeft.put("/unchanged2/{changedVarNameLeft}/", pathItemLeft);
        pathsLeft.put("/deleted/", pathItemLeft);
        pathsLeft.put("/changed/", pathItemLeft);
        OpenAPI openAPIleft = new OpenAPI();
        openAPIleft.setPaths(pathsLeft);
        CompareHolder left = new CompareHolder(openAPIleft);

        Paths pathsRight = new Paths();
        PathItem pathItemRight = new PathItem();
        PathItem pathItemRightChanged = new PathItem();
        pathItemRightChanged.set$ref("Test");
        pathsRight.put("/unchanged/", pathItemRight);
        pathsRight.put("/unchanged/{unchangedVarName}/", pathItemRight);
        pathsRight.put("/unchanged2/{changedVarNameRight}/", pathItemRight);
        pathsRight.put("/created/", pathItemRight);
        pathsRight.put("/changed/", pathItemRightChanged);
        OpenAPI openAPIRight = new OpenAPI();
        openAPIRight.setPaths(pathsRight);
        CompareHolder right = new CompareHolder(openAPIRight);
        CompareResult actual = left.compare(right);
        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
    }

    @Test
    public void testPathesUnchanged() {
        Paths pathsLeft = new Paths();
        PathItem pathItemLeft = new PathItem();
        pathsLeft.put("/unchanged/", pathItemLeft);
        pathsLeft.put("/unchanged/{unchangedVarName}/", pathItemLeft);
        pathsLeft.put("/unchanged2/{changedVarNameLeft}/", pathItemLeft);
        OpenAPI openAPIleft = new OpenAPI();
        openAPIleft.setPaths(pathsLeft);
        CompareHolder left = new CompareHolder(openAPIleft);

        Paths pathsRight = new Paths();
        PathItem pathItemRight = new PathItem();
        PathItem pathItemRightChanged = new PathItem();
        pathItemRightChanged.set$ref("Test");
        pathsRight.put("/unchanged/", pathItemRight);
        pathsRight.put("/unchanged/{unchangedVarName}/", pathItemRight);
        pathsRight.put("/unchanged2/{changedVarNameRight}/", pathItemRight);
        OpenAPI openAPIRight = new OpenAPI();
        openAPIRight.setPaths(pathsRight);
        CompareHolder right = new CompareHolder(openAPIRight);
        CompareResult actual = left.compare(right);

        assertEquals(CompareResultType.UNCHANGED, actual.getCompareResultType());
    }

    @Test
    public void testPathesCreated() {
        Paths pathsLeft = new Paths();
        OpenAPI openAPIleft = new OpenAPI();
        openAPIleft.setPaths(pathsLeft);
        CompareHolder left = new CompareHolder(openAPIleft);

        Paths pathsRight = new Paths();
        PathItem pathItemRight = new PathItem();
        pathsRight.put("/created/", pathItemRight);
        OpenAPI openAPIRight = new OpenAPI();
        openAPIRight.setPaths(pathsRight);
        CompareHolder right = new CompareHolder(openAPIRight);
        CompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
    }

    @Test
    public void testPathesDeleted() {
        Paths pathsLeft = new Paths();
        PathItem pathItemLeft = new PathItem();
        pathsLeft.put("/deleted/", pathItemLeft);
        OpenAPI openAPIleft = new OpenAPI();
        openAPIleft.setPaths(pathsLeft);
        CompareHolder left = new CompareHolder(openAPIleft);

        Paths pathsRight = new Paths();
        OpenAPI openAPIRight = new OpenAPI();
        openAPIRight.setPaths(pathsRight);
        CompareHolder right = new CompareHolder(openAPIRight);
        CompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
    }

    @Test
    public void testPathesChanged() {
        Paths pathsLeft = new Paths();
        PathItem pathItemLeft = new PathItem();
        pathsLeft.put("/changed/", pathItemLeft);
        OpenAPI openAPIleft = new OpenAPI();
        openAPIleft.setPaths(pathsLeft);
        CompareHolder left = new CompareHolder(openAPIleft);

        Paths pathsRight = new Paths();
        PathItem pathItemRightChanged = new PathItem();
        pathItemRightChanged.set$ref("Test");
        pathsRight.put("/changed/", pathItemRightChanged);
        OpenAPI openAPIRight = new OpenAPI();
        openAPIRight.setPaths(pathsRight);
        CompareHolder right = new CompareHolder(openAPIRight);
        CompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());

    }
}