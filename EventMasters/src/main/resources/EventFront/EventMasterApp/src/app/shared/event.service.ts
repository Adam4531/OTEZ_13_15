import { EventEmitter, Injectable } from "@angular/core";
import { Event } from "./event.model";

@Injectable()
export class EventService {
  eventSelected = new EventEmitter<Event>();

  private events: Event[] = [
    new Event(
      "Opener1",
      'Lorem ipsum',
      1),
    new Event(
      "Opener2",
      'Lorem ipsum',
      2),
    new Event(
      "Opener3",
      'Lorem ipsum',
      1),


  ];
  eventsbyUser: Event[]=[]
  getEvents() {
    return this.events.slice();
  }

  getEvent(index: number) {
    return this.events[index];
  }
  getEventbyUser(user: number) {
    this.events.forEach((even) =>{
      if(even.user == user){
        this.eventsbyUser.push(even)
      }
    }
    )
    return this.eventsbyUser;
  }
}
