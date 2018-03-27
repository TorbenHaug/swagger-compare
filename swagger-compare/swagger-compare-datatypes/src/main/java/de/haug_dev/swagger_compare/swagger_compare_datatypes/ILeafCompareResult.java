package de.haug_dev.swagger_compare.swagger_compare_datatypes;


public interface ILeafCompareResult<T> {
    public T getLeft();

    public T getRight();
}
