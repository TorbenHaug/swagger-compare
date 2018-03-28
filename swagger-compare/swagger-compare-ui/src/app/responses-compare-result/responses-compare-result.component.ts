import {Component, Input, OnInit} from '@angular/core';
import {ResponsesCompareResult} from "../compare-result";

@Component({
  selector: 'responses-compare-result',
  templateUrl: './responses-compare-result.component.html',
  styleUrls: ['./responses-compare-result.component.scss']
})
export class ResponsesCompareResultComponent implements OnInit {

  @Input() responsesCompareResult: ResponsesCompareResult;

  constructor() { }

  ngOnInit() {
  }

}
