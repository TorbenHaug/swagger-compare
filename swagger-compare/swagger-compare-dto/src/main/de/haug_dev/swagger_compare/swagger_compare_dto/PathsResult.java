package de.haug_dev.swagger_compare.swagger_compare_dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PathsResult)) return false;
        PathsResult that = (PathsResult) o;
        return Objects.equals(leftNormalized, that.leftNormalized) &&
                Objects.equals(rightNormalized, that.rightNormalized) &&
                Objects.equals(getPathsResultItems(), that.getPathsResultItems());
    }

    @Override
    public int hashCode() {

        return Objects.hash(leftNormalized, rightNormalized, getPathsResultItems());
    }

    @Override
    public String toString() {
        return "PathsResult{" +
                "leftNormalized=" + leftNormalized +
                ", rightNormalized=" + rightNormalized +
                ", pathsResultItems=" + pathsResultItems +
                '}';
    }
}
