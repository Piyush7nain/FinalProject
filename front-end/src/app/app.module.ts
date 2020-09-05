import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ApiServiceService } from '../app/services/api-service.service';
import { LoginServiceService } from '../app/services/login-service.service';
import { UserInfoService } from '../app/services/user-info.service';
import { CompanyServiceService } from '../app/services/company-service.service'

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AppRoutingModule} from './app-routing/app-routing.module'
import { SignupComponent } from './components/signup/signup.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { AdminNavbarComponent } from './components/admin-navbar/admin-navbar.component';
import { CompanyComponent } from './components/company/company.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    AdminPageComponent,
    AdminNavbarComponent,
    CompanyComponent
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
    CompanyServiceService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
