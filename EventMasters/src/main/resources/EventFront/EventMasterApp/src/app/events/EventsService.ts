import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EventDto } from './event';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable()
export class EventsService {
  private events: EventDto[] = [];
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }



  public fetchEvents(): void {
    this.http.get<EventDto[]>(`${this.apiServerUrl}/events/`).subscribe((response: any) => {
      this.events = response;})
  }


  public getAll() {
    console.log('dziala')
    return this.events.slice();
    // return this.http.get<EventDto[]>(`${this.apiServerUrl}/events/}`)
  }

  getEvent(index: number) {
    return this.events[index];
  }


}
