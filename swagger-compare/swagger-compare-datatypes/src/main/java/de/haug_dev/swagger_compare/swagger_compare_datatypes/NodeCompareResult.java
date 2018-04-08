package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class NodeCompareResult extends AbstractCompareResult implements INodeCompareResult {

    private final Map<String, ICompareResult> values;

    public NodeCompareResult(){
        super(CompareType.NODE);
        this.values = new TreeMap<>();
    }

    @Override
    public void put(String key, ICompareResult value){
        this.values.put(key, value);
        boolean allResultTypesAreEqual = this.values.
                values().
                stream().
                allMatch((v) ->
                        v.getCompareResultType().equals(value.getCompareResultType())
                );
        if(allResultTypesAreEqual){
            setCompareResultType(value.getCompareResultType());
        }else {
            setCompareResultType(CompareResultType.CHANGED);
        }
        this.setHighestCompareCriticalType(value.getCompareCriticalType());
    }

    @Override
    public Map<String, ICompareResult> getValues() {
        return new TreeMap<>(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodeCompareResult)) return false;
        if (!super.equals(o)) return false;
        NodeCompareResult that = (NodeCompareResult) o;
        return Objects.equals(getValues(), that.getValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValues());
    }

    @Override
    public String toString() {
        return "NodeCompareResult{" +
                "values=" + values +
                ", compareCriticalType=" + getCompareCriticalType() +
                ", compareResultType=" + getCompareResultType() +
                ", compareType=" + getCompareType() +
                '}';
    }
}
