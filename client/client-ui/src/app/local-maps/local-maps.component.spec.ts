import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocalMapsComponent } from './local-maps.component';

describe('LocalMapsComponent', () => {
  let component: LocalMapsComponent;
  let fixture: ComponentFixture<LocalMapsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocalMapsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocalMapsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
