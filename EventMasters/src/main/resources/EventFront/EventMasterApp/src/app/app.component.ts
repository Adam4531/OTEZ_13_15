import { Component } from '@angular/core';
import { EventsService } from './events/EventsService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EventMasterApp';
  constructor(private eventService: EventsService) {
}

  ngOnInit() {
    // this.getReservations()

  }
}
