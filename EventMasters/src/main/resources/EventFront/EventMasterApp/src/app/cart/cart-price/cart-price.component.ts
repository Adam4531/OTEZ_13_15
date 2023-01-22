import { Component, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Ticket } from '../ticket.model';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-cart-price',
  templateUrl: './cart-price.component.html',
  styleUrls: ['./cart-price.component.css']
})
export class CartPriceComponent {
  tickets: Ticket[]

  constructor(private ticketService: TicketService,
    private router: Router,
    private route: ActivatedRoute) {
}
  ngOnInit() {
    this.tickets = this.ticketService.ticketsbyUser;
    }
}
