import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompareResultLeafComponent } from './compare-result-leaf.component';

describe('CompareResultLeafComponent', () => {
  let component: CompareResultLeafComponent;
  let fixture: ComponentFixture<CompareResultLeafComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompareResultLeafComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompareResultLeafComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
