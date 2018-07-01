package de.haug_dev.swagger_compare.swagger_compare_datatypes;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class NodeCompareResult extends AbstractCompareResult implements INodeCompareResult {

    private final Map<String, ICompareResult> values;
    private final CompareCriticalType created;
    private final CompareCriticalType deleted;

    public NodeCompareResult(CompareCriticalType created, CompareCriticalType deleted){
        super(CompareType.NODE);
        this.created = created;
        this.deleted = deleted;
        this.values = new TreeMap<>();
    }

    public void put(String key, ICompareResult value){
        this.values.put(key, value);
        boolean allResultTypesAreEqual = this.values.
                values().
                stream().
                allMatch((v) ->
                        v.getCompareResultType().equals(value.getCompareResultType())
                );
        if(allResultTypesAreEqual && (value.getCompareResultType().equals(CompareResultType.CREATED) || value.getCompareResultType().equals(CompareResultType.DELETED))){
            setCompareResultType(value.getCompareResultType());
            if(value.getCompareResultType().equals(CompareResultType.CREATED)){
                this.setCompareCriticalType(created);
            }else if(value.getCompareResultType().equals(CompareResultType.DELETED)){
                this.setCompareCriticalType(deleted);
            }
        }else if((allResultTypesAreEqual && value.getCompareResultType().equals(CompareResultType.CHANGED) || !allResultTypesAreEqual)) {
            setCompareResultType(CompareResultType.CHANGED);
            this.setCompareCriticalType(CompareCriticalType.NONE);
            this.values.values().forEach(v -> {
                this.setHighestCompareCriticalType(v.getCompareCriticalType());
            });
        }
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
