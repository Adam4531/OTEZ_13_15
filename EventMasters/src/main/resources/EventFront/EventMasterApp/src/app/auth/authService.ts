import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { EmployeeRequestDto } from './employee-request-dto';
import { ClientRequestDto } from './user-request';

@Injectable({
  providedIn: 'root'
})
export class AuthSService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public registerEmplyee(user: EmployeeRequestDto): Observable<Object> {
    return this.http.post<EmployeeRequestDto>(`${this.apiServerUrl}/api/registration`, user);
  }

  public register(user: ClientRequestDto): Observable<Object> {
    return this.http.post<ClientRequestDto>(`${this.apiServerUrl}/api/registration`, user);
  }
}
