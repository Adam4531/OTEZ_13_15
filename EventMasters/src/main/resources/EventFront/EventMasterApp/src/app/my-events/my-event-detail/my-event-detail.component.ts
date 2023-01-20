import { Component } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Event } from 'src/app/shared/event.model';
import { EventService } from 'src/app/shared/event.service';

@Component({
  selector: 'app-my-event-detail',
  templateUrl: './my-event-detail.component.html',
  styleUrls: ['./my-event-detail.component.css']
})
export class MyEventDetailComponent {
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
