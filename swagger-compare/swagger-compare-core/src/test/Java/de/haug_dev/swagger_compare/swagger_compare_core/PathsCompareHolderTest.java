package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.junit.Test;
import org.mockito.Mockito;


import static org.junit.Assert.*;

public class PathsCompareHolderTest {

    @Test
    public void testEqualPaths() {
        Paths pathsLeft = new Paths();
        Paths pathsRight = new Paths();

        PathItem pathItemLeft = new PathItem();
        PathItem pathItemRight = new PathItem();

        pathsLeft.put("/test/{test1}", pathItemLeft);
        pathsRight.put("/test/{test2}", pathItemRight);

        ICompareResult result1 = new LeafCompareResult(pathItemLeft, pathItemRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        PathItemCompareHolder pathItemCompareHolder = Mockito.mock(PathItemCompareHolder.class);
        Mockito.when(pathItemCompareHolder.compare(pathItemLeft, pathItemRight)).thenReturn(result1);

        PathsCompareHolder pathsCompareHolder = new PathsCompareHolder(pathItemCompareHolder);

        NodeCompareResult actual = (NodeCompareResult) pathsCompareHolder.compare(pathsLeft, pathsRight);
        assertEquals(result1, actual.getValues().get("/test/{test2}"));

    }

    @Test
    public void testCreatedPaths() {
        Paths pathsLeft = new Paths();
        Paths pathsRight = new Paths();

        PathItem pathItemRight = new PathItem();

        pathsRight.put("/test/{test2}", pathItemRight);

        ICompareResult result1 = new LeafCompareResult(null, pathItemRight, CompareResultType.CREATED, CompareCriticalType.INFO);

        PathItemCompareHolder pathItemCompareHolder = Mockito.mock(PathItemCompareHolder.class);
        Mockito.when(pathItemCompareHolder.compare(null, pathItemRight)).thenReturn(result1);

        PathsCompareHolder pathsCompareHolder = new PathsCompareHolder(pathItemCompareHolder);

        NodeCompareResult actual = (NodeCompareResult) pathsCompareHolder.compare(pathsLeft, pathsRight);
        assertEquals(result1, actual.getValues().get("/test/{test2}"));

    }

    @Test
    public void testDeletedPaths() {
        Paths pathsLeft = new Paths();
        Paths pathsRight = new Paths();

        PathItem pathItem = new PathItem();

        pathsLeft.put("/test/{test2}", pathItem);

        ICompareResult result1 = new LeafCompareResult(pathItem, null, CompareResultType.CREATED, CompareCriticalType.INFO);

        PathItemCompareHolder pathItemCompareHolder = Mockito.mock(PathItemCompareHolder.class);
        Mockito.when(pathItemCompareHolder.compare(pathItem, null)).thenReturn(result1);

        PathsCompareHolder pathsCompareHolder = new PathsCompareHolder(pathItemCompareHolder);

        NodeCompareResult actual = (NodeCompareResult) pathsCompareHolder.compare(pathsLeft, pathsRight);
        assertEquals(result1, actual.getValues().get("/test/{test2}"));

    }
}