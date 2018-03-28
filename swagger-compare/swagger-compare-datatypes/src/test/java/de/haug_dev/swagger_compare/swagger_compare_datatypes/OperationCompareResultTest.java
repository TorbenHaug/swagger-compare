package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class OperationCompareResultTest {

    @Test
    public void testNothingChanged() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        DeprecatedCompareResult deprecatedCompareResult = Mockito.mock(DeprecatedCompareResult.class);
        Mockito.when(deprecatedCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(deprecatedCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        RequestBodyCompareResult requestBodyCompareResult = Mockito.mock(RequestBodyCompareResult.class);
        Mockito.when(requestBodyCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(requestBodyCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        ResponsesCompareResult responsesCompareResult = Mockito.mock(ResponsesCompareResult.class);
        Mockito.when(responsesCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(responsesCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);

        OperationCompareResult operationCompareResult = new OperationCompareResult(
                parametersCompareResult,
                deprecatedCompareResult,
                requestBodyCompareResult,
                responsesCompareResult);
        assertEquals(CompareResultType.UNCHANGED, operationCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.NONE, operationCompareResult.getCompareCriticalType());
    }

    @Test
    public void testParametersChanged() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.CRITICAL);
        DeprecatedCompareResult deprecatedCompareResult = Mockito.mock(DeprecatedCompareResult.class);
        Mockito.when(deprecatedCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(deprecatedCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        RequestBodyCompareResult requestBodyCompareResult = Mockito.mock(RequestBodyCompareResult.class);
        Mockito.when(requestBodyCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(requestBodyCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        ResponsesCompareResult responsesCompareResult = Mockito.mock(ResponsesCompareResult.class);
        Mockito.when(responsesCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(responsesCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);

        OperationCompareResult operationCompareResult = new OperationCompareResult(
                parametersCompareResult,
                deprecatedCompareResult,
                requestBodyCompareResult,
                responsesCompareResult);
        assertEquals(CompareResultType.CHANGED, operationCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.CRITICAL, operationCompareResult.getCompareCriticalType());
    }

    @Test
    public void testDeprecatedChanged() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        DeprecatedCompareResult deprecatedCompareResult = Mockito.mock(DeprecatedCompareResult.class);
        Mockito.when(deprecatedCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        Mockito.when(deprecatedCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.CRITICAL);
        RequestBodyCompareResult requestBodyCompareResult = Mockito.mock(RequestBodyCompareResult.class);
        Mockito.when(requestBodyCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(requestBodyCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        ResponsesCompareResult responsesCompareResult = Mockito.mock(ResponsesCompareResult.class);
        Mockito.when(responsesCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(responsesCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);

        OperationCompareResult operationCompareResult = new OperationCompareResult(
                parametersCompareResult,
                deprecatedCompareResult,
                requestBodyCompareResult,
                responsesCompareResult);
        assertEquals(CompareResultType.CHANGED, operationCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.CRITICAL, operationCompareResult.getCompareCriticalType());
    }

    @Test
    public void testRequestBodyChanged() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        DeprecatedCompareResult deprecatedCompareResult = Mockito.mock(DeprecatedCompareResult.class);
        Mockito.when(deprecatedCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(deprecatedCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        RequestBodyCompareResult requestBodyCompareResult = Mockito.mock(RequestBodyCompareResult.class);
        Mockito.when(requestBodyCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        Mockito.when(requestBodyCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.CRITICAL);
        ResponsesCompareResult responsesCompareResult = Mockito.mock(ResponsesCompareResult.class);
        Mockito.when(responsesCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(responsesCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);

        OperationCompareResult operationCompareResult = new OperationCompareResult(
                parametersCompareResult,
                deprecatedCompareResult,
                requestBodyCompareResult,
                responsesCompareResult);
        assertEquals(CompareResultType.CHANGED, operationCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.CRITICAL, operationCompareResult.getCompareCriticalType());
    }

    @Test
    public void testApiResponsesChanged() {
        ParametersCompareResult parametersCompareResult = Mockito.mock(ParametersCompareResult.class);
        Mockito.when(parametersCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(parametersCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        DeprecatedCompareResult deprecatedCompareResult = Mockito.mock(DeprecatedCompareResult.class);
        Mockito.when(deprecatedCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(deprecatedCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        RequestBodyCompareResult requestBodyCompareResult = Mockito.mock(RequestBodyCompareResult.class);
        Mockito.when(requestBodyCompareResult.getCompareResultType()).thenReturn(CompareResultType.UNCHANGED);
        Mockito.when(requestBodyCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.NONE);
        ResponsesCompareResult responsesCompareResult = Mockito.mock(ResponsesCompareResult.class);
        Mockito.when(responsesCompareResult.getCompareResultType()).thenReturn(CompareResultType.CHANGED);
        Mockito.when(responsesCompareResult.getCompareCriticalType()).thenReturn(CompareCriticalType.CRITICAL);

        OperationCompareResult operationCompareResult = new OperationCompareResult(
                parametersCompareResult,
                deprecatedCompareResult,
                requestBodyCompareResult,
                responsesCompareResult);
        assertEquals(CompareResultType.CHANGED, operationCompareResult.getCompareResultType());
        assertEquals(CompareCriticalType.CRITICAL, operationCompareResult.getCompareCriticalType());
    }
}