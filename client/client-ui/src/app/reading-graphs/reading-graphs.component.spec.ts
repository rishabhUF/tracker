import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadingGraphsComponent } from './reading-graphs.component';

describe('ReadingGraphsComponent', () => {
  let component: ReadingGraphsComponent;
  let fixture: ComponentFixture<ReadingGraphsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReadingGraphsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReadingGraphsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
