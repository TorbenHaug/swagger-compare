package de.haug_dev.swagger_compare.swagger_compare_core.processors;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NormalizeResultPack;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.PathsResultItem;
import io.swagger.v3.oas.models.PathItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Find Unchanged Paths
 */
@Component
public class UnchangedPathFinder implements SwaggerCompareProcessor {

    /**
     * @see SwaggerCompareProcessor
     */
    @Override
    public List<PathsResultItem> process(Map<String, PathItem> left, Map<String, PathItem> right, NormalizeResultPack leftNormalized, NormalizeResultPack rightNormalized) {
        List<PathsResultItem> pathsResultItems = new ArrayList<>();
        left.forEach((key, value) -> {
            PathItem value2 = right.get(key);
            if(value2 != null && value2.equals(value)){
                pathsResultItems.add(
                        new PathsResultItem(
                                leftNormalized.getOriginalPath(key),
                                rightNormalized.getOriginalPath(key),
                                CompareResultType.UNCHANGED
                        )
                );
            }
        });
        return pathsResultItems;
    }
}
