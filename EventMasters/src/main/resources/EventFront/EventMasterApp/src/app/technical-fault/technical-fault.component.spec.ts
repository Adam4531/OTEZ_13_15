import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TechnicalFaultComponent } from './technical-fault.component';

describe('TechnicalFaultComponent', () => {
  let component: TechnicalFaultComponent;
  let fixture: ComponentFixture<TechnicalFaultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TechnicalFaultComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TechnicalFaultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
