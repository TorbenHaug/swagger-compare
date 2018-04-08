package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component
public class SwaggerCompareCore {

    private CompareHolder openAPICompareHolder;

    @Autowired
    public SwaggerCompareCore(CompareHolder openAPICompareHolder) {
        this.openAPICompareHolder = openAPICompareHolder;
    }


    public ICompareResult compare(OpenAPI left, OpenAPI right){
        Assert.notNull(left, "Left API must be set");
        Assert.notNull(right, "Right API must be set");

        ICompareResult compareResult = openAPICompareHolder.compare(left, right);

        return compareResult;
    }

}
