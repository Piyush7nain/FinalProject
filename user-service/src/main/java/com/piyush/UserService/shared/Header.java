package com.piyush.UserService.shared;

public class Header {

    private String UserId;

    private String status;

    private String role;

    public Header(String userId, String status, String role) {
        UserId = userId;
        this.status = status;
        this.role = role;
    }

    public Header() {
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
}