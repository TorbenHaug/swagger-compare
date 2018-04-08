package de.haug_dev.swagger_compare.swagger_compare_core.examples;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.examples.Example;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ExamplesCompareHolderTest {

    @Test
    public void compareWith() {
        Example exampleLeft1 = new Example();
        Example exampleLeft2 = new Example();
        Map<String, Example> examplesLeft = new HashMap<>();
        examplesLeft.put("example1", exampleLeft1);
        examplesLeft.put("exampleLeft2", exampleLeft2);

        Example exampleRight1 = new Example();
        Example exampleRight2 = new Example();
        Map<String, Example> examplesRight = new HashMap<>();
        examplesRight.put("example1", exampleRight1);
        examplesRight.put("exampleRight2", exampleRight2);

        LeafCompareResult compareResult1 = new LeafCompareResult(exampleLeft1, exampleRight1, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        LeafCompareResult compareResult2 = new LeafCompareResult(null, exampleRight2, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        LeafCompareResult compareResult3 = new LeafCompareResult(exampleLeft2, null, CompareResultType.UNCHANGED, CompareCriticalType.NONE);

        ExampleCompareHolder exampleCompareHolder = Mockito.mock(ExampleCompareHolder.class);
        Mockito.when(exampleCompareHolder.compare(exampleLeft1, exampleRight1)).thenReturn(compareResult1);
        Mockito.when(exampleCompareHolder.compare(null, exampleRight2)).thenReturn(compareResult2);
        Mockito.when(exampleCompareHolder.compare(exampleLeft2, null)).thenReturn(compareResult3);

        NodeCompareResult expected = new NodeCompareResult();
        expected.put("example1", compareResult1);
        expected.put("exampleRight2", compareResult2);
        expected.put("exampleLeft2", compareResult3);


        ExamplesCompareHolder examplesCompareHolder = new ExamplesCompareHolder(exampleCompareHolder);
        ICompareResult actual = examplesCompareHolder.compare(examplesLeft, examplesRight);

        assertEquals(expected, actual);

    }
}