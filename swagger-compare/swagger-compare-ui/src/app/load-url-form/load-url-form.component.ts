import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {FlashMessagesService} from "ngx-flash-messages";
import {TraceBoxDataService} from "../trace-box/trace-box.data.service";

@Component({
  selector: 'load-url-form',
  templateUrl: './load-url-form.component.html',
  styleUrls: ['./load-url-form.component.scss']
})
export class LoadUrlFormComponent implements OnInit {

  constructor(private http: HttpClient, private flashMessagesService: FlashMessagesService,private data: TraceBoxDataService) { }

  ngOnInit() {
  }

  onSubmit(urlLeft: string, urlRight: string){
    console.log("urlLeft: \"" + urlLeft + "\", " + "urlRight: \"" + urlRight)
    var body = {
      urlLeft: urlLeft,
      urlRight: urlRight
    }
    this.http.post("/api/compare",body).subscribe(
      data => console.log('success', data),
      (error: HttpErrorResponse) => this.data.showTrace(error)
      );
  }
}
