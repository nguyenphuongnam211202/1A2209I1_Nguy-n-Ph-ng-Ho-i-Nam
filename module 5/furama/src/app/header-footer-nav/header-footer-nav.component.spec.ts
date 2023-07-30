import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderFooterNavComponent } from './header-footer-nav.component';

describe('HeaderFooterNavComponent', () => {
  let component: HeaderFooterNavComponent;
  let fixture: ComponentFixture<HeaderFooterNavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderFooterNavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderFooterNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
