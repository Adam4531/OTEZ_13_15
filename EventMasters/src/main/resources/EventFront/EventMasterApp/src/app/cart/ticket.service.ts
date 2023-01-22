import { EventEmitter, Injectable } from '@angular/core';
import { Ticket } from './ticket.model';

@Injectable()
export class TicketService {
  eventSelected = new EventEmitter<Ticket>();

  private tickets: Ticket[] = [
    new Ticket(
      "Opener1",
      1,
      400),
    new Ticket(
      "Opener2",
      1,
      100),
    new Ticket(
      "Opener3",
      2,
      200),


  ];
  ticketsbyUser: Ticket[]=[]
  getTickets() {
    return this.tickets.slice();
  }

  getTicket(index: number) {
    return this.tickets[index];
  }
  getTicketbyUser(user: number) {
    this.tickets.forEach((even) =>{
      if(even.user == user){
        this.ticketsbyUser.push(even)
      }
    }
    )
    return this.ticketsbyUser;
  }
  constructor() { }
}
