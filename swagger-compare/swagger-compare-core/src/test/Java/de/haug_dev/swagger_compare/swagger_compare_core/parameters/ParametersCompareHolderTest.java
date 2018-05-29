package de.haug_dev.swagger_compare.swagger_compare_core.parameters;

import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParameterCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParametersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

public class ParametersCompareHolderTest {

    @Test
    public void compareWithEqualValues() {
        String parameterNameLeft = "var1";
        Parameter parameterLeft = new Parameter();
        Map<String, Parameter> parametersLeft = new HashMap<>();
        parametersLeft.put(parameterNameLeft, parameterLeft);

        String parameterNameRight = "var1";
        Parameter parameterRight = new Parameter();
        Map<String, Parameter> parametersRight = new HashMap<>();
        parametersRight.put(parameterNameRight, parameterRight);

        ICompareResult compareResult1 = new LeafCompareResult(parameterLeft, parameterRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ParameterCompareHolder parameterCompareHolder = Mockito.mock(ParameterCompareHolder.class);
        Mockito.when(parameterCompareHolder.compare(eq(parameterLeft), eq(parameterRight), any(), any())).thenReturn(compareResult1);

        BidiMap<String, String> normalizedNamesLeft = new DualHashBidiMap<>();
        normalizedNamesLeft.put("var1", "nameLeft");

        BidiMap<String, String> normalizedNamesRight = new DualHashBidiMap<>();
        normalizedNamesRight.put("var1", "nameRight");

        ParametersCompareHolder parametersCompareHolder = new ParametersCompareHolder(parameterCompareHolder);
        parametersCompareHolder.setNormalizedParameterNames(normalizedNamesLeft, normalizedNamesRight);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("nameRight", compareResult1);

        ICompareResult actual = parametersCompareHolder.compare(parametersLeft, parametersRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareCreatedDeletedValues() {
        String parameterNameLeft = "var1";
        Parameter parameterLeft = new Parameter();
        Map<String, Parameter> parametersLeft = new HashMap<>();
        parametersLeft.put(parameterNameLeft, parameterLeft);

        String parameterNameRight = "var2";
        Parameter parameterRight = new Parameter();
        Map<String, Parameter> parametersRight = new HashMap<>();
        parametersRight.put(parameterNameRight, parameterRight);

        ICompareResult compareResult1 = new LeafCompareResult(parameterLeft, null, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult compareResult2 = new LeafCompareResult(null, parameterRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ParameterCompareHolder parameterCompareHolder = Mockito.mock(ParameterCompareHolder.class);
        Mockito.when(parameterCompareHolder.compare(eq(parameterLeft), eq(null), any(), any())).thenReturn(compareResult1);
        Mockito.when(parameterCompareHolder.compare(eq(null), eq(parameterRight), any(), any())).thenReturn(compareResult2);

        BidiMap<String, String> normalizedNamesLeft = new DualHashBidiMap<>();
        normalizedNamesLeft.put("var1", "nameLeft");

        BidiMap<String, String> normalizedNamesRight = new DualHashBidiMap<>();
        normalizedNamesRight.put("var2", "nameRight");

        ParametersCompareHolder parametersCompareHolder = new ParametersCompareHolder(parameterCompareHolder);
        parametersCompareHolder.setNormalizedParameterNames(normalizedNamesLeft, normalizedNamesRight);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("nameLeft", compareResult1);
        expected.put("nameRight", compareResult2);

        ICompareResult actual = parametersCompareHolder.compare(parametersLeft, parametersRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareCreatedDeletedWithoutTranslationValues() {
        String parameterNameLeft = "var1";
        Parameter parameterLeft = new Parameter();
        Map<String, Parameter> parametersLeft = new HashMap<>();
        parametersLeft.put(parameterNameLeft, parameterLeft);

        String parameterNameRight = "var2";
        Parameter parameterRight = new Parameter();
        Map<String, Parameter> parametersRight = new HashMap<>();
        parametersRight.put(parameterNameRight, parameterRight);

        ICompareResult compareResult1 = new LeafCompareResult(parameterLeft, null, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult compareResult2 = new LeafCompareResult(null, parameterRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ParameterCompareHolder parameterCompareHolder = Mockito.mock(ParameterCompareHolder.class);
        Mockito.when(parameterCompareHolder.compare(eq(parameterLeft), eq(null), any(), any())).thenReturn(compareResult1);
        Mockito.when(parameterCompareHolder.compare(eq(null), eq(parameterRight), any(), any())).thenReturn(compareResult2);

        BidiMap<String, String> normalizedNamesLeft = new DualHashBidiMap<>();

        BidiMap<String, String> normalizedNamesRight = new DualHashBidiMap<>();

        ParametersCompareHolder parametersCompareHolder = new ParametersCompareHolder(parameterCompareHolder);
        parametersCompareHolder.setNormalizedParameterNames(normalizedNamesLeft, normalizedNamesRight);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("var1", compareResult1);
        expected.put("var2", compareResult2);

        ICompareResult actual = parametersCompareHolder.compare(parametersLeft, parametersRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }
}