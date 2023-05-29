package com.fieb.adotefacil.model;

public class Evento {

    int fotoEvento;
    int idEvento;
    String camingoFotoEvento;
    String nomeEvento;
    String descricaoEvento;
    String dataEvento;

    String linkEvento;

    public Evento() {
    }

    public Evento(int fotoEvento, String nomeEvento, String descricaoEvento, String dataEvento) {
        this.fotoEvento = fotoEvento;
        this.nomeEvento = nomeEvento;
        this.descricaoEvento = descricaoEvento;
        this.dataEvento = dataEvento;
    }

    public Evento(int fotoEvento, int idEvento, String camingoFotoEvento, String nomeEvento, String descricaoEvento, String dataEvento, String linkEvento) {
        this.fotoEvento = fotoEvento;
        this.idEvento = idEvento;
        this.camingoFotoEvento = camingoFotoEvento;
        this.nomeEvento = nomeEvento;
        this.descricaoEvento = descricaoEvento;
        this.dataEvento = dataEvento;
        this.linkEvento = linkEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getLinkEvento() {
        return linkEvento;
    }

    public void setLinkEvento(String linkEvento) {
        this.linkEvento = linkEvento;
    }

    public String getCamingoFotoEvento() {
        return camingoFotoEvento;
    }

    public void setCamingoFotoEvento(String camingoFotoEvento) {
        this.camingoFotoEvento = camingoFotoEvento;
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