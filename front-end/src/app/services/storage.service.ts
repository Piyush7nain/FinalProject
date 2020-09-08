import { Injectable } from '@angular/core';
import { User } from '../models/User'

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  public currentUserKey = 'currentUser';
  public storage: Storage = sessionStorage;

  constructor() { }

  // Store userinfo from session storage
  storeUserInfo(user: any ) {
    let userInfoString:string = JSON.stringify(user);
    this.storage.setItem(this.currentUserKey, userInfoString);
  }

  // Remove userinfo from session storage
  removeUserInfo() {
    this.storage.removeItem(this.currentUserKey);
  }

  updateUserInfo(userId:string){
    let userInfo = this.getUserInfo()
    userInfo.userId =userId;
    this.removeUserInfo();
    this.storeUserInfo(userInfo);
  }

  // Get userinfo from session storage
  getUserInfo(): any | null {
    try {
      const userInfoString: string = this.storage.getItem(this.currentUserKey);
      if (userInfoString) {
        const userObj: any = JSON.parse(this.storage.getItem(this.currentUserKey));
        return userObj;
      } else {
        return null;
      }
    } catch (e) {
      return null;
    }
  }

  isLoggedIn(): boolean {
    return this.storage.getItem(this.currentUserKey) ? true : false;
  }

}
