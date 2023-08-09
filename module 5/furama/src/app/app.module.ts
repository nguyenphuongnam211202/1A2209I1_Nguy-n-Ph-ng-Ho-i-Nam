import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderFooterNavComponent } from './header-footer-nav/header-footer-nav.component';
import { ListServiceComponent } from './list-service/list-service.component';
import { EditServiceComponent } from './edit-service/edit-service.component';
import { AddServiceComponent } from './add-service/add-service.component';
import { ListCustomerComponent } from './list-customer/list-customer.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { AddContractComponent } from './add-contract/add-contract.component';
import { ListContractComponent } from './list-contract/list-contract.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderFooterNavComponent,
    ListServiceComponent,
    EditServiceComponent,
    AddServiceComponent,
    ListCustomerComponent,
    EditCustomerComponent,
    AddCustomerComponent,
    AddContractComponent,
    ListContractComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
