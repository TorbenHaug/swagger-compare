package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.PathsCompareResult;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathsCompareHolderTest {
    @Test
    public void testPathes() {
        Paths pathsLeft = new Paths();
        PathItem pathItemLeft = new PathItem();
        pathsLeft.put("/unchanged/", pathItemLeft);
        pathsLeft.put("/unchanged/{unchangedVarName}/", pathItemLeft);
        pathsLeft.put("/unchanged2/{changedVarNameLeft}/", pathItemLeft);
        pathsLeft.put("/deleted/", pathItemLeft);
        pathsLeft.put("/changed/", pathItemLeft);
        PathsCompareHolder left = new PathsCompareHolder(pathsLeft);

        Paths pathsRight = new Paths();
        PathItem pathItemRight = new PathItem();
        PathItem pathItemRightChanged = new PathItem();
        pathItemRightChanged.set$ref("Test");
        pathsRight.put("/unchanged/", pathItemRight);
        pathsRight.put("/unchanged/{unchangedVarName}/", pathItemRight);
        pathsRight.put("/unchanged2/{changedVarNameRight}/", pathItemRight);
        pathsRight.put("/created/", pathItemRight);
        pathsRight.put("/changed/", pathItemRightChanged);
        PathsCompareHolder right = new PathsCompareHolder(pathsRight);
        PathsCompareResult actual = left.compare(right);
        assertEquals(3, actual.getUnchanged().size());
        assertEquals(1, actual.getDeleted().size());
        assertEquals(1, actual.getCreated().size());
        assertEquals(1, actual.getChanged().size());
    }

    @Test
    public void testPathesUnchanged() {
        Paths pathsLeft = new Paths();
        PathItem pathItemLeft = new PathItem();
        pathsLeft.put("/unchanged/", pathItemLeft);
        pathsLeft.put("/unchanged/{unchangedVarName}/", pathItemLeft);
        pathsLeft.put("/unchanged2/{changedVarNameLeft}/", pathItemLeft);
        PathsCompareHolder left = new PathsCompareHolder(pathsLeft);

        Paths pathsRight = new Paths();
        PathItem pathItemRight = new PathItem();
        PathItem pathItemRightChanged = new PathItem();
        pathItemRightChanged.set$ref("Test");
        pathsRight.put("/unchanged/", pathItemRight);
        pathsRight.put("/unchanged/{unchangedVarName}/", pathItemRight);
        pathsRight.put("/unchanged2/{changedVarNameRight}/", pathItemRight);
        PathsCompareHolder right = new PathsCompareHolder(pathsRight);
        PathsCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.UNCHANGED, actual.getCompareResultType());
    }

    @Test
    public void testPathesCreated() {
        Paths pathsLeft = new Paths();
        PathsCompareHolder left = new PathsCompareHolder(pathsLeft);

        Paths pathsRight = new Paths();
        PathItem pathItemRight = new PathItem();
        pathsRight.put("/created/", pathItemRight);
        PathsCompareHolder right = new PathsCompareHolder(pathsRight);
        PathsCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
    }

    @Test
    public void testPathesDeleted() {
        Paths pathsLeft = new Paths();
        PathItem pathItemLeft = new PathItem();
        pathsLeft.put("/deleted/", pathItemLeft);
        PathsCompareHolder left = new PathsCompareHolder(pathsLeft);

        Paths pathsRight = new Paths();
        PathsCompareHolder right = new PathsCompareHolder(pathsRight);
        PathsCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
    }

    @Test
    public void testPathesChanged() {
        Paths pathsLeft = new Paths();
        PathItem pathItemLeft = new PathItem();
        pathsLeft.put("/changed/", pathItemLeft);
        PathsCompareHolder left = new PathsCompareHolder(pathsLeft);

        Paths pathsRight = new Paths();
        PathItem pathItemRightChanged = new PathItem();
        pathItemRightChanged.set$ref("Test");
        pathsRight.put("/changed/", pathItemRightChanged);
        PathsCompareHolder right = new PathsCompareHolder(pathsRight);
        PathsCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());

    }

}