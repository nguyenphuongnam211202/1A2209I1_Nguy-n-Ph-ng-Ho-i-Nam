import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HeaderFooterNavComponent } from './header-footer-nav/header-footer-nav.component';
import { ListServiceComponent } from './list-service/list-service.component';
import { EditServiceComponent } from './edit-service/edit-service.component';
import { AddServiceComponent } from './add-service/add-service.component';
import { ListCustomerComponent } from './list-customer/list-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HeaderFooterNavComponent,
    ListServiceComponent,
    EditServiceComponent,
    AddServiceComponent,
    ListCustomerComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
