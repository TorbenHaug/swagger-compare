package de.haug_dev.swagger_compare.swagger_compare_datatypes;

public interface ILeafCompareResult extends ICompareResult {
    Object getValueLeft();

    Object getValueRight();
}
