import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { CompanyComponent } from './company/company.component';
import { EventsComponent } from './events/events.component';
import { OrganizeComponent } from './organize/organize.component';
import { SellComponent } from './sell/sell.component';
import { TechnicalFaultComponent } from './technical-fault/technical-fault.component';


const routes: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full' },
  { path: 'report', component: TechnicalFaultComponent },
  { path: 'cart', component: CartComponent },
  { path: 'events', component: EventsComponent },
  { path: 'organize', component: OrganizeComponent },
  { path: 'sell', component: SellComponent },
  { path: 'company', component: CompanyComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
