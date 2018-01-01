import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'load-url-form',
  templateUrl: './load-url-form.component.html',
  styleUrls: ['./load-url-form.component.scss']
})
export class LoadUrlFormComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  onSubmit(urlLeft: string, urlRight: string){
    console.log("urlLeft: \"" + urlLeft + "\", " + "urlRight: \"" + urlRight)
    var body = {
      urlLeft: urlLeft,
      urlRight: urlRight
    }
    this.http.post("/api/compare",body).subscribe(res => console.log(res));
  }
}
