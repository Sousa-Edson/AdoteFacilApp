package com.fieb.adotefacil.model;

public class Anuncio {

    int fotoAnuncio;
    String nomeAnuncio;
    String descricaoAnuncio;
    String dataAnuncio;

    public Anuncio() {
    }

    public Anuncio(int fotoAnuncio, String nomeAnuncio, String descricaoAnuncio, String dataAnuncio) {
        this.fotoAnuncio = fotoAnuncio;
        this.nomeAnuncio = nomeAnuncio;
        this.descricaoAnuncio = descricaoAnuncio;
        this.dataAnuncio = dataAnuncio;
    }

    public int getFotoAnuncio() {
        return fotoAnuncio;
    }

    public void setFotoAnuncio(int fotoAnuncio) {
        this.fotoAnuncio = fotoAnuncio;
    }

    public String getNomeAnuncio() {
        return nomeAnuncio;
    }

    public void setNomeAnuncio(String nomeAnuncio) {
        this.nomeAnuncio = nomeAnuncio;
    }

    public String getDescricaoAnuncio() {
        return descricaoAnuncio;
    }

    public void setDescricaoAnuncio(String descricaoAnuncio) {
        this.descricaoAnuncio = descricaoAnuncio;
    }

    public String getDataAnuncio() {
        return dataAnuncio;
    }

    public void setDataAnuncio(String dataAnuncio) {
        this.dataAnuncio = dataAnuncio;
    }
}