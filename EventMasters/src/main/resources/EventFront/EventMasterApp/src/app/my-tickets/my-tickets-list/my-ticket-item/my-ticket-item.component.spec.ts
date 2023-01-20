import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyTicketItemComponent } from './my-ticket-item.component';

describe('MyTicketItemComponent', () => {
  let component: MyTicketItemComponent;
  let fixture: ComponentFixture<MyTicketItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyTicketItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyTicketItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
