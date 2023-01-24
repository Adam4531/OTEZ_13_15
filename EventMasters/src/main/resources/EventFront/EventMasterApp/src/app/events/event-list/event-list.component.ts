import { ChangeDetectorRef, Component, Input, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EventsService } from '../EventsService';
import { EventDto } from '../event';
import { HttpClient } from '@angular/common/http';
import { __await } from 'tslib';
import { async } from '@angular/core/testing';

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



async ngOnInit() {
  var that = this;
  // this.getReservations()
  this.eventService.fetchEvents()
  this
  setTimeout(function(){
    that.events = that.eventService.getAll();
  },200);


}

// public getReservations(): void {
//   this.eventService.getAll().subscribe((response: any) => {
//     this.events = response;
//   });
}



