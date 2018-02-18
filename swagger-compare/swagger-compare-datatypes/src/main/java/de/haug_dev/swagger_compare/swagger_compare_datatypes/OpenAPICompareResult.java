package de.haug_dev.swagger_compare.swagger_compare_datatypes;


import java.util.List;
import java.util.Objects;

public class OpenAPICompareResult {

    PathsResult pathsResult;

    public OpenAPICompareResult(NormalizeResultPack leftNormalized, NormalizeResultPack rightNormalized) {
        this.pathsResult = new PathsResult(leftNormalized, rightNormalized);
    }

    public void addPathResultItems(List<PathsResultItem> items) {
        pathsResult.add(items);
    }

    public PathsResult getPathsResult() {
        return pathsResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpenAPICompareResult)) return false;
        OpenAPICompareResult that = (OpenAPICompareResult) o;
        return Objects.equals(getPathsResult(), that.getPathsResult());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPathsResult());
    }

    @Override
    public String toString() {
        return "OpenAPICompareResult{" +
                "pathsResult=" + pathsResult +
                '}';
    }
}
