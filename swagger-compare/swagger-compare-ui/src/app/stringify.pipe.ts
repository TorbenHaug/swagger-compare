import { Pipe, PipeTransform } from '@angular/core';
import * as YAML from 'yamljs';

@Pipe({
  name: 'stringify'
})
export class StringifyPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return YAML.stringify(value, 10);
  }

}
