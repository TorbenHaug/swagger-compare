package de.haug_dev.swagger_compare.swagger_compare_core;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SwaggerCompareCore {

    public SwaggerCompareResult compare(OpenAPI left, OpenAPI right){
        Assert.notNull(left, "Left API must be set");
        Assert.notNull(right, "Right API must be set");
        SwaggerCompareResult result = new SwaggerCompareResult();

        if(left.equals(right)) {
            result.addUnchangedItems(findUnchangedItems(left.getPaths(), right.getPaths()));
        }

        HashMap<String,PathItem> _left = new HashMap<>(left.getPaths());
        HashMap<String,PathItem> _right = new HashMap<>(right.getPaths());

        Map<String, ChangedValue> createdItems = findCreatedItems(_left, _right);
        _right.keySet().removeAll(createdItems.keySet());
        result.addCreatedItems(createdItems);

        Map<String, ChangedValue> deletedItems = findDeletedItems(_left, _right);
        _left.keySet().removeAll(deletedItems.keySet());
        result.addDeletedItems(deletedItems);

        Map<String, ChangedValue> changedItems = findChangedItems(_left, _right);
        _left.keySet().removeAll(changedItems.keySet());
        _right.keySet().removeAll(changedItems.keySet());
        result.addChangedItems(changedItems);

        Map<String, ChangedValue> unchangedItems = findUnchangedItems(_left, _right);
        result.addUnchangedItems(changedItems);


        return result;


    }

    private Map<String,ChangedValue> findUnchangedItems(Map<String, PathItem> left, Map<String, PathItem> right) {
        final Map<String,ChangedValue> result = new HashMap<>();

        left.forEach((key, value) -> {
            PathItem value2 = right.get(key);
            if(value2 != null && value2.equals(value)){
                result.put(key, new ChangedValue(value, value2));
            }
        });

        return result;
    }

    private Map<String,ChangedValue> findChangedItems(Map<String, PathItem> left, Map<String, PathItem> right) {
        final Map<String,ChangedValue> result = new HashMap<>();

        left.forEach((key, value) -> {
            PathItem value2 = right.get(key);
            if(value2 != null && ! value2.equals(value)){
                result.put(key, new ChangedValue(value, value2));
            }
        });

        return result;
    }

    private Map<String, ChangedValue> findCreatedItems(Map<String, PathItem> left, Map<String, PathItem> right) {
        HashMap<String, ChangedValue> result = new HashMap<>();
        HashMap<String, PathItem> _right = new HashMap<>(right);
        _right.keySet().removeAll(left.keySet());
        _right.forEach((key, value) -> {
            result.put(key, new ChangedValue(null, value));
        });
        return result;
    }

    private Map<String, ChangedValue> findDeletedItems(Map<String, PathItem> left, Map<String, PathItem> right) {
        HashMap<String, ChangedValue> result = new HashMap<>();
        HashMap<String, PathItem> _left = new HashMap<>(left);
        _left.keySet().removeAll(right.keySet());
        _left.forEach((key, value) -> {
            result.put(key, new ChangedValue(value, null));
        });
        return result;
    }
}
