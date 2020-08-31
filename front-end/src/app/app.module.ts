import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AppRoutingModule} from './app-routing/app-routing.module'
import { ApiServiceService } from '../app/services/api-service.service';
import { LoginServiceService } from '../app/services/login-service.service';
import { UserInfoService } from '../app/services/user-info.service';
import { SignupComponent } from './components/signup/signup.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent
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
    UserInfoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
