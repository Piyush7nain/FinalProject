import { Component, OnInit } from '@angular/core';
import { StorageService } from '../../services/storage.service';
import { UserService } from '../../services/user.service';
import { User } from '../../models/User';
import { UserUpdateModel } from '../../models/UserUpdateModel';

@Component({
  selector: 'app-user-landing',
  templateUrl: './user-landing.component.html',
  styleUrls: ['./user-landing.component.css']
})
export class UserLandingComponent implements OnInit {

  constructor(private storageService: StorageService,
    private userService: UserService) { }

  showUpdateForm:boolean = false

  updateUser: UserUpdateModel;
  currentUserId:string;
  currentUser:User;

  ngOnInit(): void {
    this.currentUserId = this.storageService.getUserInfo().userId;
    this.userService.getUserByUserId(this.currentUserId).subscribe(data =>{
      this.currentUser = data;
    })
  }

  onUpdate(){
    this.showUpdateForm = !this.showUpdateForm;
    this.updateUser={
      firstName : this.currentUser.firstName,
      lastName : this.currentUser.lastName,
      email: this.currentUser.email,
      oldPassword:'',
      newPassword:'',
      userId: this.currentUser.userId
    }
  }

  update(){
    this.showUpdateForm =false;
    console.log(this.updateUser)
    this.userService.updateUser(this.updateUser, this.currentUserId).subscribe(data=>{
      if(data.status =="successful"){
        this.currentUserId = this.updateUser.userId;
        this.storageService.updateUserInfo(this.currentUserId);
        this.userService.getUserByUserId(this.currentUserId).subscribe(data =>{
          this.currentUser = data;
        })
      }
    })
  }


}
