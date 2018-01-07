package de.haug_dev.swagger_compare.swagger_compare_core;

import io.swagger.v3.oas.models.PathItem;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SwaggerCompareResult {

    private final Map<String,ChangedValue> unchanged = new HashMap<>();
    private final Map<String,ChangedValue> changed = new HashMap<>();
    private final Map<String,ChangedValue> created = new HashMap<>();
    private final Map<String,ChangedValue> deleted = new HashMap<>();


    public void addUnchangedItems(Map<String, ChangedValue> items) {
        unchanged.putAll(items);
    }

    public void addCreatedItems(Map<String, ChangedValue> items) {
        created.putAll(items);
    }

    public void addDeletedItems(Map<String, ChangedValue> items) {
        deleted.putAll(items);
    }

    public void addChangedItems(Map<String, ChangedValue> items) {
        changed.putAll(items);
    }

    public Map<String, ChangedValue> getUnchanged() {
        return Collections.unmodifiableMap(unchanged);
    }

    public Map<String, ChangedValue> getChanged() {
        return Collections.unmodifiableMap(changed);
    }

    public Map<String, ChangedValue> getCreated() {
        return Collections.unmodifiableMap(created);
    }

    public Map<String, ChangedValue> getDeleted() {
        return Collections.unmodifiableMap(deleted);
    }
}
