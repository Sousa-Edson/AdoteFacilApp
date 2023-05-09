package com.fieb.adotefacil.controller;

import com.fieb.adotefacil.model.Anuncio;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AnuncioController {
    public ArrayList<Anuncio> apresentarAnuncio() {
        ArrayList<Anuncio> list = new ArrayList<Anuncio>();
        try {
            Statement stm = null;
            ResultSet rs = stm.executeQuery("SELECT ");
            while (rs.next()) {
                Anuncio anuncio = new Anuncio();
                anuncio.setDataAnuncio(rs.getString(1));
                anuncio.setNomeAnuncio(rs.getString(2));
                anuncio.setDescricaoAnuncio(rs.getString(3));
                anuncio.setFotoAnuncio(rs.getInt(4));
                list.add(anuncio);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

}
