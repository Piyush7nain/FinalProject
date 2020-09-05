import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../components/login/login.component';
import { SignupComponent } from '../components/signup/signup.component';
import { AdminPageComponent } from '../components/admin-page/admin-page.component';
import { CompanyComponent } from '../components/company/company.component';


const routes: Routes =[
  {path: '', component:LoginComponent},
  {path: 'login', component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'admin-page', component:AdminPageComponent},
  {path:'company',component:CompanyComponent}
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
