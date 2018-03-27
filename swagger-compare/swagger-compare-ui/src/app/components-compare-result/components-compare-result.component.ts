import {Component, Input, OnInit} from '@angular/core';
import {ComponentsCompareResult} from "../compare-result";

@Component({
  selector: 'components-compare-result',
  templateUrl: './components-compare-result.component.html',
  styleUrls: ['./components-compare-result.component.scss']
})
export class ComponentsCompareResultComponent implements OnInit {

  @Input() componentsCompareResult: ComponentsCompareResult;

  constructor() { }

  ngOnInit() {
  }

}
