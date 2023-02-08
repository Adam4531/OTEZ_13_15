import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import {  EventsService } from '../EventsService';
import { EventDto } from '../event';

@Component({
  selector: 'app-event-detail',
  templateUrl: './event-detail.component.html',
  styleUrls: ['./event-detail.component.css']
})
export class EventDetailComponent implements OnInit{
 event: EventDto;
 id: number
 constructor(private eventService:  EventsService,private route: ActivatedRoute){}

  ngOnInit(): void {
     this.route.params
     .subscribe(
      (params: Params) => {
        this.id = +params['id'];
        this.event = this.eventService.getEvent(this.id);
      }
    );
  }

  add(){
    console.log(this.event.id)
  }
}
