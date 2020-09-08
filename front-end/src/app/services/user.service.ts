import { Injectable } from '@angular/core';
import { ApiServiceService } from './api-service.service';
import { Observable, BehaviorSubject } from 'rxjs';
import { ɵBrowserGetTestability } from '@angular/platform-browser';
import { UserUpdateModel } from '../models/UserUpdateModel';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private apiService:ApiServiceService) { }

  getUserByUserId(userId:string):Observable<any>{
    let user:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.get("user-service/users/"+ userId).subscribe(data =>{
      console.log(data);
      user.next(data);
    })
    return user;
  }

  updateUser(updateUser: UserUpdateModel, currentUserId: string):Observable<any> {
    let status:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.post("user-service/users/update/"+currentUserId, updateUser).subscribe(data =>{
      console.log(data);
      status.next(data)
    })
    return status
  }
}
