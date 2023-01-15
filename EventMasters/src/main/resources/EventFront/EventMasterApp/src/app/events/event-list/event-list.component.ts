import { Component } from '@angular/core';
import { Event } from '../event.model';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent {
  events: Event[] = [{name: "Opener1", description: 'Lorem ipsum'},{name: "Opener2", description: 'Lorem ipsum'},{name: "Opener3", description: 'Lorem ipsum'},{name: "Opener4", description: 'Lorem ipsum'},{name: "Opener5", description: 'Lorem ipsum'},{name: "Opener6", description: 'Lorem ipsum'}];

}
