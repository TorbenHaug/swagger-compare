import { Component, OnInit } from '@angular/core';
import {CompareResultDataService} from "./compare-result.data.service";
import {CompareResultJson, CompareResultType} from "./CompareResultType";
import {OpenAPICompareResult, PathsResultItem} from '../../../target/typescript-generator/swagger-compare-ui';




@Component({
  selector: 'app-compare-result',
  templateUrl: './compare-result.component.html',
  styleUrls: ['./compare-result.component.scss']
})
export class CompareResultComponent implements OnInit {

  result: OpenAPICompareResult;
  isCompareResult: boolean;
  resultText: any;
  resultUnchanged: PathsResultItem[] = [];
  resultChanged: PathsResultItem[] = [];
  resultCreated: PathsResultItem[] = [];
  resultDeleted: PathsResultItem[] = [];


  constructor(private data: CompareResultDataService) { }

  ngOnInit() {
    this.data.currentResult.subscribe(result => {
      let tmpResult = (result as OpenAPICompareResult);
      if(!(typeof tmpResult.pathsResult === "undefined")){
        this.isCompareResult = true;
        this.result = tmpResult;
        this.resultUnchanged = [];
        this.resultChanged = [];
        this.resultCreated = [];
        this.resultDeleted = [];
        tmpResult.pathsResult.pathsResultItems.forEach((value) => {
          if(value.compareResultType === "UNCHANGED"){
            this.resultUnchanged.push(value);
          }else if(value.compareResultType === "CHANGED"){
            this.resultChanged.push(value);
          }else if(value.compareResultType === "CREATED"){
            this.resultCreated.push(value);
          }else if(value.compareResultType === "DELETED"){
            this.resultDeleted.push(value);
          }
        });

        this.resultUnchanged.sort((a, b) => {
          if(a.pathRight.length){
            return a.pathRight.localeCompare(b.pathRight);
          } else {
            return a.pathLeft.localeCompare(b.pathLeft);
          }
        });
        this.resultChanged.sort((a, b) => {
          if(a.pathRight.length){
            return a.pathRight.localeCompare(b.pathRight);
          } else {
            return a.pathLeft.localeCompare(b.pathLeft);
          }
        });
        this.resultCreated.sort((a, b) => {
          if(a.pathRight.length){
            return a.pathRight.localeCompare(b.pathRight);
          } else {
            return a.pathLeft.localeCompare(b.pathLeft);
          }
        });
        this.resultDeleted.sort((a, b) => {
          if(a.pathRight.length){
            return a.pathRight.localeCompare(b.pathRight);
          } else {
            return a.pathLeft.localeCompare(b.pathLeft);
          }
        });
      }else {
        this.isCompareResult = false;
        this.resultText = result;
      }


    });
  }

}
