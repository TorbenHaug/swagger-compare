package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.dto.OpenAPICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_core.dto.PathsResultItem;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public OpenAPICompareResult compare(OpenAPI left, OpenAPI right){
        Assert.notNull(left, "Left API must be set");
        Assert.notNull(right, "Right API must be set");

        NormalizeResultPack leftNormalized = normalizeOpenAPI(left);
        NormalizeResultPack rightNormalized = normalizeOpenAPI(right);

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

//
//        Map<String, ChangedValue> changedItems = changedPathFinder.process(_left, _right);
//        _left.keySet().removeAll(changedItems.keySet());
//        _right.keySet().removeAll(changedItems.keySet());
//        result.addChangedItems(changedItems);
//
//
//        Assert.isTrue(_left.isEmpty(),"Not all items of the left side are processed!");
//        Assert.isTrue(_right.isEmpty(),"Not all items of the right side are processed!");

        return result;
    }

    private Map<String, PathItem> clearTempPathHolder(Map<String, PathItem> pathHolder, List<PathsResultItem> unchangedItems, NormalizeResultPack normalizeResultPack) {
        Map<String, PathItem> result = new HashMap<>(pathHolder);
        unchangedItems.forEach((value) -> {
            result.remove(normalizeResultPack.getNormalizedPath(value));
        });
        return result;
    }

    NormalizeResultPack normalizeOpenAPI(OpenAPI api){
        Paths normalizedPathes = new Paths();
        DualHashBidiMap<String,String> mappingNormalizedToOriginal = new DualHashBidiMap<>();
        api.getPaths().forEach((key, value) -> {
            String normalizePath = normalizePath(key);
            normalizedPathes.put(normalizePath, value);
            mappingNormalizedToOriginal.put(normalizePath, key);
        });

        Assert.isTrue(api.getPaths().size() == normalizedPathes.size(), "OpenAPI-Document is not valid");
        OpenAPI resultAPI = new OpenAPI();
        resultAPI.setPaths(normalizedPathes);
        return new NormalizeResultPack(resultAPI, api, mappingNormalizedToOriginal);
    }

    String normalizePath(String path){
        String repString = "{var}";
        String rx = "(\\$\\{[^}]+\\})";

        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(rx);
        Matcher m = p.matcher(path);

        while (m.find()){
            if (repString != null) {
                m.appendReplacement(sb, repString);
            }
        }
        m.appendTail(sb);

        return sb.toString();
    }



}
