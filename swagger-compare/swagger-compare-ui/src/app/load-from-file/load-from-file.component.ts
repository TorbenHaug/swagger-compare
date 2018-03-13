import {Component, isDevMode, OnInit} from '@angular/core';
import {TraceBoxDataService} from "../trace-box/trace-box.data.service";
import {FlashMessagesService} from "ngx-flash-messages";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {CompareResultDataService} from "../compare-result/compare-result.data.service";

@Component({
  selector: 'load-from-file',
  templateUrl: './load-from-file.component.html',
  styleUrls: ['./load-from-file.component.scss']
})
export class LoadFromFileComponent implements OnInit {
  private fileLeft: File;
  private fileRight: File;

  constructor(private http: HttpClient,
              private flashMessagesService: FlashMessagesService,
              private traceBoxDataService: TraceBoxDataService,
              private compareResultDataService: CompareResultDataService) { }

  ngOnInit() {
  }

  handleFileLeft(files: FileList) {
    this.fileLeft = files[0];
  }

  handleFileRight(files: FileList) {
    this.fileRight = files[0];
  }

  frmValid() {
    return this.fileLeft != null && this.fileRight != null;
  }

  onSubmit(){
    let formdata: FormData = new FormData();
    formdata.append('fileLeft', this.fileLeft);
    formdata.append('fileRight', this.fileRight);
    this.http.post("/api/compareFiles",formdata).subscribe(
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
