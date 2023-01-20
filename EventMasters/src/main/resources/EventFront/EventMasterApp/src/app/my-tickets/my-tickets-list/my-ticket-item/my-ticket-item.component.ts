import { Component, Input } from '@angular/core';
import { Ticket } from 'src/app/cart/ticket.model';

@Component({
  selector: 'app-my-ticket-item',
  templateUrl: './my-ticket-item.component.html',
  styleUrls: ['./my-ticket-item.component.css']
})
export class MyTicketItemComponent {
  @Input() ticket: Ticket;
  @Input() index: number;
}
