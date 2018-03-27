import {Component, Input, OnInit} from '@angular/core';
import {Leaf} from "../compare-result";

@Component({
  selector: 'compare-result-leaf',
  templateUrl: './compare-result-leaf.component.html',
  styleUrls: ['./compare-result-leaf.component.scss']
})
export class CompareResultLeafComponent implements OnInit {

  @Input() leaf: Leaf<any>;
  constructor() { }

  ngOnInit() {
  }

}
