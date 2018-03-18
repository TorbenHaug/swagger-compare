

export interface CompareResult {
  pathsCompareResult: PathsCompareResult;
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

export interface RequestBodyCompareResult {
  left: any;
  right: any;
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
}

export interface ApiResponsesCompareResult {
  left: any;
  right: any;
  compareResultType: CompareResultType;
  compareCriticalType: CompareCriticalType;
}

export type CompareResultType = "CREATED" | "CHANGED" | "DELETED" | "UNCHANGED";

export type CompareCriticalType = "CRITICAL" | "WARNING" | "INFO" | "NONE";
