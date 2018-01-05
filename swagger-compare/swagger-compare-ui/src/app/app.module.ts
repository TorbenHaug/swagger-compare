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

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoadUrlFormComponent,
    TraceBoxComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FlashMessagesModule
  ],
  providers: [TraceBoxDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
