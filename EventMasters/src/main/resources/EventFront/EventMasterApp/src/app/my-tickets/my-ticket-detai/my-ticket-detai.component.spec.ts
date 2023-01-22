import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyTicketDetaiComponent } from './my-ticket-detai.component';

describe('MyTicketDetaiComponent', () => {
  let component: MyTicketDetaiComponent;
  let fixture: ComponentFixture<MyTicketDetaiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyTicketDetaiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyTicketDetaiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
