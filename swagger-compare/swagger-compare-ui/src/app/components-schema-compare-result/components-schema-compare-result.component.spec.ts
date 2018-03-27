import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentsSchemaCompareResultComponent } from './components-schema-compare-result.component';

describe('ComponentsSchemaCompareResultComponent', () => {
  let component: ComponentsSchemaCompareResultComponent;
  let fixture: ComponentFixture<ComponentsSchemaCompareResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentsSchemaCompareResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentsSchemaCompareResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
