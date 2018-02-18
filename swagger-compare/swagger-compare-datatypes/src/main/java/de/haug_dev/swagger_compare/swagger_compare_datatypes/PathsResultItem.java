package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PathsResultItem)) return false;
        PathsResultItem that = (PathsResultItem) o;
        return Objects.equals(getPathLeft(), that.getPathLeft()) &&
                Objects.equals(getPathRight(), that.getPathRight()) &&
                getCompareResultType() == that.getCompareResultType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPathLeft(), getPathRight(), getCompareResultType());
    }

    @Override
    public String toString() {
        return "PathsResultItem{" +
                "pathLeft='" + pathLeft + '\'' +
                ", pathRight='" + pathRight + '\'' +
                ", compareResultType=" + compareResultType +
                '}';
    }
}
