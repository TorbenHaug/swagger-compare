import { Pipe, PipeTransform } from '@angular/core';
import {CompareCriticalType} from "./compare-result";

@Pipe({
  name: 'compareCriticalTypeToBootstrapType'
})
export class CompareCriticalTypeToBootstrapTypePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if(value == CompareCriticalType.CRITICAL){
      return "danger";
    }else if(value == CompareCriticalType.WARNING){
      return "warning";
    }else if(value == CompareCriticalType.INFO){
      return "info";
    }
    return "";
  }

}
