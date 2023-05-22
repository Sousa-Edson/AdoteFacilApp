package com.fieb.adotefacil.model;

public class LoginModel {
    private long idUsuario;
    private String email;
    private String senha;

    public LoginModel() {
    }

    public LoginModel(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
