import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EventService } from 'src/app/shared/event.service';
import { Event } from '../../shared/event.model';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent {
  events: Event[]
  constructor(private eventService: EventService,
    private router: Router,
    private route: ActivatedRoute) {
}

ngOnInit() {
this.events = this.eventService.getEvents();
}

}
