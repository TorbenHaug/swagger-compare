import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TraceBoxComponent } from './trace-box.component';

describe('TraceBoxComponent', () => {
  let component: TraceBoxComponent;
  let fixture: ComponentFixture<TraceBoxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TraceBoxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TraceBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
