import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { EventDto } from './event';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {
  private events: EventDto[] = [];
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  setEvents(events: EventDto[]) {
    this.events = events;
  }

  public fetchEvents(): Observable<EventDto[]> {
    return this.http.get<EventDto[]>(`${this.apiServerUrl}/events/`).pipe(
      tap(events => {
        this.setEvents(events);
      })
    )

  }

  public getAll() {
    return this.events.slice();
  }

  getEvent(index: number) {
    return this.events[index];
  }


}
