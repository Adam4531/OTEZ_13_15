import { Component, Input } from '@angular/core';
import { Event } from '../../../shared/event.model';

@Component({
  selector: 'app-event-item',
  templateUrl: './event-item.component.html',
  styleUrls: ['./event-item.component.css']
})
export class EventItemComponent {
  @Input() event: Event;
  @Input() index: number;
}
