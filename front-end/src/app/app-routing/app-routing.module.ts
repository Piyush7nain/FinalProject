import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../components/login/login.component';
import { SignupComponent } from '../components/signup/signup.component';
import { AdminPageComponent } from '../components/admin-page/admin-page.component';
import { CompanyComponent } from '../components/company/company.component';
import { StockExComponent } from '../components/stock-ex/stock-ex.component';
import { UserLandingComponent } from '../components/user-landing/user-landing.component';
import { CompareCompanyComponent } from '../components/compare-company/compare-company.component'

const routes: Routes =[
  {path: '', component:LoginComponent},
  {path: 'login', component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'admin-page', component:AdminPageComponent},
  {path:'company',component:CompanyComponent},
  {path:'stockEx', component:StockExComponent},
  {path:'user-landing', component:UserLandingComponent},
  {path:'compare-company', component:CompareCompanyComponent}
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
