package com.fieb.adotefacil.model;

public class PetImagem {
    private int id;
    private String caminhoImagem;

    public PetImagem() {
    }

    public PetImagem(int id, String caminhoImagem) {
        this.id = id;
        this.caminhoImagem = caminhoImagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}
