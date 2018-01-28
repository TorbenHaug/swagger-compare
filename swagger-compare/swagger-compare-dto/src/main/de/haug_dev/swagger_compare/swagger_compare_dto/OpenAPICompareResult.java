package de.haug_dev.swagger_compare.swagger_compare_dto;

import de.haug_dev.swagger_compare.swagger_compare_core.NormalizeResultPack;

import java.util.List;

public class OpenAPICompareResult {
    private final NormalizeResultPack leftNormalized;
    private final NormalizeResultPack rightNormalized;

    PathsResult pathsResult;

    public OpenAPICompareResult(NormalizeResultPack leftNormalized, NormalizeResultPack rightNormalized) {
        this.leftNormalized = leftNormalized;
        this.rightNormalized = rightNormalized;
        this.pathsResult = new PathsResult(leftNormalized, rightNormalized);
    }

    public void addPathResultItems(List<PathsResultItem> items) {
        pathsResult.add(items);
    }

    public PathsResult getPathsResult() {
        return pathsResult;
    }

}
