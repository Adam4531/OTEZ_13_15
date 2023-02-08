import { Component, OnInit } from '@angular/core';
import { AuthSService } from '../auth/authService';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit {

  constructor(private auth: AuthSService) { }
  
  isEmployee = true;
  isAuth = true;
  ngOnInit(): void {

  }
  onLogout(){
    this.isAuth=false;
  }

}
