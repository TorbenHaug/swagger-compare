package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;

import java.util.*;

public abstract class AbstractCompareHolder<T> implements ICompareHolder<T> {

    public ICompareResult compare(T left, T right){
        return this.leafCompare(left, right, CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
    }

    public <T> ILeafCompareResult leafCompare(T left, T right, CompareCriticalType unchanged, CompareCriticalType changed, CompareCriticalType created, CompareCriticalType deleted){
        CompareResultType compareResultType = CompareResultType.UNCHANGED;
        CompareCriticalType compareCriticalType = unchanged;
        if(!Objects.equals(left, right)){
            if(left == null){
                compareResultType = CompareResultType.CREATED;
                compareCriticalType = created;
            } else if(right == null){
                compareResultType = CompareResultType.DELETED;
                compareCriticalType = deleted;
            } else {
                compareResultType = CompareResultType.CHANGED;
                compareCriticalType = changed;
            }
        }
        return new LeafCompareResult(left, right, compareResultType, compareCriticalType);
    }
    public <T> void nodeCompare(T left, T right, String resultName, ICompareHolder<T> compareHolder, NodeCompareResult result){
        boolean checkLeft = left == null || (left instanceof Collection && ((Collection) left).isEmpty()) || (left instanceof Map && ((Map) left).isEmpty());
        boolean checkRight = right == null || (right instanceof Collection && ((Collection) right).isEmpty()) || (right instanceof Map && ((Map) right).isEmpty());
        if(!(checkLeft && checkRight )) {
            ICompareResult compareResult = compareHolder.compare(left, right);
            result.put(resultName, compareResult);
        }
    }

    public <T> NodeCompareResult referableCompare(Map<String, T> left, Map<String, T> right, ICompareHolder<T> compareHolder){
        NodeCompareResult result = new NodeCompareResult();
        Set<String> keys = new HashSet<>(left.keySet());
        keys.addAll(right.keySet());
        keys.forEach((k) -> {
            T leftValue = left.get(k);
            T rightValue = right.get(k);
            if(!(leftValue == null && rightValue == null)) {
                result.put(k, compareHolder.compare(leftValue, rightValue));
            }
        });
        return result;
    }

    public <T> void leafCompare(T left, T right, String resultName, CompareCriticalType unchanged, CompareCriticalType changed, CompareCriticalType created, CompareCriticalType deleted, NodeCompareResult result){
        if(!(left == null && right == null)){
            result.put(resultName, leafCompare(left, right, unchanged, changed, created, deleted));
        }
    }
}
