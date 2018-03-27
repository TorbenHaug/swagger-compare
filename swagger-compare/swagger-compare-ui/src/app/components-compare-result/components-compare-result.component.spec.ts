import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentsCompareResultComponent } from './components-compare-result.component';

describe('ComponentsCompareResultComponent', () => {
  let component: ComponentsCompareResultComponent;
  let fixture: ComponentFixture<ComponentsCompareResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentsCompareResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentsCompareResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
