package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.CRITICAL;
import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.NONE;
import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType.*;

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

    public void booleanCompare(
            Boolean left,
            Boolean right,
            String name,
            CompareCriticalType unchanged,
            CompareCriticalType createdFalse,
            CompareCriticalType createdTrue,
            CompareCriticalType deletedFalse,
            CompareCriticalType deletedTrue,
            CompareCriticalType changedTrueToFalse,
            CompareCriticalType changedFalseToTrue,
            NodeCompareResult result){
        if(!(left == null && right == null)){
            if(Objects.equals(left, right)){
                result.put(name, new LeafCompareResult(left, right, UNCHANGED, unchanged));
            }else if(left == null && Objects.equals(right, false)){
                result.put(name, new LeafCompareResult(left, right, CREATED, createdFalse));
            }else if(left == null && Objects.equals(right, true)){
                result.put(name, new LeafCompareResult(left, right, CREATED, createdTrue));
            }else if(right == null && Objects.equals(left, false)){
                result.put(name, new LeafCompareResult(left, right, DELETED, deletedFalse));
            }else if(right == null && Objects.equals(left, true)){
                result.put(name, new LeafCompareResult(left, right, DELETED, deletedTrue));
            }else if(Objects.equals(left, true) && Objects.equals(right, false)){
                result.put(name, new LeafCompareResult(left, right, CHANGED, changedTrueToFalse));
            }else if(Objects.equals(left, false) && Objects.equals(right, true)){
                result.put(name, new LeafCompareResult(left, right, CHANGED, changedFalseToTrue));
            }else{
                //this should never be reached!
                LOG.error("Unhandled combination for " + name + "! Left: " + left +", Right: " + right);
                this.leafCompare(left, right, "AllowEmptyValue", NONE, CRITICAL, CRITICAL, CRITICAL, result);

            }
        }

    }
}
