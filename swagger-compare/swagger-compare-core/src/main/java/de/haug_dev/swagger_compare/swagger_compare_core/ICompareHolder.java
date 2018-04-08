package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;

import java.util.*;

public interface ICompareHolder<T> {
    default ICompareResult compare(T left, T right){
        return this.compare(left, right, CompareCriticalType.NONE, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
    }

    default <T> ILeafCompareResult compare(T left, T right, CompareCriticalType unchanged, CompareCriticalType changed, CompareCriticalType created, CompareCriticalType deleted){
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
    default <T> void compare(T left, T right, String resultName, ICompareHolder<T> compareHolder, NodeCompareResult result){
        boolean checkLeft = left == null || (left instanceof Collection && ((Collection) left).isEmpty()) || (left instanceof Map && ((Map) left).isEmpty());
        boolean checkRight = right == null || (right instanceof Collection && ((Collection) right).isEmpty()) || (left instanceof Map && ((Map) right).isEmpty());
        if(!(checkLeft && checkRight )) {
            ICompareResult compareResult = compareHolder.compare(left, right);
            result.put(resultName, compareResult);
        }
    }

    default <T> NodeCompareResult compare(Map<String, T> left, Map<String, T> right, ICompareHolder<T> compareHolder){
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

    default <T> void compare(T left, T right, String resultName, CompareCriticalType unchanged, CompareCriticalType changed, CompareCriticalType created, CompareCriticalType deleted, NodeCompareResult result){
        if(!(left == null && right == null)){
            result.put(resultName, compare(left, right, unchanged, changed, created, deleted));
        }
    }
}
