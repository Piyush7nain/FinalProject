import { Injectable } from '@angular/core';
import { UserAuthentication } from '../models/UserAuthentication';



@Injectable()
export class UserInfoService {

  public currentUserKey = 'currentUser';
  public storage: Storage = sessionStorage;

  constructor() { }

  // Store userinfo from session storage
  storeUserInfo(userInfoString: string) {
    this.storage.setItem(this.currentUserKey, userInfoString);
  }

  // Remove userinfo from session storage
  removeUserInfo() {
    this.storage.removeItem(this.currentUserKey);
  }

  // Get userinfo from session storage
  getUserInfo(): UserAuthentication | null {
    try {
      const userInfoString: string = this.storage.getItem(this.currentUserKey);
      if (userInfoString) {
        const userObj: UserAuthentication = JSON.parse(this.storage.getItem(this.currentUserKey));
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

  getStoredToken(): string | null {
    const userObj: UserAuthentication = this.getUserInfo();
    if (userObj !== null) {
      return userObj.token;
    }
    return null;
  }

}
