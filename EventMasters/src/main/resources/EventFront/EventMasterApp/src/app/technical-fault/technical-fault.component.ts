import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-technical-fault',
  templateUrl: './technical-fault.component.html',
  styleUrls: ['./technical-fault.component.css']
})
export class TechnicalFaultComponent {
  @ViewChild('f') signupForm: NgForm;
  chooseEvent ='impreza1';
  desc_fault ='';
  events =['impreza1', 'impreza2', 'impreza3'];
  foult ={
    chooseEvent:'',
    type_fault:'',
    desc_fault: ''
    };
    submitted= false



  onSubmit(){
    this.submitted=true
    console.log(this.signupForm.value);
    this.foult.chooseEvent = this.signupForm.value.userData.chooseEvent
    this.foult.type_fault = this.signupForm.value.userData.type_fault
    this.foult.desc_fault = this.signupForm.value.desc_fault

    this.signupForm.reset()
  }
}

