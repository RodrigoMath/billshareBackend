package com.billshare.backend.domain.user;

import java.util.List;

public class User {
    Long id;
    boolean active; // esse aqui eu tenho que pensar, vale a pena? se o basic for o gratuito não...
    String userName;
    //Aqui teremos dois tipos de email, o do usuário que será apenas uma String e a lista de e-mails destino.
    String email;
    List<String> emails;
    String password;
    EUserPlan plano;

    public User() {

    }

    public User(boolean active, String userName, String email, List<String> emails, String password, EUserPlan plano) {
        this.active = active;
        this.userName = userName;
        this.email = email;
        this.emails = emails;
        this.password = password;
        this.plano = plano;
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

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EUserPlan getPlano() {
        return plano;
    }

    public void setPlano(EUserPlan plano) {
        this.plano = plano;
    }
}
