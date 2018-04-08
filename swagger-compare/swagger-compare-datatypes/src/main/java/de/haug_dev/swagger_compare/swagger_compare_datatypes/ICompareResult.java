package de.haug_dev.swagger_compare.swagger_compare_datatypes;

public interface ICompareResult {
    CompareCriticalType getCompareCriticalType();

    CompareResultType getCompareResultType();

    CompareType getCompareType();
}
