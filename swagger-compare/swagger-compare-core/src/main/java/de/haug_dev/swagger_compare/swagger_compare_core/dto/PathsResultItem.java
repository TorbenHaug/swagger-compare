package de.haug_dev.swagger_compare.swagger_compare_core.dto;

public class PathsResultItem {
    String pathLeft;
    String pathRight;
    CompareResultType compareResultType;

    public PathsResultItem(String pathLeft, String pathRight, CompareResultType compareResultType) {
        this.pathLeft = pathLeft;
        this.pathRight = pathRight;
        this.compareResultType = compareResultType;
    }

    public String getPathLeft() {
        return pathLeft;
    }

    public String getPathRight() {
        return pathRight;
    }

    public CompareResultType getCompareResultType() {
        return compareResultType;
    }
}
