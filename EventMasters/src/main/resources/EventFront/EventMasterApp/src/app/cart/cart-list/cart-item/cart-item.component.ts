import { Component, Input } from '@angular/core';
import { Ticket } from '../../ticket.model';

@Component({
  selector: 'app-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.css']
})
export class CartItemComponent {
  @Input() ticket: Ticket;
  @Input() index: number;
}
