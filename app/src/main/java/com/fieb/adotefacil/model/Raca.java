package com.fieb.adotefacil.model;

public class Raca {
    private int id;
    private String raca;

    public Raca() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return   raca  ;
    }
}
