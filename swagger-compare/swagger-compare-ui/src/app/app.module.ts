import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './home/home.component';
import {FormsModule} from "@angular/forms";
import { LoadUrlFormComponent } from './load-url-form/load-url-form.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { FlashMessagesModule } from "ngx-flash-messages";
import { TraceBoxComponent } from './trace-box/trace-box.component';
import {TraceBoxDataService} from "./trace-box/trace-box.data.service";
import { CompareResultComponent } from './compare-result/compare-result.component';
import {CompareResultDataService} from "./compare-result/compare-result.data.service";
import { KeysPipe } from './keys.pipe';
import { StringifyPipe } from './stringify.pipe';
import { LoadFromFileComponent } from './load-from-file/load-from-file.component';
import { CompareCriticalTypeToBootstrapTypePipe } from './compare-critical-type-to-bootstrap-type.pipe';
import { GetHighestCompareCriticalTypePipe } from './get-highest-compare-critical-type.pipe';
import {LeafCompareResultComponent} from "./leaf-compare-result/leaf-compare-result.component";
import {NodeCompareResultComponent} from "./node-compare-result/node-compare-result.component";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoadUrlFormComponent,
    TraceBoxComponent,
    CompareResultComponent,
    KeysPipe,
    StringifyPipe,
    LoadFromFileComponent,
    CompareCriticalTypeToBootstrapTypePipe,
    GetHighestCompareCriticalTypePipe,
    LeafCompareResultComponent,
    NodeCompareResultComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FlashMessagesModule
  ],
  providers: [TraceBoxDataService, CompareResultDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
