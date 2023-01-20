import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { EventService } from 'src/app/shared/event.service';
import { Event } from '../../shared/event.model';

@Component({
  selector: 'app-event-detail',
  templateUrl: './event-detail.component.html',
  styleUrls: ['./event-detail.component.css']
})
export class EventDetailComponent implements OnInit{
 event: Event;
 id: number
 constructor(private eventService: EventService,private route: ActivatedRoute){}

  ngOnInit(): void {
     this.route.params
     .subscribe(
      (params: Params) => {
        this.id = +params['id'];
        this.event = this.eventService.getEvent(this.id);
      }
    );
  }
}
