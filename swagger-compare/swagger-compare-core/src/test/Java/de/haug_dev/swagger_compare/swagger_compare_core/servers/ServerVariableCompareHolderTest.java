package de.haug_dev.swagger_compare.swagger_compare_core.servers;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.servers.ServerVariable;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ServerVariableCompareHolderTest {

    @Test
    public void compareNullNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();

        ServerVariable leftValue = null;
        ServerVariable rightValue = null;

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = compareHolderFactory.getServerVariableCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareNullEmptyValue() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();

        ServerVariable leftValue = null;
        ServerVariable rightValue = new ServerVariable();

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = compareHolderFactory.getServerVariableCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareEmptyValueNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();

        ServerVariable leftValue = new ServerVariable();
        ServerVariable rightValue = null;

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = compareHolderFactory.getServerVariableCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareDeleted() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();

        ServerVariable leftValue = new ServerVariable();
        leftValue.setDescription("Test");
        leftValue.setDefault("Test");
        leftValue.setEnum(Arrays.asList("Test1", "Test2"));
        ServerVariable rightValue = null;

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Description", new LeafCompareResult(leftValue.getDescription(), null, CompareResultType.DELETED, CompareCriticalType.INFO));
        expected.put("Default", new LeafCompareResult(leftValue.getDefault(), null, CompareResultType.DELETED, CompareCriticalType.CRITICAL));
        expected.put("Enum", new LeafCompareResult(leftValue.getEnum(), null, CompareResultType.DELETED, CompareCriticalType.CRITICAL));

        ICompareResult actual = compareHolderFactory.getServerVariableCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareCreated() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();

        ServerVariable leftValue = null;
        ServerVariable rightValue = new ServerVariable();
        rightValue.setDescription("Test");
        rightValue.setDefault("Test");
        rightValue.setEnum(Arrays.asList("Test1", "Test2"));

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Description", new LeafCompareResult(null, rightValue.getDescription(), CompareResultType.CREATED, CompareCriticalType.INFO));
        expected.put("Default", new LeafCompareResult(null, rightValue.getDefault(), CompareResultType.CREATED, CompareCriticalType.CRITICAL));
        expected.put("Enum", new LeafCompareResult(null, rightValue.getEnum(), CompareResultType.CREATED, CompareCriticalType.CRITICAL));

        ICompareResult actual = compareHolderFactory.getServerVariableCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareUnchanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();

        ServerVariable leftValue = new ServerVariable();
        leftValue.setDescription("Test");
        leftValue.setDefault("Test");
        leftValue.setEnum(Arrays.asList("Test1", "Test2"));
        ServerVariable rightValue = new ServerVariable();
        rightValue.setDescription("Test");
        rightValue.setDefault("Test");
        rightValue.setEnum(Arrays.asList("Test1", "Test2"));

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Description", new LeafCompareResult(leftValue.getDescription(), rightValue.getDescription(), CompareResultType.UNCHANGED, CompareCriticalType.NONE));
        expected.put("Default", new LeafCompareResult(leftValue.getDefault(), rightValue.getDefault(), CompareResultType.UNCHANGED, CompareCriticalType.NONE));
        expected.put("Enum", new LeafCompareResult(leftValue.getEnum(), rightValue.getEnum(), CompareResultType.UNCHANGED, CompareCriticalType.NONE));

        ICompareResult actual = compareHolderFactory.getServerVariableCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareChanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();

        ServerVariable leftValue = new ServerVariable();
        leftValue.setDescription("Test");
        leftValue.setDefault("Test");
        leftValue.setEnum(Arrays.asList("Test1", "Test2"));
        ServerVariable rightValue = new ServerVariable();
        rightValue.setDescription("Test1");
        rightValue.setDefault("Test1");
        rightValue.setEnum(Arrays.asList("Test11", "Test21"));

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Description", new LeafCompareResult(leftValue.getDescription(), rightValue.getDescription(), CompareResultType.CHANGED, CompareCriticalType.INFO));
        expected.put("Default", new LeafCompareResult(leftValue.getDefault(), rightValue.getDefault(), CompareResultType.CHANGED, CompareCriticalType.CRITICAL));
        expected.put("Enum", new LeafCompareResult(leftValue.getEnum(), rightValue.getEnum(), CompareResultType.CHANGED, CompareCriticalType.CRITICAL));

        ICompareResult actual = compareHolderFactory.getServerVariableCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }
}