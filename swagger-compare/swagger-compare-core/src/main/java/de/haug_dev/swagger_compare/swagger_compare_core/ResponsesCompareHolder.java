package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.ApiResponseCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ResponsesCompareResult;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ResponsesCompareHolder {

    private Map<String, ApiResponse> responses;

    public ResponsesCompareHolder(Map<String, ApiResponse> responses) {
        this.responses = responses == null ? new HashMap<>(): responses;
    }

    public ResponsesCompareResult compare(ResponsesCompareHolder other){
        ResponsesCompareResult result = new ResponsesCompareResult();
        Set<String> deleted = diffKeys(this.responses.keySet(), other.responses.keySet());
        deleted.forEach((k) -> {
            result.putDeleted(k, this.responses.get(k));
        });

        Set<String> created = diffKeys(other.responses.keySet(), this.responses.keySet());
        created.forEach((k) -> {
            result.putCreated(k, other.responses.get(k));
        });

        Set<String> schemasToCompare = diffKeys(this.responses.keySet(), deleted);
        schemasToCompare.forEach((k) -> {
            ApiResponseCompareResult compareResult = new ApiResponseCompareResult(this.responses.get(k), other.responses.get(k));
            if(compareResult.getCompareResultType().equals(CompareResultType.UNCHANGED)){
                result.putUnchanged(k, this.responses.get(k));
            } else {
                result.putChanged(k, compareResult);
            }
        });

        return result;
    }

    protected Set<String> diffKeys(Set<String> left, Set<String> right){
        Set<String> keys = new HashSet<>(left);
        keys.removeAll(right);
        return keys;
    }

}
