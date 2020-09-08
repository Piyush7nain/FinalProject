package com.piyush.UserService.shared;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateModel {

	private String userId;

	private String firstName;

	private String lastName;
	private String oldPassword;
	private String newPassword;
	private String email;
	@JsonIgnore
	private String role;

	public UserUpdateModel(String userId, String oldPassword,String newPassword, String firstName, String lastName, String email,
			String role) {
		super();
		this.role = role;
		this.userId = userId;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UserUpdateModel() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String password) {
		this.oldPassword = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserRequestModel [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+  ", email=" + email + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	
}
