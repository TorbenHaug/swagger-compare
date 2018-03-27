package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Objects;

public abstract class AbstractLeafCompareResult<T> extends AbstractBasicCompareResult implements ILeafCompareResult<T> {

    private T left = null;
    private T right = null;

    protected AbstractLeafCompareResult(){}

    protected AbstractLeafCompareResult(
            T left,
            T right,
            CompareCriticalType unchanged,
            CompareCriticalType created,
            CompareCriticalType deleted,
            CompareCriticalType changed) {
        this.left = left;
        this.right = right;
        if(Objects.equals(left,right)){
            setCompareResultType(CompareResultType.UNCHANGED);
            setHighestCompareCriticalType(unchanged);
        }else{
            if(left == null){
                setCompareResultType(CompareResultType.CREATED);
                setHighestCompareCriticalType(created);
            } else if(right == null){
                setCompareResultType(CompareResultType.DELETED);
                setHighestCompareCriticalType(deleted);
            } else {
                setCompareResultType(CompareResultType.CHANGED);
                setHighestCompareCriticalType(changed);
            }
        }
    }


    @Override
    public T getLeft() {
        return this.left;
    }

    @Override
    public T getRight() {
        return this.right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractLeafCompareResult)) return false;
        if (!super.equals(o)) return false;
        AbstractLeafCompareResult<?> that = (AbstractLeafCompareResult<?>) o;
        return Objects.equals(getLeft(), that.getLeft()) &&
                Objects.equals(getRight(), that.getRight());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getLeft(), getRight());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "left=" + left +
                ", right=" + right +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                '}';
    }

    public void init(T left, T right, CompareResultType compareResultType, CompareCriticalType compareCriticalType) {
        this.left = left;
        this.right = right;
        setCompareResultType(compareResultType);
        setHighestCompareCriticalType(compareCriticalType);
    }
}
