import { Component, OnInit } from '@angular/core';
import {CompareResultDataService} from "./compare-result.data.service";
import {CompareResultJson, CompareResultType} from "./CompareResultType";
import { SwaggerUI } from 'swagger-ui';



@Component({
  selector: 'app-compare-result',
  templateUrl: './compare-result.component.html',
  styleUrls: ['./compare-result.component.scss']
})
export class CompareResultComponent implements OnInit {

  result: CompareResultType;
  isCompareResult: boolean;
  resultText: any;
  resultUnchangedKeys: string[];
  resultChangedKeys: string[];
  resultCreatedKeys: string[];
  resultDeletedKeys: string[];


  constructor(private data: CompareResultDataService) { }

  ngOnInit() {
    this.data.currentResult.subscribe(result => {
      let tmpResult = (result as CompareResultJson);
      if(!(typeof tmpResult.unchanged === "undefined")){
        this.isCompareResult = true;
        this.result = new CompareResultType(tmpResult);
        this.resultUnchangedKeys = Array.from(this.result.unchanged.keys());
        this.resultChangedKeys = Array.from(this.result.changed.keys());
        this.resultCreatedKeys = Array.from(this.result.created.keys());
        this.resultDeletedKeys = Array.from(this.result.deleted.keys());
        this.resultUnchangedKeys.sort();
        this.resultChangedKeys.sort();
        this.resultCreatedKeys.sort();
        this.resultDeletedKeys.sort();
      }else {
        this.isCompareResult = false;
        this.resultText = result;
      }


    });
  }

}
