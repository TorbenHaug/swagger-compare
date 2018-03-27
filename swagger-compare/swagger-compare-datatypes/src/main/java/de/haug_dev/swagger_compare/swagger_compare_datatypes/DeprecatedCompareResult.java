package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class DeprecatedCompareResult extends AbstractLeafCompareResult<Boolean>{

    public DeprecatedCompareResult(Boolean left, Boolean right) {
        if(Objects.equals(left,right)){
            super.init(left, right, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        }else{
            if((left == null|| left.equals(false)) && right.equals(true)){
                super.init(left, right, CompareResultType.CHANGED, CompareCriticalType.WARNING);
            } else {
                super.init(left, right, CompareResultType.CHANGED, CompareCriticalType.INFO);

            }
        }
    }

}
