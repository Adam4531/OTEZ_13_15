import { Component, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Ticket } from '../ticket.model';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})
export class CartListComponent {
  tickets: Ticket[]
  constructor(private ticketService: TicketService,
    private router: Router,
    private route: ActivatedRoute) {
}

ngOnInit() {
this.tickets = this.ticketService.getTicketbyUser(1);
}
}
