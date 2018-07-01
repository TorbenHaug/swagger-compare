package de.haug_dev.swagger_compare.swagger_compare_core.paths;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PathsOpenAPICompareHolderTest {

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
        Mockito.when(pathItemCompareHolder.compare(pathItemLeft, pathItemRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL)).thenReturn(result1);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getPathItemCompareHolder()).thenReturn(pathItemCompareHolder);

        PathsCompareHolder pathsCompareHolder = new PathsCompareHolder(compareHolderFactory);

        NodeCompareResult actual = (NodeCompareResult) pathsCompareHolder.compare(pathsLeft, pathsRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
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
        Mockito.when(pathItemCompareHolder.compare(null, pathItemRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL)).thenReturn(result1);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getPathItemCompareHolder()).thenReturn(pathItemCompareHolder);

        PathsCompareHolder pathsCompareHolder = new PathsCompareHolder(compareHolderFactory);

        NodeCompareResult actual = (NodeCompareResult) pathsCompareHolder.compare(pathsLeft, pathsRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
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
        Mockito.when(pathItemCompareHolder.compare(pathItem, null, CompareCriticalType.INFO, CompareCriticalType.CRITICAL)).thenReturn(result1);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getPathItemCompareHolder()).thenReturn(pathItemCompareHolder);

        PathsCompareHolder pathsCompareHolder = new PathsCompareHolder(compareHolderFactory);

        NodeCompareResult actual = (NodeCompareResult) pathsCompareHolder.compare(pathsLeft, pathsRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        assertEquals(result1, actual.getValues().get("/test/{test2}"));

    }
}