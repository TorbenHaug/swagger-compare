package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import io.swagger.v3.oas.models.media.Schema;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SchemaCompareResultTest {

    @Test
    public void testEqualValues() {
        Schema<String> left = new Schema<>();
        Schema<String>  right = new Schema<>();
        SchemaCompareResult result = new SchemaCompareResult(left, right);
        Assert.assertEquals(left, result.getLeft());
        Assert.assertEquals(right, result.getRight());
        Assert.assertEquals(CompareResultType.UNCHANGED, result.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.NONE, result.getCompareCriticalType());
    }
    @Test
    public void testEqualNull() {
        Schema<String> left = null;
        Schema<String>  right = null;
        SchemaCompareResult result = new SchemaCompareResult(left, right);
        Assert.assertEquals(left, result.getLeft());
        Assert.assertEquals(right, result.getRight());
        Assert.assertEquals(CompareResultType.UNCHANGED, result.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.NONE, result.getCompareCriticalType());
    }

    @Test
    public void testChangedValues() {
        Schema<String> left = new Schema<>();
        Schema<String>  right = new Schema<>();
        right.setDeprecated(true);
        SchemaCompareResult result = new SchemaCompareResult(left, right);
        Assert.assertEquals(left, result.getLeft());
        Assert.assertEquals(right, result.getRight());
        Assert.assertEquals(CompareResultType.CHANGED, result.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.CRITICAL, result.getCompareCriticalType());
    }
    @Test
    public void testCreatedValues() {
        Schema<String> left = null;
        Schema<String>  right = new Schema<>();
        SchemaCompareResult result = new SchemaCompareResult(left, right);
        Assert.assertEquals(left, result.getLeft());
        Assert.assertEquals(right, result.getRight());
        Assert.assertEquals(CompareResultType.CREATED, result.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.CRITICAL, result.getCompareCriticalType());
    }

    @Test
    public void testDeletedValues() {
        Schema<String> left = new Schema<>();
        Schema<String>  right = null;
        SchemaCompareResult result = new SchemaCompareResult(left, right);
        Assert.assertEquals(left, result.getLeft());
        Assert.assertEquals(right, result.getRight());
        Assert.assertEquals(CompareResultType.DELETED, result.getCompareResultType());
        Assert.assertEquals(CompareCriticalType.CRITICAL, result.getCompareCriticalType());
    }
}