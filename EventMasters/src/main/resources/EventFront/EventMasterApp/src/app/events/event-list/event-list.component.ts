import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationsService } from '../EventsService';
import { Event } from '../../shared/event.model';
import { EventDto } from '../event';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent {
  events: EventDto[]
  constructor(private eventService: ReservationsService,
    private router: Router,
    private route: ActivatedRoute) {
}

ngOnInit() {
this.eventService.fetchEvents();
this.events = this.eventService.getAll();
}

}
