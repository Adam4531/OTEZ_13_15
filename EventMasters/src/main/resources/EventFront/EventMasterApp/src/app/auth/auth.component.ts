import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent {
  constructor(private route: ActivatedRoute) { }

  public id: string;
  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
  }
  onSubmit(form: NgForm){
    console.log(form.value)
    form.reset()
  }
}
