package com.billshare.backend.adapters.inbound;

public class UsuarioDTO {
    String name;
    String email;

    public UsuarioDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
