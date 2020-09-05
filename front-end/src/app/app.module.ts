import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ApiServiceService } from '../app/services/api-service.service';
import { LoginServiceService } from '../app/services/login-service.service';
import { UserInfoService } from '../app/services/user-info.service';
import { CompanyServiceService } from '../app/services/company-service.service';
import { IpoService } from '../app/services/ipo.service';
import { StockExService } from '../app/services/stock-ex.service'

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AppRoutingModule} from './app-routing/app-routing.module'
import { SignupComponent } from './components/signup/signup.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { AdminNavbarComponent } from './components/admin-navbar/admin-navbar.component';
import { CompanyComponent } from './components/company/company.component';
import { IpoComponent } from './components/ipo/ipo.component';
import { ShowCompanyComponent } from './components/show-company/show-company.component';
import { StockExComponent } from './components/stock-ex/stock-ex.component';
import { StockExAddFormComponent } from './components/stock-ex-add-form/stock-ex-add-form.component';
import { ShowStockExComponent } from './components/show-stock-ex/show-stock-ex.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    AdminPageComponent,
    AdminNavbarComponent,
    CompanyComponent,
    IpoComponent,
    ShowCompanyComponent,
    StockExComponent,
    StockExAddFormComponent,
    ShowStockExComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    ApiServiceService,
    LoginServiceService,
    UserInfoService,
    CompanyServiceService,
    IpoService,
    StockExService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
