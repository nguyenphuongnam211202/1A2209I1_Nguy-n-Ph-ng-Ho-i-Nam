import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HeaderFooterNavComponent } from './header-footer-nav/header-footer-nav.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HeaderFooterNavComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
