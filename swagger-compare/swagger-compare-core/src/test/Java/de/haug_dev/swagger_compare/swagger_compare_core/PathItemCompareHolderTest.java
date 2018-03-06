package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.PathItemCompareResult;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PathItemCompareHolderTest {
    @Test
    public void testUnchanged() {
        Operation operationLeft = new Operation();
        PathItem pathItemLeft = new PathItem();
        pathItemLeft.get(operationLeft);
        pathItemLeft.put(operationLeft);
        pathItemLeft.post(operationLeft);
        pathItemLeft.delete(operationLeft);
        pathItemLeft.options(operationLeft);
        pathItemLeft.head(operationLeft);
        pathItemLeft.patch(operationLeft);
        pathItemLeft.trace(operationLeft);
        pathItemLeft.$ref("/test/");
        pathItemLeft.parameters(new ArrayList<>());
        PathItemCompareHolder left = new PathItemCompareHolder(pathItemLeft);

        Operation operationRight = new Operation();
        PathItem pathItemRight = new PathItem();
        pathItemRight.get(operationRight);
        pathItemRight.put(operationRight);
        pathItemRight.post(operationRight);
        pathItemRight.delete(operationRight);
        pathItemRight.options(operationRight);
        pathItemRight.head(operationRight);
        pathItemRight.patch(operationRight);
        pathItemRight.trace(operationRight);
        pathItemRight.$ref("/test/");
        pathItemRight.parameters(new ArrayList<>());
        PathItemCompareHolder right = new PathItemCompareHolder(pathItemRight);

        PathItemCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.UNCHANGED, actual.getCompareResultType());
        assertEquals(8, actual.getUnchangedOperations().size());
        assertEquals(0, actual.getDeletedOperations().size());
        assertEquals(0, actual.getCreatedOperations().size());
        assertEquals(0, actual.getChangedOperations().size());
    }

    @Test
    public void testDeleteOperation() {
        Operation operationLeft = new Operation();
        PathItem pathItemLeft = new PathItem();
        pathItemLeft.get(operationLeft);
        pathItemLeft.put(operationLeft);
        pathItemLeft.post(operationLeft);
        pathItemLeft.delete(operationLeft);
        pathItemLeft.options(operationLeft);
        pathItemLeft.head(operationLeft);
        pathItemLeft.patch(operationLeft);
        pathItemLeft.trace(operationLeft);
        pathItemLeft.$ref("/test/");
        pathItemLeft.parameters(new ArrayList<>());
        PathItemCompareHolder left = new PathItemCompareHolder(pathItemLeft);

        Operation operationRight = new Operation();
        PathItem pathItemRight = new PathItem();
        pathItemRight.put(operationRight);
        pathItemRight.post(operationRight);
        pathItemRight.delete(operationRight);
        pathItemRight.options(operationRight);
        pathItemRight.head(operationRight);
        pathItemRight.patch(operationRight);
        pathItemRight.trace(operationRight);
        pathItemRight.$ref("/test/");
        pathItemRight.parameters(new ArrayList<>());
        PathItemCompareHolder right = new PathItemCompareHolder(pathItemRight);

        PathItemCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
        assertEquals(7, actual.getUnchangedOperations().size());
        assertEquals(1, actual.getDeletedOperations().size());
        assertEquals(0, actual.getCreatedOperations().size());
        assertEquals(0, actual.getChangedOperations().size());
    }

    @Test
    public void testCreateOperation() {
        Operation operationLeft = new Operation();
        PathItem pathItemLeft = new PathItem();
        pathItemLeft.put(operationLeft);
        pathItemLeft.post(operationLeft);
        pathItemLeft.delete(operationLeft);
        pathItemLeft.options(operationLeft);
        pathItemLeft.head(operationLeft);
        pathItemLeft.patch(operationLeft);
        pathItemLeft.trace(operationLeft);
        pathItemLeft.$ref("/test/");
        pathItemLeft.parameters(new ArrayList<>());
        PathItemCompareHolder left = new PathItemCompareHolder(pathItemLeft);

        Operation operationRight = new Operation();
        PathItem pathItemRight = new PathItem();
        pathItemRight.get(operationRight);
        pathItemRight.put(operationRight);
        pathItemRight.post(operationRight);
        pathItemRight.delete(operationRight);
        pathItemRight.options(operationRight);
        pathItemRight.head(operationRight);
        pathItemRight.patch(operationRight);
        pathItemRight.trace(operationRight);
        pathItemRight.$ref("/test/");
        pathItemRight.parameters(new ArrayList<>());
        PathItemCompareHolder right = new PathItemCompareHolder(pathItemRight);

        PathItemCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
        assertEquals(7, actual.getUnchangedOperations().size());
        assertEquals(0, actual.getDeletedOperations().size());
        assertEquals(1, actual.getCreatedOperations().size());
        assertEquals(0, actual.getChangedOperations().size());
    }

    @Test
    public void testChangeGetOperation() {
        Operation operationLeft = new Operation();
        PathItem pathItemLeft = new PathItem();
        pathItemLeft.get(operationLeft);
        pathItemLeft.put(operationLeft);
        pathItemLeft.post(operationLeft);
        pathItemLeft.delete(operationLeft);
        pathItemLeft.options(operationLeft);
        pathItemLeft.head(operationLeft);
        pathItemLeft.patch(operationLeft);
        pathItemLeft.trace(operationLeft);
        pathItemLeft.$ref("/test/");
        pathItemLeft.parameters(new ArrayList<>());
        PathItemCompareHolder left = new PathItemCompareHolder(pathItemLeft);

        Operation operationRight = new Operation();
        Operation operationRight2 = new Operation();
        operationRight2.setDeprecated(false);
        PathItem pathItemRight = new PathItem();
        pathItemRight.get(operationRight2);
        pathItemRight.put(operationRight);
        pathItemRight.post(operationRight);
        pathItemRight.delete(operationRight);
        pathItemRight.options(operationRight);
        pathItemRight.head(operationRight);
        pathItemRight.patch(operationRight);
        pathItemRight.trace(operationRight);
        pathItemRight.$ref("/test/");
        pathItemRight.parameters(new ArrayList<>());
        PathItemCompareHolder right = new PathItemCompareHolder(pathItemRight);

        PathItemCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
        assertEquals(7, actual.getUnchangedOperations().size());
        assertEquals(0, actual.getDeletedOperations().size());
        assertEquals(0, actual.getCreatedOperations().size());
        assertEquals(1, actual.getChangedOperations().size());
    }

    @Test
    public void testChangeRef() {
        Operation operationLeft = new Operation();
        PathItem pathItemLeft = new PathItem();
        pathItemLeft.get(operationLeft);
        pathItemLeft.put(operationLeft);
        pathItemLeft.post(operationLeft);
        pathItemLeft.delete(operationLeft);
        pathItemLeft.options(operationLeft);
        pathItemLeft.head(operationLeft);
        pathItemLeft.patch(operationLeft);
        pathItemLeft.trace(operationLeft);
        pathItemLeft.$ref("/test/");
        pathItemLeft.parameters(new ArrayList<>());
        PathItemCompareHolder left = new PathItemCompareHolder(pathItemLeft);

        Operation operationRight = new Operation();
        PathItem pathItemRight = new PathItem();
        pathItemRight.get(operationRight);
        pathItemRight.put(operationRight);
        pathItemRight.post(operationRight);
        pathItemRight.delete(operationRight);
        pathItemRight.options(operationRight);
        pathItemRight.head(operationRight);
        pathItemRight.patch(operationRight);
        pathItemRight.trace(operationRight);
        pathItemRight.$ref("/test2/");
        pathItemRight.parameters(new ArrayList<>());
        PathItemCompareHolder right = new PathItemCompareHolder(pathItemRight);

        PathItemCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
        assertEquals(8, actual.getUnchangedOperations().size());
        assertEquals(0, actual.getDeletedOperations().size());
        assertEquals(0, actual.getCreatedOperations().size());
        assertEquals(0, actual.getChangedOperations().size());
    }

    @Test
    public void testChangeParameter() {
        Operation operationLeft = new Operation();
        PathItem pathItemLeft = new PathItem();
        pathItemLeft.get(operationLeft);
        pathItemLeft.put(operationLeft);
        pathItemLeft.post(operationLeft);
        pathItemLeft.delete(operationLeft);
        pathItemLeft.options(operationLeft);
        pathItemLeft.head(operationLeft);
        pathItemLeft.patch(operationLeft);
        pathItemLeft.trace(operationLeft);
        pathItemLeft.$ref("/test/");
        pathItemLeft.parameters(new ArrayList<>());
        PathItemCompareHolder left = new PathItemCompareHolder(pathItemLeft);

        Operation operationRight = new Operation();
        PathItem pathItemRight = new PathItem();
        pathItemRight.get(operationRight);
        pathItemRight.put(operationRight);
        pathItemRight.post(operationRight);
        pathItemRight.delete(operationRight);
        pathItemRight.options(operationRight);
        pathItemRight.head(operationRight);
        pathItemRight.patch(operationRight);
        pathItemRight.trace(operationRight);
        pathItemRight.$ref("/test2/");
        pathItemRight.parameters(new ArrayList<>(Arrays.asList(new Parameter())));
        PathItemCompareHolder right = new PathItemCompareHolder(pathItemRight);

        PathItemCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
        assertEquals(8, actual.getUnchangedOperations().size());
        assertEquals(0, actual.getDeletedOperations().size());
        assertEquals(0, actual.getCreatedOperations().size());
        assertEquals(0, actual.getChangedOperations().size());
    }
}