import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string ='';
  password: string ='';
  showError: boolean = false;
  constructor( private loginService: LoginServiceService,
               private router:Router ,
               private storageService: StorageService
              ) { }

  ngOnInit(): void {
  }

  onLogin(){
    const userInput: any ={
        userId : this.username,
        password :this.password
    }
    this.loginService.login(userInput).subscribe(data =>{
      if(data.status == "successful" && data.role =="admin"){
        this.storageService.storeUserInfo(data);
        this.router.navigate(['admin-page'])
      }
      if(data.status == "successful" && data.role =="user"){
        this.storageService.storeUserInfo(data);
        this.router.navigate(['user-landing'])
      }
      if(data.status == "failed" ){
        this.router.navigate(['login']);
        this.showError = true
      }
    })

  }

  onSignup(){
    this.router.navigate(['signup']);
  }



}
