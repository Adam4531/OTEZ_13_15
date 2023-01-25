import { ChangeDetectorRef, Component, Input, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EventsService } from '../EventsService';
import { EventDto } from '../event';
import { HttpClient } from '@angular/common/http';
import { __await } from 'tslib';
import { async } from '@angular/core/testing';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent {
  // public events: EventDto[] = [];
  events$: Observable<EventDto[]>
  constructor(private eventService: EventsService,
    private router: Router,
    private route: ActivatedRoute) {
}



async ngOnInit() {
  this.eventService.fetchEvents()
  this.events$ = this.eventService.getAll();


  // that.events = that.eventService.getAll();



}

// public getReservations(): void {
//   this.eventService.getAll().subscribe((response: any) => {
//     this.events = response;
//   });
}



