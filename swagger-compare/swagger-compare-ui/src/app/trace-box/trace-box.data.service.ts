import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable()
export class TraceBoxDataService {

  private traceSource = new BehaviorSubject<string>("default message");
  currentTrace = this.traceSource.asObservable();

  constructor() {
    this.showTrace("Nothing");
  }

  showTrace(message: string) {
    this.traceSource.next(message)
  }
}
