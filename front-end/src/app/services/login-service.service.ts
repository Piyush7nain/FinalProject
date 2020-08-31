import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs'
import { ApiServiceService } from "./api-service.service"
import { UserAuthentication } from '../models/UserAuthentication';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor( private apiService: ApiServiceService ) { }


  login(obj:any){
    let returnObs: BehaviorSubject<any>  = new BehaviorSubject<any>([]);
    let tempObs: UserAuthentication;
    this.apiService.post('/user-service/users/login', obj).subscribe(data =>{
      console.log(data)
      tempObs ={
        userId:data.userId,
        status:data.status,
        token:data.token,
        role:data.role
      }
      returnObs.next(tempObs);
    })
    return returnObs;
  }

  signup(obj:any):Observable<any>{
    let signupResult: BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.post('/user-service/users/register', obj).subscribe(data =>{
      console.log(data);
      signupResult.next(data.signup);
    })
    return signupResult;
  }
}
