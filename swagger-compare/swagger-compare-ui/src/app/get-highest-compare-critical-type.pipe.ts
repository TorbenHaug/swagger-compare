import { Pipe, PipeTransform } from '@angular/core';
import {CompareCriticalType} from "./compare-result";

@Pipe({
  name: 'getHighestCompareCriticalType'
})
export class GetHighestCompareCriticalTypePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    let result = CompareCriticalType.NONE;
    for(let key in value){
      if(value[key].compareCriticalType){
        if(this.cctToNum(result) < this.cctToNum(value[key].compareCriticalType)){
          result = value[key].compareCriticalType;
        }
      }
    }
    return result;
  }

  cctToNum(value: CompareCriticalType): number{
    if(value == CompareCriticalType.NONE){
      return 0;
    } else if(value == CompareCriticalType.INFO){
      return 1;
    } else if(value == CompareCriticalType.WARNING){
      return 2;
    }
    return 99
  }

}
