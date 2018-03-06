package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.PathItem;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PathsCompareResultTest {

    @Test
    public void putUnchanged() {
        PathsCompareResult pathsCompareResult = new PathsCompareResult();
        pathsCompareResult.putUnchanged("/test/", new PathItem());
        assertEquals(CompareCriticalType.NONE, pathsCompareResult.getCompareCriticalType());
        assertEquals(CompareResultType.UNCHANGED, pathsCompareResult.getCompareResultType());
    }

    @Test
    public void putChanged() {
        PathItemCompareResult pathItemCompareResult = Mockito.mock(PathItemCompareResult.class);
        Mockito.when(pathItemCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
        Mockito.when(pathItemCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        PathsCompareResult pathsCompareResult = new PathsCompareResult();
        pathsCompareResult.putChanged("/test/", pathItemCompareResult);
        assertEquals(CompareCriticalType.WARNING, pathsCompareResult.getCompareCriticalType());
        assertEquals(CompareResultType.CHANGED, pathsCompareResult.getCompareResultType());
    }

    @Test
    public void putCreated() {
        PathsCompareResult pathsCompareResult = new PathsCompareResult();
        pathsCompareResult.putCreated("/test/", new PathItem());
        assertEquals(CompareCriticalType.INFO, pathsCompareResult.getCompareCriticalType());
        assertEquals(CompareResultType.CHANGED, pathsCompareResult.getCompareResultType());
    }

    @Test
    public void putDeleted() {
        PathsCompareResult pathsCompareResult = new PathsCompareResult();
        pathsCompareResult.putDeleted("/test/", new PathItem());
        assertEquals(CompareCriticalType.CRITICAL, pathsCompareResult.getCompareCriticalType());
        assertEquals(CompareResultType.CHANGED, pathsCompareResult.getCompareResultType());
    }
}