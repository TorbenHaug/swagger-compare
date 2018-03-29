import {Component, Input, OnInit} from '@angular/core';
import {ParametersCompareResult} from "../compare-result";

@Component({
  selector: 'parameters-compare-result',
  templateUrl: './parameters-compare-result.component.html',
  styleUrls: ['./parameters-compare-result.component.scss']
})
export class ParametersCompareResultComponent implements OnInit {

  @Input() parametersCompareResult: ParametersCompareResult;

  constructor() { }

  ngOnInit() {
  }

}
