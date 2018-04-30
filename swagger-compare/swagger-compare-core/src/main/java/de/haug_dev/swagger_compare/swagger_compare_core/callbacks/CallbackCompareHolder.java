package de.haug_dev.swagger_compare.swagger_compare_core.callbacks;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.paths.PathItemCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.callbacks.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CallbackCompareHolder extends AbstractCompareHolder<Callback> {

    private PathItemCompareHolder pathItemCompareHolder;

    @Autowired
    public CallbackCompareHolder(PathItemCompareHolder pathItemCompareHolder){
        this.pathItemCompareHolder = pathItemCompareHolder;
    }

    @Override
    public ICompareResult compare(Callback left, Callback right) {
        Callback leftValue = left == null ? new Callback() : left;
        Callback rightValue = right == null ? new Callback() : right;
        return this.referableCompare(leftValue, rightValue, pathItemCompareHolder);
    }
}
