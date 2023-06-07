package com.fieb.adotefacil.model;

public class Cor {
    private int id;
    private String cor;

    public Cor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return   cor  ;
    }
}
