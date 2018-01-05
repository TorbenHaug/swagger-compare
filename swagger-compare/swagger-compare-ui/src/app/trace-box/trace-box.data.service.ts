import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import {FlashMessagesService} from "ngx-flash-messages";
import {HttpErrorResponse} from "@angular/common/http";

class SwaggerCompareError {
  message: string;
  detailedMessage: string;
}

@Injectable()
export class TraceBoxDataService {

  private traceSource = new BehaviorSubject<string>("default message");
  currentTrace = this.traceSource.asObservable();

  constructor(private flashMessagesService: FlashMessagesService) {
    this.showTrace("");
  }

  showTraceHttpErrorResponse(error: HttpErrorResponse) {
    if (!(typeof error.error.detailedMessage === "undefined")) {
      this.flashMessagesService.show(error.error.message);
      this.traceSource.next(error.error.detailedMessage);
    } else {
      this.flashMessagesService.show(error.message);
      this.traceSource.next(error.error);
    }
  }

  showTrace(error: any) {
    if(error instanceof HttpErrorResponse){
      this.showTraceHttpErrorResponse(error);
    }else{
      this.traceSource.next(error);
    }
  }
}
