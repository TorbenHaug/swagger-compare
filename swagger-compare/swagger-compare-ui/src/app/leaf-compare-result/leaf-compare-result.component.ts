import {Component, Input, OnInit} from '@angular/core';
import {ILeafCompareResult} from "../compare-result";

@Component({
  selector: 'leaf-compare-result',
  templateUrl: './leaf-compare-result.component.html',
  styleUrls: ['./leaf-compare-result.component.scss']
})
export class LeafCompareResultComponent implements OnInit {
  @Input() leaf: ILeafCompareResult;

  constructor() { }

  ngOnInit() {
  }

}
