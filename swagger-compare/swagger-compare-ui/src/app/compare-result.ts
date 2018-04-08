export interface INodeCompareResult extends ICompareResult {
  values: { [index: string]: ICompareResult }
}

export interface ILeafCompareResult {
  valueLeft: any;
  valueRight: any;
}

export interface ICompareResult {
  compareCriticalType: CompareCriticalType;
  compareResultType: CompareResultType;
  getCompareType: CompareType;
}

export enum CompareType {
  NODE="NODE",
  LEAF="LEAF"
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



