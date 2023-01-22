import { Component, ViewChild } from '@angular/core';
import { Form, FormArray, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';;

@Component({
  selector: 'app-organize',
  templateUrl: './organize.component.html',
  styleUrls: ['./organize.component.css']
})
export class OrganizeComponent {
  signForm = new FormGroup({
    type_event: new FormControl<string>('', Validators.required),
    ticket_count: new FormControl<string>('', Validators.required),
    additional: new FormArray([], [Validators.required]),
  })
  company =['Catering', 'Ochrona', 'Alkohol'];
  additional = this.signForm.get("additional") as FormArray;



  onSubmit(){
    console.log(this.signForm.value);
    // const newPro = new Event(
    // this.signForm.value['type_event'],
    // this.signForm.value['ticket_count'],
    // this.signForm.value['additional'])

    this.signForm.reset()
  }

  onCheckboxChange(event: any) {
    const additional = (this.signForm.controls['additional'] as FormArray);
    if (event.target.checked) {
      additional.push(new FormControl(event.target.value));
    } else {
      const index = additional.controls
      .findIndex(x => x.value === event.target.value);
      additional.removeAt(index);
    }
  }
}
