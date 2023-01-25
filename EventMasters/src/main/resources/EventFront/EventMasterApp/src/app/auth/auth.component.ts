import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { PrimeNGConfig } from 'primeng/api';
import { AuthSService } from './authService';
import { ClientRequestDto } from './user-request';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  constructor(private route: ActivatedRoute, private primeConfig: PrimeNGConfig, private authService: AuthSService) { }
  public id: string;
  model: any;

  private firstName: string;
  private lastName: string;
  private email: string;
  private password: string;


  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
  }
  onSubmit(form: NgForm){
    console.log(form.value)
    if(this.id){
      this.model = new ClientRequestDto(
        form.value.email,
        form.value.firstName,
        form.value.lastName, 
        form.value.password
      );

      this.model.email = form.value.email;
      this.authService.register(this.model)
      console.log(form.value)
    } else {
      if(form.value.isEmployee){
        this.authService.loginEmployee(form.value.email, form.value.password)
        console.log("Pracownik")
        console.log(form.value)
      } else {
        this.authService.loginClient(form.value.email, form.value.password)
        console.log(form.value)
      }
    }
    form.reset()
  }
}
