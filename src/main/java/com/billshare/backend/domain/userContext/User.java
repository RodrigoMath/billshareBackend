package com.billshare.backend.domain.userContext;

public class User {
    Long id;
    boolean active; // esse aqui pode ser uma relação futuro de mensalidade paga
    String userName;

    String email;
    String password;
    //EUserPlan plano;
    EUserRoles role;

    public User() {

    }

    public User(boolean active, String userName, String email, String password, EUserRoles role) {
        this.active = active;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EUserRoles getRole() {
        return role;
    }

    public void setRole(EUserRoles role) {
        this.role = role;
    }
}
