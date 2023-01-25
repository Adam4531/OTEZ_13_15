import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { EmployeeRequestDto } from './employee-request-dto';
import { ClientRequestDto } from './user-request';
import { ErrorsListDto } from '../erorrsList/errors-list-dto';
import { Router } from '@angular/router';
import {MessageService} from 'primeng/api'

@Injectable({
  providedIn: 'root'
})
export class AuthSService {

  private apiServerUrl = environment.apiBaseUrl;
  model: any = {};
  sessionId: any = "";
  errorsListDto: ErrorsListDto = new ErrorsListDto();


  constructor(private router: Router, private http: HttpClient) { }

  // public registerEmplyee(user: EmployeeRequestDto): Observable<Object> {
  //   return this.http.post<EmployeeRequestDto>(`${this.apiServerUrl}/api/employee/registration`, user);
  // }

  public register(user: ClientRequestDto): Observable<Object> {
    return this.http.post<ClientRequestDto>(`${this.apiServerUrl}/api/client/registration`, user);
  }


  loginClient(email: string, password: string){
    let url = '/api/client/login';
    this.http.post<any>(url, {
      email: email,
      password: password
    }).subscribe(
      res => {
        console.log(res);

        if(res.sessionId != null){
          this.sessionId = res.sessionId;
          sessionStorage.setItem('token', this.sessionId);
          this.router.navigate(['localhost:4200/']);
          localStorage.setItem('email', this.model.email);
        } else {
          // res.errorsListDto.array.forEach((element: any) => {
            //   this.messageService.add({life:10000, severity:'error', summary: 'Logowanie', detail:element})
            // });
        }
      });
  }

  loginEmployee(email: string, password: string){
    let url = '/api/employee/login';
    this.http.post<any>(url, {
      email: email,
      password: password
    }).subscribe(
      res => {
        console.log(res);

        if(res.sessionId != null){
          this.sessionId = res.sessionId;
          sessionStorage.setItem('token', this.sessionId);
          this.router.navigate(['localhost:4200/']);
          localStorage.setItem('email', this.model.email);
        } else {
          // res.errorsListDto.array.forEach((element: any) => {
          //   this.messageService.add({life:10000, severity:'error', summary: 'Logowanie', detail:element})
          // });
        }
      });
  }

}
