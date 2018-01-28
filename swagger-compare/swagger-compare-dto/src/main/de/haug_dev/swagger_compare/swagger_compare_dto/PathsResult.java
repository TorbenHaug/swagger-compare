package de.haug_dev.swagger_compare.swagger_compare_dto;

import java.util.ArrayList;
import java.util.List;

public class PathsResult {
    private final NormalizeResultPack leftNormalized;
    private final NormalizeResultPack rightNormalized;
    List<PathsResultItem> pathsResultItems;

    public PathsResult(NormalizeResultPack leftNormalized, NormalizeResultPack rightNormalized) {
        this.leftNormalized = leftNormalized;
        this.rightNormalized = rightNormalized;
        this.pathsResultItems = new ArrayList<>();
    }

    public String getOriginalPath(String key) {
        String result = leftNormalized.mappingNormalizedToOriginal.get(key);
        if(result == null){
            rightNormalized.mappingNormalizedToOriginal.get(key);
        }
        return result;
    }

    public void add(PathsResultItem pathsResultItem) {
        pathsResultItems.add(pathsResultItem);
    }

    public void add(List<PathsResultItem> items) {
        pathsResultItems.addAll(items);
    }

    public List<PathsResultItem> getPathsResultItems() {
        return pathsResultItems;
    }
}
