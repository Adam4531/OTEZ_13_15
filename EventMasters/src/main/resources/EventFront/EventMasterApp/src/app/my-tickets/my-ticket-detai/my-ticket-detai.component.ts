import { Component } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Ticket } from 'src/app/cart/ticket.model';
import { TicketService } from 'src/app/cart/ticket.service';

@Component({
  selector: 'app-my-ticket-detai',
  templateUrl: './my-ticket-detai.component.html',
  styleUrls: ['./my-ticket-detai.component.css']
})
export class MyTicketDetaiComponent {
  ticket: Ticket;
  id: number
  constructor(private ticketService: TicketService,private route: ActivatedRoute){}

   ngOnInit(): void {
      this.route.params
      .subscribe(
       (params: Params) => {
         this.id = +params['id'];
         this.ticket = this.ticketService.getTicket(this.id);
       }
     );
   }
}
