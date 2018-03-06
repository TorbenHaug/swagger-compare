package de.haug_dev.swagger_compare.swagger_compare_core;


import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResult;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component
public class SwaggerCompareCore {

    public SwaggerCompareCore() { }

    public CompareResult compare(OpenAPI left, OpenAPI right){
        Assert.notNull(left, "Left API must be set");
        Assert.notNull(right, "Right API must be set");
        CompareHolder leftCompareHolder = new CompareHolder(left);
        CompareHolder rightCompareHolder = new CompareHolder(right);
        CompareResult compareResult = leftCompareHolder.compare(rightCompareHolder);

        return compareResult;
    }

}
