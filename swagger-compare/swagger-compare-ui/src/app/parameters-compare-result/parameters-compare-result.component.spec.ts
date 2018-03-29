import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParametersCompareResultComponent } from './parameters-compare-result.component';

describe('ParametersCompareResultComponent', () => {
  let component: ParametersCompareResultComponent;
  let fixture: ComponentFixture<ParametersCompareResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParametersCompareResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParametersCompareResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
