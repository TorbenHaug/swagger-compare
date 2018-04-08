package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public class LeafCompareResult extends AbstractCompareResult implements ILeafCompareResult {

    private final Object valueLeft;
    private final Object valueRight;

    public LeafCompareResult(Object valueLeft, Object valueRight, CompareResultType compareResultType, CompareCriticalType compareCriticalType) {
        super(CompareType.LEAF);
        this.valueLeft = valueLeft;
        this.valueRight = valueRight;
        this.setCompareResultType(compareResultType);
        this.setHighestCompareCriticalType(compareCriticalType);
    }

    @Override
    public Object getValueLeft() {
        return valueLeft;
    }

    @Override
    public Object getValueRight() {
        return valueRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeafCompareResult)) return false;
        if (!super.equals(o)) return false;
        LeafCompareResult that = (LeafCompareResult) o;
        return Objects.equals(getValueLeft(), that.getValueLeft()) &&
                Objects.equals(getValueRight(), that.getValueRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValueLeft(), getValueRight());
    }

    @Override
    public String toString() {
        return "LeafCompareResult{" +
                "valueLeft=" + valueLeft +
                ", valueRight=" + valueRight +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                ", compareType=" + getCompareType() +
                '}';
    }
}
