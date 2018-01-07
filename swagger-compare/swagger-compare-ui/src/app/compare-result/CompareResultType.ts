import {PathItemObject} from "openapi3-ts";

export interface CompareResultJson{
  unchanged:{[key: string]:ChangedValue};
  changed:{[key: string]:ChangedValue};
  created:{[key: string]:ChangedValue};
  deleted:{[key: string]:ChangedValue};
}

export class CompareResultType{
  unchanged:Map<string, ChangedValue>;
  changed:Map<string, ChangedValue>;
  created:Map<string, ChangedValue>;
  deleted:Map<string, ChangedValue>;

  constructor(json: CompareResultJson){
    this.unchanged = new Map<string, ChangedValue>()
    Object.keys(json.unchanged).forEach(key => {
      this.unchanged.set(key, json.unchanged[key]);
    });

    this.changed = new Map<string, ChangedValue>()
    Object.keys(json.changed).forEach(key => {
      this.changed.set(key, json.changed[key]);
    });

    this.created = new Map<string, ChangedValue>()
    Object.keys(json.created).forEach(key => {
      this.created.set(key, json.created[key]);
    });

    this.deleted = new Map<string, ChangedValue>()
    Object.keys(json.deleted).forEach(key => {
      this.deleted.set(key, json.deleted[key]);
    });
  }
}

export interface ChangedValue{
  left:PathItemObject;
  right:PathItemObject;
}
