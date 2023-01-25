import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, Output } from '@angular/core';
import { EventDto } from './event';
import { environment } from 'src/environments/environment';
import { map, Observable, Subject, tap } from 'rxjs';

@Injectable()
export class EventsService {

  private apiServerUrl = environment.apiBaseUrl;

 eventsChanged = new Subject<EventDto[]>();

 private events: EventDto[] = [];

  constructor(private http: HttpClient) {
  }



  async fetchEvents(): Promise<void>{
    this.http.get<EventDto[]>(`${this.apiServerUrl}/events/`).subscribe((response: any) => {
      this.setEvents(response)});
  }


  async setEvents(events: EventDto[]){
    this.events = events;
    this.eventsChanged.next(this.events.slice());
  }


  public getAll() {
    return this.eventsChanged.asObservable();
    // this.eventsChanged.next(this.events.slice());
    // return this.events.slice();

    // return this.http.get<EventDto[]>(`${this.apiServerUrl}/events/}`)
  }

  public getEvent(ID: number) {
    return this.events[ID];
  }

  get getEventToTech(): Observable<EventDto>{
    return this.http.get<EventDto>(`${this.apiServerUrl}/events/`)
}



}
