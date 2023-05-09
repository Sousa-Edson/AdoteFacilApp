package com.fieb.adotefacil.model;

public class Evento {

    int fotoEvento;
    String nomeEvento;
    String descricaoEvento;
    String dataEvento;

    public Evento() {
    }

    public Evento(int fotoEvento, String nomeEvento, String descricaoEvento, String dataEvento) {
        this.fotoEvento = fotoEvento;
        this.nomeEvento = nomeEvento;
        this.descricaoEvento = descricaoEvento;
        this.dataEvento = dataEvento;
    }

    public int getFotoEvento() {
        return fotoEvento;
    }

    public void setFotoEvento(int fotoEvento) {
        this.fotoEvento = fotoEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }
}