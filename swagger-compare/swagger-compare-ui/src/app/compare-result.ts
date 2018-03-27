
export interface CompareResult {
  pathsCompareResult: PathsCompareResult;
  componentsCompareResult: ComponentsCompareResult;
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
}

export interface PathsCompareResult {
  unchanged: { [index: string]: any };
  changed: { [index: string]: PathItemCompareResult };
  created: { [index: string]: any };
  deleted: { [index: string]: any };
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
}

export interface PathItemCompareResult {
  parametersCompareResult: ParametersCompareResult;
  refCompareResult: RefCompareResult;
  createdOperations: { [index: string]: any };
  deletedOperations: { [index: string]: any };
  unchangedOperations: { [index: string]: any };
  changedOperations: { [index: string]: OperationCompareResult };
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
}

export interface ComponentsCompareResult {
  componentsSchemaCompareResult: ComponentsSchemaCompareResult;
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
}

export interface ComponentsSchemaCompareResult {
  changed: { [index: string]: SchemaCompareResult };
  unchanged: { [index: string]: any };
  created: { [index: string]: any };
  deleted: { [index: string]: any };
  compareCriticalType: CompareCriticalType;
  compareResultType: CompareResultType;
}

export interface SchemaCompareResult extends Leaf<any>{}

export interface ParametersCompareResult {
  unchanged: any[];
  created: any[];
  deleted: any[];
  compareCriticalType: CompareCriticalType;
  compareResultType: CompareResultType;
}

export interface RefCompareResult {
  left: string;
  right: string;
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
}

export interface OperationCompareResult {
  compareCriticalType: CompareCriticalType;
  compareResultType: CompareResultType;
  parametersCompareResult: ParametersCompareResult;
  deprecatedCompareResult: DeprecatedCompareResult;
  requestBodyCompareResult: RequestBodyCompareResult;
  apiResponsesCompareResult: ApiResponsesCompareResult;
}

export interface DeprecatedCompareResult {
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
  left: boolean;
  right: boolean;
}

export interface RequestBodyCompareResult extends Leaf<any>{}

export interface ApiResponsesCompareResult {
  left: any;
  right: any;
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
}

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

export interface Leaf<T> {
  left: T;
  right: T;
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
}
