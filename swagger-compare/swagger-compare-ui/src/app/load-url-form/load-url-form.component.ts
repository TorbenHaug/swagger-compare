import {Component, isDevMode, OnInit} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpResponse} from "@angular/common/http";
import {FlashMessagesService} from "ngx-flash-messages";
import {TraceBoxDataService} from "../trace-box/trace-box.data.service";
import {CompareResultDataService} from "../compare-result/compare-result.data.service";

@Component({
  selector: 'load-url-form',
  templateUrl: './load-url-form.component.html',
  styleUrls: ['./load-url-form.component.scss']
})
export class LoadUrlFormComponent implements OnInit {

  constructor(
    private http: HttpClient,
    private flashMessagesService: FlashMessagesService,
    private traceBoxDataService: TraceBoxDataService,
    private compareResultDataService: CompareResultDataService) {

  }

  ngOnInit() {
  }

  onSubmit(urlLeft: string, urlRight: string){
    console.log("urlLeft: \"" + urlLeft + "\", " + "urlRight: \"" + urlRight)
    var body = {
      urlLeft: urlLeft,
      urlRight: urlRight
    }
    this.http.post("/api/compare",body).subscribe(
      (data) => {
        this.compareResultDataService.showResult(data);
        if(isDevMode()){
          this.traceBoxDataService.showTrace(JSON.stringify(data));
        }else {
          this.traceBoxDataService.showTrace("");
        }
      },
      (error: HttpErrorResponse) => {
        this.compareResultDataService.showResult("");
        this.traceBoxDataService.showTrace(error);

      }
    );
  }
}
