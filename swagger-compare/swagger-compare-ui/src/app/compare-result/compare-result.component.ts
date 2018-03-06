import { Component, OnInit } from '@angular/core';
import {CompareResultDataService} from "./compare-result.data.service";
import {CompareResult, PathItemCompareResult} from "../compare-result";




@Component({
  selector: 'app-compare-result',
  templateUrl: './compare-result.component.html',
  styleUrls: ['./compare-result.component.scss']
})
export class CompareResultComponent implements OnInit {

  result: CompareResult;
  isCompareResult: boolean;
  resultText: any;
  resultUnchanged: { [index: string]: any } = {};
  resultChanged: { [index: string]: PathItemCompareResult } = {};
  resultCreated: { [index: string]: any } = {};
  resultDeleted: { [index: string]: any } = {};


  constructor(private data: CompareResultDataService) { }

  ngOnInit() {
    this.data.currentResult.subscribe(result => {
      let tmpResult = (result as CompareResult);
      if(!(typeof tmpResult.pathsCompareResult === "undefined")){
        this.isCompareResult = true;
        this.result = tmpResult;
        this.resultUnchanged = tmpResult.pathsCompareResult.unchanged;
        this.resultChanged = tmpResult.pathsCompareResult.changed;
        this.resultCreated = tmpResult.pathsCompareResult.created;
        this.resultDeleted = tmpResult.pathsCompareResult.deleted;
      }else {
        this.isCompareResult = false;
        this.resultText = result;
      }


    });
  }

}
