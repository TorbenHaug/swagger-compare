package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ParametersCompareResult;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ParametersCompareHolderTest {

    @Test
    public void testUnchanged() {
        Parameter parameterLeft1 = new Parameter();
        parameterLeft1.$ref("/test1");
        Parameter parameterLeft2 = new Parameter();
        parameterLeft2.$ref("/test2");
        Parameter parameterLeft3 = new Parameter();
        parameterLeft3.$ref("/test3");
        ArrayList<Parameter> parametersLeft = new ArrayList<>(Arrays.asList(parameterLeft1, parameterLeft2, parameterLeft3));
        ParametersCompareHolder left = new ParametersCompareHolder(parametersLeft);

        Parameter parameterRight1 = new Parameter();
        parameterRight1.$ref("/test1");
        Parameter parameterRight2 = new Parameter();
        parameterRight2.$ref("/test2");
        Parameter parameterRight3 = new Parameter();
        parameterRight3.$ref("/test3");
        ArrayList<Parameter> parametersRight = new ArrayList<>(Arrays.asList(parameterRight1, parameterRight2, parameterRight3));
        ParametersCompareHolder right = new ParametersCompareHolder(parametersRight);

        ParametersCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.UNCHANGED, actual.getCompareResultType());
        assertEquals(3, actual.getUnchanged().size());
        assertEquals(0, actual.getDeleted().size());
        assertEquals(0, actual.getCreated().size());
    }

    @Test
    public void testDeleted() {
        Parameter parameterLeft1 = new Parameter();
        parameterLeft1.$ref("/test1");
        Parameter parameterLeft2 = new Parameter();
        parameterLeft2.$ref("/test2");
        Parameter parameterLeft3 = new Parameter();
        parameterLeft3.$ref("/test3");
        ArrayList<Parameter> parametersLeft = new ArrayList<>(Arrays.asList(parameterLeft1, parameterLeft2, parameterLeft3));
        ParametersCompareHolder left = new ParametersCompareHolder(parametersLeft);

        Parameter parameterRight1 = new Parameter();
        parameterRight1.$ref("/test1");
        Parameter parameterRight2 = new Parameter();
        parameterRight2.$ref("/test2");
        ArrayList<Parameter> parametersRight = new ArrayList<>(Arrays.asList(parameterRight1, parameterRight2));
        ParametersCompareHolder right = new ParametersCompareHolder(parametersRight);

        ParametersCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
        assertEquals(2, actual.getUnchanged().size());
        assertEquals(1, actual.getDeleted().size());
        assertEquals(0, actual.getCreated().size());
    }

    @Test
    public void testCreated() {
        Parameter parameterLeft1 = new Parameter();
        parameterLeft1.$ref("/test1");
        Parameter parameterLeft2 = new Parameter();
        parameterLeft2.$ref("/test2");
        ArrayList<Parameter> parametersLeft = new ArrayList<>(Arrays.asList(parameterLeft1, parameterLeft2));
        ParametersCompareHolder left = new ParametersCompareHolder(parametersLeft);

        Parameter parameterRight1 = new Parameter();
        parameterRight1.$ref("/test1");
        Parameter parameterRight2 = new Parameter();
        parameterRight2.$ref("/test2");
        Parameter parameterRight3 = new Parameter();
        parameterRight3.$ref("/test3");
        ArrayList<Parameter> parametersRight = new ArrayList<>(Arrays.asList(parameterRight1, parameterRight2, parameterRight3));
        ParametersCompareHolder right = new ParametersCompareHolder(parametersRight);

        ParametersCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
        assertEquals(2, actual.getUnchanged().size());
        assertEquals(0, actual.getDeleted().size());
        assertEquals(1, actual.getCreated().size());
    }
}