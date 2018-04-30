package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.paths.PathsCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class OpenAPICompareHolderTest {

    @Test
    public void testAllValuesSet() {
        OpenAPI openAPILeft = Mockito.mock(OpenAPI.class);
        OpenAPI openAPIRight = Mockito.mock(OpenAPI.class);

        Paths pathsLeft = Mockito.mock(Paths.class);
        Paths pathsRight = Mockito.mock(Paths.class);

        Mockito.when(openAPILeft.getPaths()).thenReturn(pathsLeft);
        Mockito.when(openAPIRight.getPaths()).thenReturn(pathsRight);

        Components componentsLeft =  Mockito.mock(Components.class);
        Components componentsRight =  Mockito.mock(Components.class);

        Mockito.when(openAPILeft.getComponents()).thenReturn(componentsLeft);
        Mockito.when(openAPIRight.getComponents()).thenReturn(componentsRight);

        ICompareResult pathsCompareResult = new LeafCompareResult(pathsLeft, pathsRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult componentsCompareResult = new LeafCompareResult(componentsLeft, componentsRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        PathsCompareHolder pathsCompareHolder = Mockito.mock(PathsCompareHolder.class);
        Mockito.when(pathsCompareHolder.compare(pathsLeft, pathsRight)).thenReturn(pathsCompareResult);

        ComponentsCompareHolder componentsCompareHolder = Mockito.mock(ComponentsCompareHolder.class);
        Mockito.when(componentsCompareHolder.compare(componentsLeft, componentsRight)).thenReturn(componentsCompareResult);

        CompareHolder openAPICompareHolder = new CompareHolder(pathsCompareHolder, componentsCompareHolder);

        ICompareResult actual = openAPICompareHolder.compare(openAPILeft, openAPIRight);

        assertEquals(pathsCompareResult, ((NodeCompareResult) actual).getValues().get("Paths"));
        assertEquals(componentsCompareResult, ((NodeCompareResult) actual).getValues().get("Components"));

    }

    @Test
    public void testCreated() {
        OpenAPI openAPILeft = Mockito.mock(OpenAPI.class);
        OpenAPI openAPIRight = Mockito.mock(OpenAPI.class);

        Paths pathsLeft = Mockito.mock(Paths.class);
        Paths pathsRight = Mockito.mock(Paths.class);

        Mockito.when(openAPILeft.getPaths()).thenReturn(null);
        Mockito.when(openAPIRight.getPaths()).thenReturn(pathsRight);

        Components componentsLeft =  Mockito.mock(Components.class);
        Components componentsRight =  Mockito.mock(Components.class);

        Mockito.when(openAPILeft.getComponents()).thenReturn(null);
        Mockito.when(openAPIRight.getComponents()).thenReturn(componentsRight);

        ICompareResult pathsCompareResult = new LeafCompareResult(pathsLeft, pathsRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult componentsCompareResult = new LeafCompareResult(componentsLeft, componentsRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        PathsCompareHolder pathsCompareHolder = Mockito.mock(PathsCompareHolder.class);
        Mockito.when(pathsCompareHolder.compare(null, pathsRight)).thenReturn(pathsCompareResult);

        ComponentsCompareHolder componentsCompareHolder = Mockito.mock(ComponentsCompareHolder.class);
        Mockito.when(componentsCompareHolder.compare(null, componentsRight)).thenReturn(componentsCompareResult);

        CompareHolder openAPICompareHolder = new CompareHolder(pathsCompareHolder, componentsCompareHolder);

        ICompareResult actual = openAPICompareHolder.compare(openAPILeft, openAPIRight);

        assertEquals(pathsCompareResult, ((NodeCompareResult) actual).getValues().get("Paths"));
        assertEquals(componentsCompareResult, ((NodeCompareResult) actual).getValues().get("Components"));

    }

    @Test
    public void testDeleted() {
        OpenAPI openAPILeft = Mockito.mock(OpenAPI.class);
        OpenAPI openAPIRight = Mockito.mock(OpenAPI.class);

        Paths pathsLeft = Mockito.mock(Paths.class);
        Paths pathsRight = Mockito.mock(Paths.class);

        Mockito.when(openAPILeft.getPaths()).thenReturn(pathsLeft);
        Mockito.when(openAPIRight.getPaths()).thenReturn(null);

        Components componentsLeft =  Mockito.mock(Components.class);
        Components componentsRight =  Mockito.mock(Components.class);

        Mockito.when(openAPILeft.getComponents()).thenReturn(componentsLeft);
        Mockito.when(openAPIRight.getComponents()).thenReturn(null);

        ICompareResult pathsCompareResult = new LeafCompareResult(pathsLeft, pathsRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult componentsCompareResult = new LeafCompareResult(componentsLeft, componentsRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        PathsCompareHolder pathsCompareHolder = Mockito.mock(PathsCompareHolder.class);
        Mockito.when(pathsCompareHolder.compare(pathsLeft, null)).thenReturn(pathsCompareResult);

        ComponentsCompareHolder componentsCompareHolder = Mockito.mock(ComponentsCompareHolder.class);
        Mockito.when(componentsCompareHolder.compare(componentsLeft, null)).thenReturn(componentsCompareResult);

        CompareHolder openAPICompareHolder = new CompareHolder(pathsCompareHolder, componentsCompareHolder);

        ICompareResult actual = openAPICompareHolder.compare(openAPILeft, openAPIRight);

        assertEquals(pathsCompareResult, ((NodeCompareResult) actual).getValues().get("Paths"));
        assertEquals(componentsCompareResult, ((NodeCompareResult) actual).getValues().get("Components"));

    }

    @Test
    public void testNoValueSet() {
        OpenAPI openAPILeft = Mockito.mock(OpenAPI.class);
        OpenAPI openAPIRight = Mockito.mock(OpenAPI.class);

        Paths pathsLeft = Mockito.mock(Paths.class);
        Paths pathsRight = Mockito.mock(Paths.class);

        Mockito.when(openAPILeft.getPaths()).thenReturn(null);
        Mockito.when(openAPIRight.getPaths()).thenReturn(null);

        Components componentsLeft =  Mockito.mock(Components.class);
        Components componentsRight =  Mockito.mock(Components.class);

        Mockito.when(openAPILeft.getComponents()).thenReturn(null);
        Mockito.when(openAPIRight.getComponents()).thenReturn(null);

        PathsCompareHolder pathsCompareHolder = Mockito.mock(PathsCompareHolder.class);

        ComponentsCompareHolder componentsCompareHolder = Mockito.mock(ComponentsCompareHolder.class);

        CompareHolder openAPICompareHolder = new CompareHolder(pathsCompareHolder, componentsCompareHolder);

        ICompareResult actual = openAPICompareHolder.compare(openAPILeft, openAPIRight);

        assertEquals(null, ((NodeCompareResult) actual).getValues().get("Paths"));
        assertEquals(null, ((NodeCompareResult) actual).getValues().get("Components"));

    }
}