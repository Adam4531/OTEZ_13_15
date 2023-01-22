import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Ticket } from 'src/app/cart/ticket.model';
import { TicketService } from 'src/app/cart/ticket.service';

@Component({
  selector: 'app-my-tickets-list',
  templateUrl: './my-tickets-list.component.html',
  styleUrls: ['./my-tickets-list.component.css']
})
export class MyTicketsListComponent {
  tickets_user: Ticket[]

  constructor(private ticketService: TicketService,
    private router: Router,
    private route: ActivatedRoute) {
}

ngOnInit() {
this.tickets_user = this.ticketService.getTicketbyUser(2);
}
}

