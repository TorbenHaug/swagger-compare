package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class RefCompareResult extends AbstractLeafCompareResult<String>{

    public RefCompareResult(String left, String right) {
        super(
                left,
                right,
                CompareCriticalType.NONE,
                CompareCriticalType.CRITICAL,
                CompareCriticalType.CRITICAL,
                CompareCriticalType.CRITICAL
        );
    }

}
