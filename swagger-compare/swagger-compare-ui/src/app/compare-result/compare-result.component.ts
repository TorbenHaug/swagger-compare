import { Component, OnInit } from '@angular/core';
import {CompareResultDataService} from "./compare-result.data.service";
import {INodeCompareResult} from "../compare-result";




@Component({
  selector: 'app-compare-result',
  templateUrl: './compare-result.component.html',
  styleUrls: ['./compare-result.component.scss']
})
export class CompareResultComponent implements OnInit {

  result: INodeCompareResult;
  isCompareResult: boolean;
  resultText: any;


  constructor(private data: CompareResultDataService) { }

  ngOnInit() {
    this.data.currentResult.subscribe(result => {
      let tmpResult = (result as INodeCompareResult);
      if(!(typeof tmpResult.values === "undefined")){
        this.isCompareResult = true;
        this.result = tmpResult;
      }else {
        this.isCompareResult = false;
        this.resultText = result;
      }
    });
  }

}
