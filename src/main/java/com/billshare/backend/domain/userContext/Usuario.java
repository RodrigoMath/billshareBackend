package com.billshare.backend.domain.userContext;

public class Usuario {
    Long id;
    String userName;
    String email;

    public Usuario() {

    }

    public Usuario( String userName, String email, EUserRoles role) {
        this.userName = userName;
        this.email = email;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
