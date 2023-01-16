import { EventEmitter, Injectable } from "@angular/core";
import { Event } from "./event.model";

@Injectable()
export class EventService {
  eventSelected = new EventEmitter<Event>();

  private events: Event[] = [
    new Event(
      "Opener1",
      'Lorem ipsum'),
    new Event(
      "Opener2",
      'Lorem ipsum'),
    new Event(
      "Opener3",
      'Lorem ipsum'),


  ];

  getEvents() {
    return this.events.slice();
  }

  getEvent(index: number) {
    return this.events[index];
  }
}
