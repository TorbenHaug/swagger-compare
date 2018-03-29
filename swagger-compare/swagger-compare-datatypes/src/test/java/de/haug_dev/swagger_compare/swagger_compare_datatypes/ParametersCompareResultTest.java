package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.parameters.Parameter;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ParametersCompareResultTest {

//    @Test
//    public void testUnchangedParameter() {
//        Set<Parameter> unchanged = new HashSet<>();
//        Set<Parameter> created = new HashSet<>();
//        Set<Parameter> deleted = new HashSet<>();
//        ParametersCompareResult parametersCompareResult = new ParametersCompareResult(unchanged, created, deleted);
//        assertEquals(CompareCriticalType.NONE, parametersCompareResult.getCompareCriticalType());
//        assertEquals(CompareResultType.UNCHANGED, parametersCompareResult.getCompareResultType());
//    }
//
//    @Test
//    public void testUnchangedParameter2() {
//        Set<Parameter> unchanged = new HashSet<Parameter>(Arrays.asList(new Parameter()));
//        Set<Parameter> created = new HashSet<>();
//        Set<Parameter> deleted = new HashSet<>();
//        ParametersCompareResult parametersCompareResult = new ParametersCompareResult(unchanged, created, deleted);
//        assertEquals(CompareCriticalType.NONE, parametersCompareResult.getCompareCriticalType());
//        assertEquals(CompareResultType.UNCHANGED, parametersCompareResult.getCompareResultType());
//    }
//
//    @Test
//    public void testCreatedParameter() {
//        Set<Parameter> unchanged = new HashSet<>();
//        Set<Parameter> created = new HashSet<Parameter>(Arrays.asList(new Parameter()));
//        Set<Parameter> deleted = new HashSet<>();
//        ParametersCompareResult parametersCompareResult = new ParametersCompareResult(unchanged, created, deleted);
//        assertEquals(CompareCriticalType.CRITICAL, parametersCompareResult.getCompareCriticalType());
//        assertEquals(CompareResultType.CHANGED, parametersCompareResult.getCompareResultType());
//    }
//
//    @Test
//    public void testDeletedParameter() {
//        Set<Parameter> unchanged = new HashSet<>();
//        Set<Parameter> created = new HashSet<>();
//        Set<Parameter> deleted = new HashSet<Parameter>(Arrays.asList(new Parameter()));
//        ParametersCompareResult parametersCompareResult = new ParametersCompareResult(unchanged, created, deleted);
//        assertEquals(CompareCriticalType.CRITICAL, parametersCompareResult.getCompareCriticalType());
//        assertEquals(CompareResultType.CHANGED, parametersCompareResult.getCompareResultType());
//    }
}