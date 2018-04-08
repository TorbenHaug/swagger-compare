package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;

import java.util.*;

public interface ICompareHolder<T> {
    default ICompareResult compare(T left, T right){
        CompareResultType compareResultType = CompareResultType.UNCHANGED;
        CompareCriticalType compareCriticalType = CompareCriticalType.NONE;
        if(!Objects.equals(left, right)){
            if(left == null){
                compareResultType = CompareResultType.CREATED;
                compareCriticalType = CompareCriticalType.CRITICAL;
            } else if(right == null){
                compareResultType = CompareResultType.DELETED;
                compareCriticalType = CompareCriticalType.CRITICAL;
            } else {
                compareResultType = CompareResultType.CHANGED;
                compareCriticalType = CompareCriticalType.CRITICAL;
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
}
