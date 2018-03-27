import {Component, Input, OnInit} from '@angular/core';
import {ComponentsSchemaCompareResult} from "../compare-result";

@Component({
  selector: 'components-schema-compare-result',
  templateUrl: './components-schema-compare-result.component.html',
  styleUrls: ['./components-schema-compare-result.component.scss']
})
export class ComponentsSchemaCompareResultComponent implements OnInit {

  @Input() componentsSchemaCompareResult: ComponentsSchemaCompareResult;

  constructor() { }

  ngOnInit() {
  }

}
