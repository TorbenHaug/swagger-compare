import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NodeCompareResultComponent } from './node-compare-result.component';

describe('NodeCompareResultComponent', () => {
  let component: NodeCompareResultComponent;
  let fixture: ComponentFixture<NodeCompareResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NodeCompareResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NodeCompareResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
