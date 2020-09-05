import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string ='';
  password: string ='';
  showError: boolean = false;
  constructor( private loginService: LoginServiceService, private router:Router) { }

  ngOnInit(): void {
  }

  onLogin(){
    const userInput: any ={
        userId : this.username,
        password :this.password
    }
    this.loginService.login(userInput).subscribe(data =>{
      if(data.status == "successful" && data.role =="admin"){this.router.navigate(['admin-page'])}
      if(data.status == "successful" && data.role =="user"){ this.router.navigate(['user-page'])}
      if(data.status == "login-failed" ){ this.router.navigate(['login']); this.showError = true}
    })

  }

  onSignup(){
    this.router.navigate(['signup']);
  }



}
