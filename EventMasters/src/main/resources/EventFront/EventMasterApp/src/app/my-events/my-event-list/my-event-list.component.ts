import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Event } from 'src/app/events/event.model';
import { EventService } from 'src/app/events/event.service';

@Component({
  selector: 'app-my-event-list',
  templateUrl: './my-event-list.component.html',
  styleUrls: ['./my-event-list.component.css']
})
export class MyEventListComponent {
  events: Event[]
  constructor(private eventService: EventService,
    private router: Router,
    private route: ActivatedRoute) {
}

ngOnInit() {
this.events = this.eventService.getEventbyUser(1);
}
}
