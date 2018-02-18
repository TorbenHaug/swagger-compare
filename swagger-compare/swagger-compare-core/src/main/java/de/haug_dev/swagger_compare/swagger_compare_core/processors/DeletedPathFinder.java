package de.haug_dev.swagger_compare.swagger_compare_core.processors;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NormalizeResultPack;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.PathsResultItem;
import io.swagger.v3.oas.models.PathItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find Deleted Paths
 */
@Component
public class DeletedPathFinder implements SwaggerCompareProcessor {

    /**
     * @see SwaggerCompareProcessor
     */
    @Override
    public List<PathsResultItem> process(Map<String, PathItem> left, Map<String, PathItem> right, NormalizeResultPack leftNormalized, NormalizeResultPack rightNormalized) {
        List<PathsResultItem> pathsResultItems = new ArrayList<>();
        HashMap<String, PathItem> _left = new HashMap<>(left);
        _left.keySet().removeAll(right.keySet());
        _left.forEach((key, value) -> {
            pathsResultItems.add(
                    new PathsResultItem(
                            leftNormalized.getOriginalPath(key),
                            rightNormalized.getOriginalPath(key),
                            CompareResultType.DELETED
                    )
            );
        });
        return pathsResultItems;
    }
}
