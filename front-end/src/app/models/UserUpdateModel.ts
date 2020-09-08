export class UserUpdateModel {
  userId:string;
  firstName:string;
  lastName:string;
  oldPassword?:string;
  newPassword?:string;
  role?:string;
  email:string
}
