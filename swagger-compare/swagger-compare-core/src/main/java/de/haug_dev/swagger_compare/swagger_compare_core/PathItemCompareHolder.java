package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;

import java.util.HashMap;
import java.util.Map;

public class PathItemCompareHolder {
    private final PathItem pathItem;
    private final String $ref;
    private final ParametersCompareHolder parametersCompareHolder;
    private final OperationCompareHolder get;
    private final OperationCompareHolder put;
    private final OperationCompareHolder post;
    private final OperationCompareHolder delete;
    private final OperationCompareHolder options;
    private final OperationCompareHolder head;
    private final OperationCompareHolder patch;
    private final OperationCompareHolder trace;

    public PathItemCompareHolder(PathItem pathItem) {
        this.pathItem = pathItem;
        this.$ref = pathItem.get$ref();
        this.parametersCompareHolder = new ParametersCompareHolder(pathItem.getParameters());
        this.get = generateOperationCompareHolder(pathItem.getGet());
        this.put = generateOperationCompareHolder(pathItem.getPut());
        this.post = generateOperationCompareHolder(pathItem.getPost());
        this.delete = generateOperationCompareHolder(pathItem.getDelete());
        this.options = generateOperationCompareHolder(pathItem.getOptions());
        this.head = generateOperationCompareHolder(pathItem.getHead());
        this.patch = generateOperationCompareHolder(pathItem.getPatch());
        this.trace = generateOperationCompareHolder(pathItem.getTrace());

    }

    private OperationCompareHolder generateOperationCompareHolder(Operation operation){
        if(operation == null){
            return null;
        }else{
            return new OperationCompareHolder(operation);
        }
    }

    public PathItemCompareResult compare(PathItemCompareHolder other) {
        RefCompareResult refCompareResult = new RefCompareResult(this.$ref, other.$ref);
        ParametersCompareResult parametersCompareResult = this.parametersCompareHolder.compare(other.parametersCompareHolder);
        Map<String,Operation> createdOperations = new HashMap<>();
        Map<String,Operation> deletedOperations = new HashMap<>();
        Map<String,Operation> unchangedOperations = new HashMap<>();
        Map<String,OperationCompareResult> changedOperations = new HashMap<>();
        if(this.get == null && other.get != null){
            createdOperations.put("GET", other.pathItem.getGet());
        } else if(this.get != null && other.get == null) {
            deletedOperations.put("GET", this.pathItem.getGet());
        } else if(this.get != null && other.get != null){
            OperationCompareResult operationCompareResult = this.get.compare(other.get);
            if(operationCompareResult.getCompareResultType() == CompareResultType.UNCHANGED){
                unchangedOperations.put("GET", this.pathItem.getGet());
            }else{
                changedOperations.put("GET", operationCompareResult);
            }
        }
        if(this.put == null && other.put != null){
            createdOperations.put("PUT", other.pathItem.getPut());
        } else if(this.put != null && other.put == null) {
            deletedOperations.put("PUT", this.pathItem.getPut());
        } else if(this.put != null && other.put != null){
            OperationCompareResult operationCompareResult = this.put.compare(other.put);
            if(operationCompareResult.getCompareResultType() == CompareResultType.UNCHANGED){
                unchangedOperations.put("PUT", this.pathItem.getPut());
            }else{
                changedOperations.put("PUT", operationCompareResult);
            }
        }
        if(this.post == null && other.post != null){
            createdOperations.put("POST", other.pathItem.getPost());
        } else if(this.post != null && other.post == null) {
            deletedOperations.put("POST", this.pathItem.getPost());
        } else if(this.post != null && other.post != null){
            OperationCompareResult operationCompareResult = this.post.compare(other.post);
            if(operationCompareResult.getCompareResultType() == CompareResultType.UNCHANGED){
                unchangedOperations.put("POST", this.pathItem.getPost());
            }else{
                changedOperations.put("POST", operationCompareResult);
            }
        }
        if(this.delete == null && other.delete != null){
            createdOperations.put("DELETE", other.pathItem.getDelete());
        } else if(this.delete != null && other.delete == null) {
            deletedOperations.put("DELETE", this.pathItem.getDelete());
        } else if(this.delete != null && other.delete != null){
            OperationCompareResult operationCompareResult = this.delete.compare(other.delete);
            if(operationCompareResult.getCompareResultType() == CompareResultType.UNCHANGED){
                unchangedOperations.put("DELETE", this.pathItem.getDelete());
            }else{
                changedOperations.put("DELETE", operationCompareResult);
            }
        }
        if(this.options == null && other.options != null){
            createdOperations.put("OPTIONS", other.pathItem.getOptions());
        } else if(this.options != null && other.options == null) {
            deletedOperations.put("OPTIONS", this.pathItem.getOptions());
        } else if(this.options != null && other.options != null){
            OperationCompareResult operationCompareResult = this.options.compare(other.options);
            if(operationCompareResult.getCompareResultType() == CompareResultType.UNCHANGED){
                unchangedOperations.put("OPTIONS", this.pathItem.getOptions());
            }else{
                changedOperations.put("OPTIONS", operationCompareResult);
            }
        }
        if(this.head == null && other.head != null){
            createdOperations.put("HEAD", other.pathItem.getHead());
        } else if(this.head != null && other.head == null) {
            deletedOperations.put("HEAD", this.pathItem.getHead());
        } else if(this.head != null && other.head != null){
            OperationCompareResult operationCompareResult = this.head.compare(other.head);
            if(operationCompareResult.getCompareResultType() == CompareResultType.UNCHANGED){
                unchangedOperations.put("HEAD", this.pathItem.getHead());
            }else{
                changedOperations.put("HEAD", operationCompareResult);
            }
        }
        if(this.patch == null && other.patch != null){
            createdOperations.put("PATCH", other.pathItem.getPatch());
        } else if(this.patch != null && other.patch == null) {
            deletedOperations.put("PATCH", this.pathItem.getPatch());
        } else if(this.patch != null && other.patch != null){
            OperationCompareResult operationCompareResult = this.patch.compare(other.patch);
            if(operationCompareResult.getCompareResultType() == CompareResultType.UNCHANGED){
                unchangedOperations.put("PATCH", this.pathItem.getPatch());
            }else{
                changedOperations.put("PATCH", operationCompareResult);
            }
        }
        if(this.trace == null && other.trace != null){
            createdOperations.put("TRACE", other.pathItem.getTrace());
        } else if(this.trace != null && other.trace == null) {
            deletedOperations.put("TRACE", this.pathItem.getTrace());
        } else if(this.trace != null && other.trace != null){
            OperationCompareResult operationCompareResult = this.trace.compare(other.trace);
            if(operationCompareResult.getCompareResultType() == CompareResultType.UNCHANGED){
                unchangedOperations.put("TRACE", this.pathItem.getTrace());
            }else{
                changedOperations.put("TRACE", operationCompareResult);
            }
        }
        PathItemCompareResult pathItemCompareResult = new PathItemCompareResult(
                parametersCompareResult,
                refCompareResult,
                createdOperations,
                deletedOperations,
                unchangedOperations,
                changedOperations);
        return pathItemCompareResult;
    }
}
