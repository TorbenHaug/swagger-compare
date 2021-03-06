package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;

public interface ICompareHolder<T> {
    ICompareResult compare(T left, T right, CompareCriticalType created, CompareCriticalType deleted);

}
