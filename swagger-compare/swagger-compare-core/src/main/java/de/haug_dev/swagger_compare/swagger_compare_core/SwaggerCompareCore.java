package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.dto.OpenAPICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_core.dto.PathsResultItem;
import de.haug_dev.swagger_compare.swagger_compare_core.processors.ChangedPathFinder;
import de.haug_dev.swagger_compare.swagger_compare_core.processors.CreatedPathFinder;
import de.haug_dev.swagger_compare.swagger_compare_core.processors.DeletedPathFinder;
import de.haug_dev.swagger_compare.swagger_compare_core.processors.UnchangedPathFinder;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SwaggerCompareCore {

    @Autowired
    UnchangedPathFinder unchangedPathFinder;

    @Autowired
    ChangedPathFinder changedPathFinder;

    @Autowired
    DeletedPathFinder deletedPathFinder;

    @Autowired
    CreatedPathFinder createdPathFinder;

    @Autowired
    Normalizer normalizer;

    public OpenAPICompareResult compare(OpenAPI left, OpenAPI right){
        Assert.notNull(left, "Left API must be set");
        Assert.notNull(right, "Right API must be set");

        NormalizeResultPack leftNormalized = normalizer.normalizeOpenAPI(left);
        NormalizeResultPack rightNormalized = normalizer.normalizeOpenAPI(right);

        OpenAPICompareResult result = new OpenAPICompareResult(leftNormalized, rightNormalized);

        Map<String,PathItem> _left = new HashMap<>(leftNormalized.normalizedAPI.getPaths());
        Map<String,PathItem> _right = new HashMap<>(rightNormalized.normalizedAPI.getPaths());

        List<PathsResultItem> unchangedItems = unchangedPathFinder.process(_left, _right, leftNormalized, rightNormalized);
        _left = clearTempPathHolder(_left, unchangedItems, leftNormalized);
        _right = clearTempPathHolder(_right, unchangedItems, rightNormalized);
        result.addPathResultItems(unchangedItems);

        List<PathsResultItem> createdItems = createdPathFinder.process(_left, _right, leftNormalized, rightNormalized);
        _left = clearTempPathHolder(_left, createdItems, leftNormalized);
        _right = clearTempPathHolder(_right, createdItems, rightNormalized);
        result.addPathResultItems(createdItems);

        List<PathsResultItem> deletedItems = deletedPathFinder.process(_left, _right, leftNormalized, rightNormalized);
        _left = clearTempPathHolder(_left, deletedItems, leftNormalized);
        _right = clearTempPathHolder(_right, deletedItems, rightNormalized);
        result.addPathResultItems(deletedItems);

        List<PathsResultItem> changedItems = changedPathFinder.process(_left, _right, leftNormalized, rightNormalized);
        _left = clearTempPathHolder(_left, changedItems, leftNormalized);
        _right = clearTempPathHolder(_right, changedItems, rightNormalized);
        result.addPathResultItems(changedItems);


        return result;
    }

    private Map<String, PathItem> clearTempPathHolder(Map<String, PathItem> pathHolder, List<PathsResultItem> unchangedItems, NormalizeResultPack normalizeResultPack) {
        Map<String, PathItem> result = new HashMap<>(pathHolder);
        unchangedItems.forEach((value) -> {
            result.remove(normalizeResultPack.getNormalizedPath(value));
        });
        return result;
    }





}
