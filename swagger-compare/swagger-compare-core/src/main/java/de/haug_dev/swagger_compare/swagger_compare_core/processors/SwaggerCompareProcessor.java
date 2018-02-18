package de.haug_dev.swagger_compare.swagger_compare_core.processors;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.NormalizeResultPack;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.PathsResultItem;
import io.swagger.v3.oas.models.PathItem;

import java.util.List;
import java.util.Map;

public interface SwaggerCompareProcessor {

    /**
     * Processes a OpenAPIfile
     * @param left - The Leftside (Older API)
     * @param right - The Rightside (Newer API)
     * @param leftNormalized - Normalization Result Left
     * @param rightNormalized - Normalization Result Right
     * @return A List of results
     */
    List<PathsResultItem> process(Map<String, PathItem> left, Map<String, PathItem> right, NormalizeResultPack leftNormalized, NormalizeResultPack rightNormalized);
}
