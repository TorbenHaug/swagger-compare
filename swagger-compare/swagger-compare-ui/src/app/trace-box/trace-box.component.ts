import {Component, isDevMode, OnInit} from '@angular/core';
import {TraceBoxDataService} from "./trace-box.data.service";

@Component({
  selector: 'app-trace-box',
  templateUrl: './trace-box.component.html',
  styleUrls: ['./trace-box.component.scss']
})
export class TraceBoxComponent implements OnInit {

  trace: string;

  devMode: boolean = isDevMode();

  constructor(private data: TraceBoxDataService) { }

  ngOnInit() {
    this.data.currentTrace.subscribe(trace => this.trace = trace)
  }

}
