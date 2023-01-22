import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent {
  signForm = new FormGroup({
    NIP: new FormControl<string>('', Validators.required),
    name: new FormControl<string>('', Validators.required),
    email: new FormControl<string>('', [Validators.required, Validators.email]),
    company_name: new FormControl<string>('', Validators.required),
    services: new FormControl<string>('', Validators.required),
    comments: new FormControl<string>('')
  })




  onSubmit(){
    console.log(this.signForm.value);
    this.signForm.reset()
  }
}
