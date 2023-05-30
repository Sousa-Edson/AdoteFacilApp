package com.fieb.adotefacil.model;

public class PetImagem {
    private int id;
    private int idAnimal;
    private String caminhoImagem;

    public PetImagem() {
    }

    public PetImagem(int id, int idAnimal, String caminhoImagem) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.caminhoImagem = caminhoImagem;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
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
