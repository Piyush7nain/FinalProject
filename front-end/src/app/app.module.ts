import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ApiServiceService } from '../app/services/api-service.service';
import { LoginServiceService } from '../app/services/login-service.service';
import { CompanyServiceService } from '../app/services/company-service.service';
import { IpoService } from '../app/services/ipo.service';
import { StockExService } from '../app/services/stock-ex.service';
import { StocksService } from '../app/services/stocks.service';
import { UploadExcelService } from '../app/services/upload-excel.service';
import { StorageService } from  '../app/services/storage.service';
import { UserService } from '../app/services/user.service';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AppRoutingModule} from './app-routing/app-routing.module'
import { SignupComponent } from './components/signup/signup.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { AdminNavbarComponent } from './components/admin-navbar/admin-navbar.component';
import { CompanyComponent } from './components/company/company.component';
import { IpoComponent } from './components/ipo/ipo.component';
import { StockExComponent } from './components/stock-ex/stock-ex.component';
import { ShowStockExComponent } from './components/show-stock-ex/show-stock-ex.component';
import { ShowStocksComponent } from './components/show-stocks/show-stocks.component';
import { ShowRegisteredCompanyComponent } from './components/show-registered-company/show-registered-company.component';
import { UploadExcelComponent } from './components/upload-excel/upload-excel.component';
import { UploadStocksComponent } from './components/upload-stocks/upload-stocks.component';
import { ShowCompanyComponent } from './components/show-company/show-company.component';
import { UserNavbarComponent } from './components/user-navbar/user-navbar.component';
import { UserLandingComponent } from './components/user-landing/user-landing.component';
import { CompareCompanyComponent } from './components/compare-company/compare-company.component';
import { ChartsComponent } from './components/charts/charts.component';

import { FusionChartsModule } from 'angular-fusioncharts';
// Import FusionCharts library and chart modules
import * as FusionCharts from 'fusioncharts';
import * as Charts from 'fusioncharts/fusioncharts.charts';
import * as TimeSeries from 'fusioncharts/fusioncharts.timeseries';
import { ShowChartComponent } from './components/show-chart/show-chart.component'; // Import timeseries
// Pass the fusioncharts library and timeseries modules
FusionChartsModule.fcRoot(FusionCharts,Charts, TimeSeries);


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    AdminPageComponent,
    AdminNavbarComponent,
    CompanyComponent,
    IpoComponent,
    StockExComponent,
    ShowStockExComponent,
    ShowStocksComponent,
    ShowRegisteredCompanyComponent,
    UploadExcelComponent,
    UploadStocksComponent,
    ShowCompanyComponent,
    UserNavbarComponent,
    UserLandingComponent,
    CompareCompanyComponent,
    ChartsComponent,
    ShowChartComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FusionChartsModule
  ],


  providers: [
    ApiServiceService,
    LoginServiceService,
    CompanyServiceService,
    IpoService,
    StockExService,
    StocksService,
    UploadExcelService,
    StorageService,
    UserService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
