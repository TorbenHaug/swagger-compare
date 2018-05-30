package de.haug_dev.swagger_compare.swagger_compare_core.examples;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.examples.Example;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        Mockito.when(exampleCompareHolder.compare(eq(exampleLeft1), eq(exampleRight1), any(), any())).thenReturn(compareResult1);
        Mockito.when(exampleCompareHolder.compare(eq(null), eq(exampleRight2), any(), any())).thenReturn(compareResult2);
        Mockito.when(exampleCompareHolder.compare(eq(exampleLeft2), eq(null), any(), any())).thenReturn(compareResult3);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("example1", compareResult1);
        expected.put("exampleRight2", compareResult2);
        expected.put("exampleLeft2", compareResult3);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getExampleCompareHolder()).thenReturn(exampleCompareHolder);

        ExamplesCompareHolder examplesCompareHolder = new ExamplesCompareHolder(compareHolderFactory);
        ICompareResult actual = examplesCompareHolder.compare(examplesLeft, examplesRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);

    }
}