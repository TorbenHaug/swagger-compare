import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import {FlashMessagesService} from "ngx-flash-messages";
import {HttpErrorResponse} from "@angular/common/http";

class SwaggerCompareError {
  message: string;
  detailedMessage: string;
}

@Injectable()
export class CompareResultDataService {

  private comareResult = new BehaviorSubject<any>("default message");
  currentResult = this.comareResult.asObservable();

  constructor() {
    this.showResult("No Result");
  }

  showResult(result: any) {
      this.comareResult.next(result);
  }

}
