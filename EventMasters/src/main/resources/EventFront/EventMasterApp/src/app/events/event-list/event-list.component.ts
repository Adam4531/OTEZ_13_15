import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EventsService } from '../EventsService';
import { EventDto } from '../event';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent {
  public events: EventDto[] = [];
  constructor(private eventService: EventsService,
    private router: Router,
    private route: ActivatedRoute) {
}

ngOnInit() {
  this.eventService.fetchEvents();
  this.events = this.eventService.getAll();
}

}
