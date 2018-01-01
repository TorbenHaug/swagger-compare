import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadUrlFormComponent } from './load-url-form.component';

describe('LoadUrlFormComponent', () => {
  let component: LoadUrlFormComponent;
  let fixture: ComponentFixture<LoadUrlFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoadUrlFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoadUrlFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
