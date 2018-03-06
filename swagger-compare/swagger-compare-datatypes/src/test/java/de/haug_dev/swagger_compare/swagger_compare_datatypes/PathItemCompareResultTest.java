package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.Operation;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PathItemCompareResultTest {
    @Test
    public void testNothingChanged() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        RefCompareResult refCompareResult = Mockito.mock(RefCompareResult.class);
        Mockito.when(refCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(refCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Map<String, Operation> createdOperations = new HashMap<>();
        Map<String, Operation> deletedOperations = new HashMap<>();
        Map<String, Operation> unchangedOperations = new HashMap<>();
        Map<String, OperationCompareResult> changedOperations = new HashMap<>();
        PathItemCompareResult pathItemCompareResult = new PathItemCompareResult(
                parametersCompareResult,
                refCompareResult,
                createdOperations,
                deletedOperations,
                unchangedOperations,
                changedOperations);
        assertEquals(CompareCriticalType.NONE, pathItemCompareResult.getCompareCriticalType());
        assertEquals(CompareResultType.UNCHANGED, pathItemCompareResult.getCompareResultType());
    }

    @Test
    public void testParmetersChanged() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.CRITICAL);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        RefCompareResult refCompareResult = Mockito.mock(RefCompareResult.class);
        Mockito.when(refCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(refCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Map<String, Operation> createdOperations = new HashMap<>();
        Map<String, Operation> deletedOperations = new HashMap<>();
        Map<String, Operation> unchangedOperations = new HashMap<>();
        Map<String, OperationCompareResult> changedOperations = new HashMap<>();
        PathItemCompareResult pathItemCompareResult = new PathItemCompareResult(
                parametersCompareResult,
                refCompareResult,
                createdOperations,
                deletedOperations,
                unchangedOperations,
                changedOperations);
        assertEquals(CompareCriticalType.CRITICAL, pathItemCompareResult.getCompareCriticalType());
        assertEquals(CompareResultType.CHANGED, pathItemCompareResult.getCompareResultType());
    }

    @Test
    public void testRefChanged() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        RefCompareResult refCompareResult = Mockito.mock(RefCompareResult.class);
        Mockito.when(refCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.CRITICAL);
        Mockito.when(refCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        Map<String, Operation> createdOperations = new HashMap<>();
        Map<String, Operation> deletedOperations = new HashMap<>();
        Map<String, Operation> unchangedOperations = new HashMap<>();
        Map<String, OperationCompareResult> changedOperations = new HashMap<>();
        PathItemCompareResult pathItemCompareResult = new PathItemCompareResult(
                parametersCompareResult,
                refCompareResult,
                createdOperations,
                deletedOperations,
                unchangedOperations,
                changedOperations);
        assertEquals(CompareCriticalType.CRITICAL, pathItemCompareResult.getCompareCriticalType());
        assertEquals(CompareResultType.CHANGED, pathItemCompareResult.getCompareResultType());
    }

    @Test
    public void testCreatedOperation() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        RefCompareResult refCompareResult = Mockito.mock(RefCompareResult.class);
        Mockito.when(refCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(refCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Operation operation = new Operation();
        Map<String, Operation> createdOperations = new HashMap<>();
        createdOperations.put("test", operation);
        Map<String, Operation> deletedOperations = new HashMap<>();
        Map<String, Operation> unchangedOperations = new HashMap<>();
        Map<String, OperationCompareResult> changedOperations = new HashMap<>();
        PathItemCompareResult pathItemCompareResult = new PathItemCompareResult(
                parametersCompareResult,
                refCompareResult,
                createdOperations,
                deletedOperations,
                unchangedOperations,
                changedOperations);
        assertEquals(CompareCriticalType.INFO, pathItemCompareResult.getCompareCriticalType());
        assertEquals(CompareResultType.CHANGED, pathItemCompareResult.getCompareResultType());
    }
    @Test
    public void testDeleteOperation() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        RefCompareResult refCompareResult = Mockito.mock(RefCompareResult.class);
        Mockito.when(refCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(refCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Operation operation = new Operation();
        Map<String, Operation> createdOperations = new HashMap<>();
        Map<String, Operation> deletedOperations = new HashMap<>();
        deletedOperations.put("test", operation);
        Map<String, Operation> unchangedOperations = new HashMap<>();
        Map<String, OperationCompareResult> changedOperations = new HashMap<>();
        PathItemCompareResult pathItemCompareResult = new PathItemCompareResult(
                parametersCompareResult,
                refCompareResult,
                createdOperations,
                deletedOperations,
                unchangedOperations,
                changedOperations);
        assertEquals(CompareCriticalType.CRITICAL, pathItemCompareResult.getCompareCriticalType());
        assertEquals(CompareResultType.CHANGED, pathItemCompareResult.getCompareResultType());
    }

    @Test
    public void testUnchangedOperation() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        RefCompareResult refCompareResult = Mockito.mock(RefCompareResult.class);
        Mockito.when(refCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(refCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Operation operation = new Operation();
        Map<String, Operation> createdOperations = new HashMap<>();
        Map<String, Operation> deletedOperations = new HashMap<>();
        Map<String, Operation> unchangedOperations = new HashMap<>();
        unchangedOperations.put("test", operation);
        Map<String, OperationCompareResult> changedOperations = new HashMap<>();
        PathItemCompareResult pathItemCompareResult = new PathItemCompareResult(
                parametersCompareResult,
                refCompareResult,
                createdOperations,
                deletedOperations,
                unchangedOperations,
                changedOperations);
        assertEquals(CompareCriticalType.NONE, pathItemCompareResult.getCompareCriticalType());
        assertEquals(CompareResultType.UNCHANGED, pathItemCompareResult.getCompareResultType());
    }

    @Test
    public void testChangedOperation() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        RefCompareResult refCompareResult = Mockito.mock(RefCompareResult.class);
        Mockito.when(refCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        Mockito.when(refCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        OperationCompareResult operation = Mockito.mock(OperationCompareResult.class);
        Mockito.when(operation.getCompareCriticalType()).thenReturn(CompareCriticalType.WARNING);
        Mockito.when(operation.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        Map<String, Operation> createdOperations = new HashMap<>();
        Map<String, Operation> deletedOperations = new HashMap<>();
        Map<String, Operation> unchangedOperations = new HashMap<>();
        Map<String, OperationCompareResult> changedOperations = new HashMap<>();
        changedOperations.put("test", operation);
        PathItemCompareResult pathItemCompareResult = new PathItemCompareResult(
                parametersCompareResult,
                refCompareResult,
                createdOperations,
                deletedOperations,
                unchangedOperations,
                changedOperations);
        assertEquals(CompareCriticalType.WARNING, pathItemCompareResult.getCompareCriticalType());
        assertEquals(CompareResultType.CHANGED, pathItemCompareResult.getCompareResultType());
    }
}