package de.haug_dev.swagger_compare.swagger_compare_core;

import io.swagger.v3.oas.models.PathItem;

import java.util.Objects;

public class ChangedValue {
    private final PathItem left;
    private final PathItem right;

    public ChangedValue(PathItem left, PathItem right) {
        this.left = left;
        this.right = right;
    }

    public PathItem getLeft() {
        return left;
    }

    public PathItem getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChangedValue)) return false;
        ChangedValue that = (ChangedValue) o;
        return Objects.equals(getLeft(), that.getLeft()) &&
                Objects.equals(getRight(), that.getRight());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getLeft(), getRight());
    }

    @Override
    public String toString() {
        return "ChangedValue{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
