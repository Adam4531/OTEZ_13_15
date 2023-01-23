import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, tap } from 'rxjs';
import { EventDto } from './event';
import { environment } from 'src/environments/environment';

@Injectable()
export class EventsService {
  private events: EventDto[] = [];
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }



  public fetchEvents(): Observable<EventDto[]> {
    return this.http.get<EventDto[]>(`${this.apiServerUrl}/events/}`).pipe(
      tap(events => {
        this.setEvents(events);
      })
    )
  }

  setEvents(events: EventDto[]) {
    this.events = events;
    console.log('dziala')
    return this.events
  }

  public getAll() {
    return this.events.slice();
    // return this.http.get<EventDto[]>(`${this.apiServerUrl}/events/}`)
  }

  getEvent(index: number) {
    return this.events[index];
  }


}
