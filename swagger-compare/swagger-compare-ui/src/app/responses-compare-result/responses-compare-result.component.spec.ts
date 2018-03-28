import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponsesCompareResultComponent } from './responses-compare-result.component';

describe('ResponsesCompareResultComponent', () => {
  let component: ResponsesCompareResultComponent;
  let fixture: ComponentFixture<ResponsesCompareResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResponsesCompareResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResponsesCompareResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
