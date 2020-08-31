import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from '../../models/user'
import { LoginServiceService } from 'src/app/services/login-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  newUser: User ={
    userId:'',
    firstName:'',
    lastName:'',
    email:''
  }

  constructor(private loginService: LoginServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  onSignup(){
    this.loginService.signup(this.newUser).subscribe(data =>{
      if(data =='successful'){ this.router.navigate(['login'])}
    })
  }

}
