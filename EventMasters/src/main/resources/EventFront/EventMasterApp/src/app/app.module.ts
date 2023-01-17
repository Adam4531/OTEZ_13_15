import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { DropdownDirective } from './shared/dropdown.directive';
import { TechnicalFaultComponent } from './technical-fault/technical-fault.component';
import { CartComponent } from './cart/cart.component';
import { EventsComponent } from './events/events.component';
import { OrganizeComponent } from './organize/organize.component';
import { SellComponent } from './sell/sell.component';
import { CompanyComponent } from './company/company.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EventDetailComponent } from './events/event-detail/event-detail.component';
import { EventListComponent } from './events/event-list/event-list.component';
import { EventItemComponent } from './events/event-list/event-item/event-item.component';
import { EventService } from './events/event.service';
import { AuthComponent } from './auth/auth.component';
import { MyEventsComponent } from './my-events/my-events.component';
import { MyTicketsComponent } from './my-tickets/my-tickets.component';
import { MyEventListComponent } from './my-events/my-event-list/my-event-list.component';
import { MyEventDetailComponent } from './my-events/my-event-detail/my-event-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DropdownDirective,
    TechnicalFaultComponent,
    CartComponent,
    EventsComponent,
    OrganizeComponent,
    SellComponent,
    CompanyComponent,
    EventDetailComponent,
    EventListComponent,
    EventItemComponent,
    AuthComponent,
    MyEventsComponent,
    MyTicketsComponent,
    MyEventListComponent,
    MyEventDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [EventService],
  bootstrap: [AppComponent]
})
export class AppModule { }
