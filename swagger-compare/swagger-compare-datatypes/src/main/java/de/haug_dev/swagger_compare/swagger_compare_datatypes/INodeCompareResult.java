package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Map;

public interface INodeCompareResult extends ICompareResult {
    Map<String, ICompareResult> getValues();
}
