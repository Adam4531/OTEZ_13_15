import { Component, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { EventDto } from '../events/event';
import { EventsService } from '../events/EventsService';

@Component({
  selector: 'app-technical-fault',
  templateUrl: './technical-fault.component.html',
  styleUrls: ['./technical-fault.component.css']
})
export class TechnicalFaultComponent {

  constructor(private eventService: EventsService) {
}
events: EventDto
async ngOnInit() {
  // this.eventService.fetchEvents()
  this.eventService.getEventToTech.subscribe(data => this.events = data);
}


  submitted= false

    signForm = new FormGroup({
      type_fault: new FormControl<string>('', Validators.required),
      chooseEvent: new FormControl<string>('', Validators.required),
      desc_fault: new FormControl<string> ('',Validators.required),
    })



    onSubmit(){
      console.log(this.signForm.value);
      // const newPro = new Event(
      // this.signForm.value['type_event'],
      // this.signForm.value['ticket_count'],
      // this.signForm.value['additional'])

      this.signForm.reset()
    }
  }

