
export interface CompareResult {
  pathsCompareResult: PathsCompareResult;
  componentsCompareResult: ComponentsCompareResult;
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
}

export interface PathsCompareResult extends ReferableCompareResult<any, PathItemCompareResult>{}

export interface PathItemCompareResult extends BasicCompareResult{
  parametersCompareResult: ParametersCompareResult;
  refCompareResult: RefCompareResult;
  createdOperations: { [index: string]: any };
  deletedOperations: { [index: string]: any };
  unchangedOperations: { [index: string]: any };
  changedOperations: { [index: string]: OperationCompareResult };
}

export interface ResponsesCompareResult extends ReferableCompareResult<any, ResponseCompareResult>{}

export interface ComponentsCompareResult extends BasicCompareResult{
  componentsSchemaCompareResult: ComponentsSchemaCompareResult;
  responsesCompareResult: ResponsesCompareResult;
  parametersCompareResult: ParametersCompareResult;
}

export interface ComponentsSchemaCompareResult extends ReferableCompareResult<any, SchemaCompareResult>{}

export interface SchemaCompareResult extends Leaf<any>{}

export interface ParametersCompareResult extends ReferableCompareResult<any, ParameterCompareResult>{}

export interface RefCompareResult extends Leaf<string>{}

export interface OperationCompareResult extends BasicCompareResult{
  parametersCompareResult: ParametersCompareResult;
  deprecatedCompareResult: DeprecatedCompareResult;
  requestBodyCompareResult: RequestBodyCompareResult;
  responsesCompareResult: ResponsesCompareResult;
}

export interface DeprecatedCompareResult extends BasicCompareResult{
  left: boolean;
  right: boolean;
}

export interface RequestBodyCompareResult extends Leaf<any>{}

export interface ResponseCompareResult extends Leaf<any>{}

export interface ParameterCompareResult extends Leaf<any>{}

export enum CompareResultType {
  CREATED="CREATED",
  CHANGED="CHANGED",
  DELETED="DELETED",
  UNCHANGED="UNCHANGED"
}

export enum CompareCriticalType {
  CRITICAL="CRITICAL",
  WARNING="WARNING",
  INFO="INFO",
  NONE="NONE"
}

export interface Leaf<T> extends BasicCompareResult{
  left: T;
  right: T;
}

export interface BasicCompareResult {
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
}

export interface ReferableCompareResult<BasicType, CompareType> extends BasicCompareResult{
  unchanged: { [index: string]: BasicType };
  changed: { [index: string]: CompareType };
  created: { [index: string]: BasicType };
  deleted: { [index: string]: BasicType };
}
