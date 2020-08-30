package com.piyush.UserService.shared;

public class UserAuthenticate {

    
    private String UserId;

    private String password;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAuthenticate() {
    }

    public UserAuthenticate(String userId, String password) {
        UserId = userId;
        this.password = password;
    }

    
}