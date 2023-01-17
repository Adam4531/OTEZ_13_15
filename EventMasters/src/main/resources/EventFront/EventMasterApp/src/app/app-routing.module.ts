import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { CartComponent } from './cart/cart.component';
import { CompanyComponent } from './company/company.component';
import { EventDetailComponent } from './events/event-detail/event-detail.component';
import { EventStartComponent } from './events/event-start/event-start.component';
import { EventsComponent } from './events/events.component';
import { MyEventDetailComponent } from './my-events/my-event-detail/my-event-detail.component';
import { MyEventsComponent } from './my-events/my-events.component';
import { MyTicketsComponent } from './my-tickets/my-tickets.component';
import { OrganizeComponent } from './organize/organize.component';
import { SellComponent } from './sell/sell.component';
import { TechnicalFaultComponent } from './technical-fault/technical-fault.component';


const routes: Routes = [
  { path: '', redirectTo: 'events', pathMatch: 'full' },
  { path: 'report', component: TechnicalFaultComponent },
  { path: 'cart', component: CartComponent },
  {path: 'events', component: EventsComponent, children: [
    {path: '', component: EventStartComponent},
    {path: ':id', component: EventDetailComponent},
  ]},
  { path: 'organize', component: OrganizeComponent },
  { path: 'sell', component: SellComponent },
  { path: 'company', component: CompanyComponent },
  { path: 'my_tickets', component: MyTicketsComponent },
  { path: 'my_events', component: MyEventsComponent, children:[
    {path: '', component: EventStartComponent},
    {path: ':id', component: MyEventDetailComponent},
  ] },
  { path: 'auth/:id', component: AuthComponent },
  { path: 'auth', component: AuthComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
