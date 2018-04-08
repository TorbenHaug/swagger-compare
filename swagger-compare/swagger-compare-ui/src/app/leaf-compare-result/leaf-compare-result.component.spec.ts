import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeafCompareResultComponent } from './leaf-compare-result.component';

describe('LeafCompareResultComponent', () => {
  let component: LeafCompareResultComponent;
  let fixture: ComponentFixture<LeafCompareResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeafCompareResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeafCompareResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
