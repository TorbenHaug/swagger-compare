package de.haug_dev.swagger_compare.swagger_compare_core.examples;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.examples.Example;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleCompareHolderTest {

    @Test
    public void compareUnchangedValues() {
        String refLeft = "#/components/examples/refLeft";
        String summaryLeft = "summaryLeft";
        String descriptionLeft = "descriptionLeft";
        String valueLeft = "valueLeft";
        String externalValueLeft = "externalValueLeft";
        Example leftExample = new Example();
        leftExample.set$ref(refLeft);
        leftExample.setSummary(summaryLeft);
        leftExample.setDescription(descriptionLeft);
        leftExample.setValue(valueLeft);
        leftExample.setExternalValue(externalValueLeft);

        String refRight = "#/components/examples/refLeft";
        String summaryRight = "summaryLeft";
        String descriptionRight = "descriptionLeft";
        String valueRight = "valueLeft";
        String externalValueRight = "externalValueLeft";
        Example rightExample = new Example();
        rightExample.set$ref(refRight);
        rightExample.setSummary(summaryRight);
        rightExample.setDescription(descriptionRight);
        rightExample.setValue(valueRight);
        rightExample.setExternalValue(externalValueRight);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("Ref", new LeafCompareResult(refLeft, refRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE));
        expected.put("Summary", new LeafCompareResult(summaryLeft, summaryRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE));
        expected.put("Description", new LeafCompareResult(descriptionLeft, descriptionRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE));
        expected.put("Value", new LeafCompareResult(valueLeft, valueRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE));
        expected.put("ExternalValue", new LeafCompareResult(externalValueLeft, externalValueRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE));

        ExampleCompareHolder exampleCompareHolder = new ExampleCompareHolder();

        ICompareResult actual = exampleCompareHolder.compare(leftExample, rightExample, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareChangedValues() {
        String refLeft = "#/components/examples/refLeft";
        String summaryLeft = "summaryLeft";
        String descriptionLeft = "descriptionLeft";
        String valueLeft = "valueLeft";
        String externalValueLeft = "externalValueLeft";
        Example leftExample = new Example();
        leftExample.set$ref(refLeft);
        leftExample.setSummary(summaryLeft);
        leftExample.setDescription(descriptionLeft);
        leftExample.setValue(valueLeft);
        leftExample.setExternalValue(externalValueLeft);

        String refRight = "#/components/examples/refRight";
        String summaryRight = "summaryRight";
        String descriptionRight = "descriptionRight";
        String valueRight = "valueRight";
        String externalValueRight = "externalValueRight";
        Example rightExample = new Example();
        rightExample.set$ref(refRight);
        rightExample.setSummary(summaryRight);
        rightExample.setDescription(descriptionRight);
        rightExample.setValue(valueRight);
        rightExample.setExternalValue(externalValueRight);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("Ref", new LeafCompareResult(refLeft, refRight, CompareResultType.CHANGED, CompareCriticalType.CRITICAL));
        expected.put("Summary", new LeafCompareResult(summaryLeft, summaryRight, CompareResultType.CHANGED, CompareCriticalType.INFO));
        expected.put("Description", new LeafCompareResult(descriptionLeft, descriptionRight, CompareResultType.CHANGED, CompareCriticalType.INFO));
        expected.put("Value", new LeafCompareResult(valueLeft, valueRight, CompareResultType.CHANGED, CompareCriticalType.WARNING));
        expected.put("ExternalValue", new LeafCompareResult(externalValueLeft, externalValueRight, CompareResultType.CHANGED, CompareCriticalType.WARNING));

        ExampleCompareHolder exampleCompareHolder = new ExampleCompareHolder();

        ICompareResult actual = exampleCompareHolder.compare(leftExample, rightExample, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareDeleteValues() {
        String refLeft = "#/components/examples/refLeft";
        String summaryLeft = "summaryLeft";
        String descriptionLeft = "descriptionLeft";
        String valueLeft = "valueLeft";
        String externalValueLeft = "externalValueLeft";
        Example leftExample = new Example();
        leftExample.set$ref(refLeft);
        leftExample.setSummary(summaryLeft);
        leftExample.setDescription(descriptionLeft);
        leftExample.setValue(valueLeft);
        leftExample.setExternalValue(externalValueLeft);

        String refRight = null;
        String summaryRight = null;
        String descriptionRight = null;
        String valueRight = null;
        String externalValueRight = null;
        Example rightExample = new Example();
        rightExample.set$ref(refRight);
        rightExample.setSummary(summaryRight);
        rightExample.setDescription(descriptionRight);
        rightExample.setValue(valueRight);
        rightExample.setExternalValue(externalValueRight);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("Ref", new LeafCompareResult(refLeft, refRight, CompareResultType.DELETED, CompareCriticalType.CRITICAL));
        expected.put("Summary", new LeafCompareResult(summaryLeft, summaryRight, CompareResultType.DELETED, CompareCriticalType.INFO));
        expected.put("Description", new LeafCompareResult(descriptionLeft, descriptionRight, CompareResultType.DELETED, CompareCriticalType.INFO));
        expected.put("Value", new LeafCompareResult(valueLeft, valueRight, CompareResultType.DELETED, CompareCriticalType.WARNING));
        expected.put("ExternalValue", new LeafCompareResult(externalValueLeft, externalValueRight, CompareResultType.DELETED, CompareCriticalType.WARNING));

        ExampleCompareHolder exampleCompareHolder = new ExampleCompareHolder();

        ICompareResult actual = exampleCompareHolder.compare(leftExample, rightExample, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareCreateValues() {
        String refLeft = null;
        String summaryLeft = null;
        String descriptionLeft = null;
        String valueLeft = null;
        String externalValueLeft = null;
        Example leftExample = new Example();
        leftExample.set$ref(refLeft);
        leftExample.setSummary(summaryLeft);
        leftExample.setDescription(descriptionLeft);
        leftExample.setValue(valueLeft);
        leftExample.setExternalValue(externalValueLeft);

        String refRight = "#/components/examples/refRight";
        String summaryRight = "summaryRight";
        String descriptionRight = "descriptionRight";
        String valueRight = "valueRight";
        String externalValueRight = "externalValueRight";
        Example rightExample = new Example();
        rightExample.set$ref(refRight);
        rightExample.setSummary(summaryRight);
        rightExample.setDescription(descriptionRight);
        rightExample.setValue(valueRight);
        rightExample.setExternalValue(externalValueRight);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("Ref", new LeafCompareResult(refLeft, refRight, CompareResultType.CREATED, CompareCriticalType.CRITICAL));
        expected.put("Summary", new LeafCompareResult(summaryLeft, summaryRight, CompareResultType.CREATED, CompareCriticalType.INFO));
        expected.put("Description", new LeafCompareResult(descriptionLeft, descriptionRight, CompareResultType.CREATED, CompareCriticalType.INFO));
        expected.put("Value", new LeafCompareResult(valueLeft, valueRight, CompareResultType.CREATED, CompareCriticalType.WARNING));
        expected.put("ExternalValue", new LeafCompareResult(externalValueLeft, externalValueRight, CompareResultType.CREATED, CompareCriticalType.WARNING));

        ExampleCompareHolder exampleCompareHolder = new ExampleCompareHolder();

        ICompareResult actual = exampleCompareHolder.compare(leftExample, rightExample, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }
}