import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit {

  constructor() { }
  isAuth = true;
  ngOnInit(): void {

  }
  onLogout(){
    this.isAuth=false;
  }

}
