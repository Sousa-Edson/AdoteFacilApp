package com.fieb.adotefacil.controller;

import com.fieb.adotefacil.model.Evento;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EventoController {
    public ArrayList<Evento> apresentarEvento() {
        ArrayList<Evento> list = new ArrayList<>();
        try {
            Statement stm = null;
            ResultSet rs = stm.executeQuery("SELECT data_publicacao,titulo,conteudo,caminho_imagem" +
                    " FROM postagem  ");
            while (rs.next()) {
                Evento evento = new Evento();
                evento.setDataEvento(rs.getString(1));
                evento.setNomeEvento(rs.getString(2));
                evento.setDescricaoEvento(rs.getString(3));
                evento.setFotoEvento(rs.getInt(4));
                list.add(evento);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

}
