package de.haug_dev.swagger_compare.swagger_compare_core.callbacks;

import de.haug_dev.swagger_compare.swagger_compare_core.ICompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.PathItemCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.callbacks.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CallbackCompareHolder implements ICompareHolder<Callback> {

    private PathItemCompareHolder pathItemCompareHolder;

    @Autowired
    public CallbackCompareHolder(PathItemCompareHolder pathItemCompareHolder){
        this.pathItemCompareHolder = pathItemCompareHolder;
    }

    @Override
    public ICompareResult compare(Callback left, Callback right) {
        Callback leftValue = left == null ? new Callback() : left;
        Callback rightValue = right == null ? new Callback() : right;
        return this.compare(leftValue, rightValue, pathItemCompareHolder);
    }
}
