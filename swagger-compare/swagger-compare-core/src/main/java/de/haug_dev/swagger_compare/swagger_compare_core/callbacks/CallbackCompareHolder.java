package de.haug_dev.swagger_compare.swagger_compare_core.callbacks;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_core.paths.PathItemCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.callbacks.Callback;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;


public class CallbackCompareHolder extends AbstractCompareHolder<Callback> {

    private CompareHolderFactory compareHolderFactory;

    public CallbackCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Callback left, Callback right, CompareCriticalType created, CompareCriticalType deleted) {
        Callback leftValue = left == null ? new Callback() : left;
        Callback rightValue = right == null ? new Callback() : right;

        PathItemCompareHolder pathItemCompareHolder = compareHolderFactory.getPathItemCompareHolder();

        pathItemCompareHolder.setNormalizedParameterNames(new DualHashBidiMap<>(), new DualHashBidiMap<>());
        return this.referableCompare(leftValue, rightValue, pathItemCompareHolder, created, deleted);
    }
}
