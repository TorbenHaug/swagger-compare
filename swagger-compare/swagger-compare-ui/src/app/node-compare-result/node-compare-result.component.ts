import {Component, Input, OnInit} from '@angular/core';
import {CompareType, INodeCompareResult} from "../compare-result";

@Component({
  selector: 'node-compare-result',
  templateUrl: './node-compare-result.component.html',
  styleUrls: ['./node-compare-result.component.scss']
})
export class NodeCompareResultComponent implements OnInit {

  compareType = CompareType;
  @Input() nodeValue: INodeCompareResult;

  constructor() { }

  ngOnInit() {
  }

}
