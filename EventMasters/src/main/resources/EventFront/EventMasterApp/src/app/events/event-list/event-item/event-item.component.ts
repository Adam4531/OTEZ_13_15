import { Component, Input } from '@angular/core';
import { EventDto } from '../../event';

@Component({
  selector: 'app-event-item',
  templateUrl: './event-item.component.html',
  styleUrls: ['./event-item.component.css']
})
export class EventItemComponent {
  @Input() event: EventDto;
  @Input() index: number;
}
