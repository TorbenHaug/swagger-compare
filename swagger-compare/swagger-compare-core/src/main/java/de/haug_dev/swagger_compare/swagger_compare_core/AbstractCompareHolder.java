package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public abstract class AbstractCompareHolder<T> implements ICompareHolder<T> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractCompareHolder.class);

    public ICompareResult compare(T left, T right, CompareCriticalType created, CompareCriticalType deleted) {
        LOG.debug(this.getClass().getCanonicalName() + " uses the default compare!");
        return this.leafCompare(left, right, CompareCriticalType.NONE, created, deleted, CompareCriticalType.CRITICAL);
    }

    public <T> ILeafCompareResult leafCompare(T left, T right, CompareCriticalType unchanged, CompareCriticalType created, CompareCriticalType deleted, CompareCriticalType changed) {
        CompareResultType compareResultType = CompareResultType.UNCHANGED;
        CompareCriticalType compareCriticalType = unchanged;
        if (!Objects.equals(left, right)) {
            if (left == null) {
                compareResultType = CompareResultType.CREATED;
                compareCriticalType = created;
            } else if (right == null) {
                compareResultType = CompareResultType.DELETED;
                compareCriticalType = deleted;
            } else {
                compareResultType = CompareResultType.CHANGED;
                compareCriticalType = changed;
            }
        }
        return new LeafCompareResult(left, right, compareResultType, compareCriticalType);
    }

    public <T> void nodeCompare(T left, T right, String resultName, ICompareHolder<T> compareHolder, NodeCompareResult result, CompareCriticalType created, CompareCriticalType deleted) {
        boolean checkLeft = left == null || (left instanceof Collection && ((Collection) left).isEmpty()) || (left instanceof Map && ((Map) left).isEmpty());
        boolean checkRight = right == null || (right instanceof Collection && ((Collection) right).isEmpty()) || (right instanceof Map && ((Map) right).isEmpty());
        if (!(checkLeft && checkRight)) {
            ICompareResult compareResult = compareHolder.compare(left, right, created, deleted);
            result.put(resultName, compareResult);
        }
    }

    public <T> NodeCompareResult referableCompare(Map<String, T> left, Map<String, T> right, ICompareHolder<T> compareHolder, CompareCriticalType created, CompareCriticalType deleted) {
        NodeCompareResult result = new NodeCompareResult(created, deleted);
        Set<String> keys = new HashSet<>(left.keySet());
        keys.addAll(right.keySet());
        keys.forEach((k) -> {
            T leftValue = left.get(k);
            T rightValue = right.get(k);
            if (!(leftValue == null && rightValue == null)) {
                result.put(k, compareHolder.compare(leftValue, rightValue, created, deleted));
            }
        });
        return result;
    }

    public <T> void leafCompare(T left, T right, String resultName, CompareCriticalType unchanged, CompareCriticalType created, CompareCriticalType deleted, CompareCriticalType changed, NodeCompareResult result) {
        if (!(left == null && right == null)) {
            result.put(resultName, leafCompare(left, right, unchanged, created, deleted, changed));
        }
    }
}
