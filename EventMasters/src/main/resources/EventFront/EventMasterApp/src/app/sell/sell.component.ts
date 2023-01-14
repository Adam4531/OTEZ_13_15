import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent {
  signForm = new FormGroup({
    NIP: new FormControl<string>('', Validators.required),
    name: new FormControl<string>('', Validators.required),
    email: new FormControl<string>('', [Validators.required, Validators.email]),
    ticket_count: new FormControl<string>('', Validators.required),
    event_name: new FormControl<string>('', Validators.required)
  })




  onSubmit(){
    console.log(this.signForm.value);
    this.signForm.reset()
  }
}
