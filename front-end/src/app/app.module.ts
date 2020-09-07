import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ApiServiceService } from '../app/services/api-service.service';
import { LoginServiceService } from '../app/services/login-service.service';
import { UserInfoService } from '../app/services/user-info.service';
import { CompanyServiceService } from '../app/services/company-service.service';
import { IpoService } from '../app/services/ipo.service';
import { StockExService } from '../app/services/stock-ex.service';
import { StocksService } from '../app/services/stocks.service';
import { UploadExcelService } from '../app/services/upload-excel.service'

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
import { ShowStockExComponent } from './components/show-stock-ex/show-stock-ex.component';
import { ShowStocksComponent } from './components/show-stocks/show-stocks.component';
import { ShowRegisteredCompanyComponent } from './components/show-registered-company/show-registered-company.component';
import { UploadExcelComponent } from './components/upload-excel/upload-excel.component';
import { UploadStocksComponent } from './components/upload-stocks/upload-stocks.component';


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
    ShowStockExComponent,
    ShowStocksComponent,
    ShowRegisteredCompanyComponent,
    UploadExcelComponent,
    UploadStocksComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [
    ApiServiceService,
    LoginServiceService,
    UserInfoService,
    CompanyServiceService,
    IpoService,
    StockExService,
    StocksService,
    UploadExcelService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
