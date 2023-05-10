package com.fieb.adotefacil.controller;

import android.content.Context;

import com.fieb.adotefacil.api.ConexaoSqlServer;
import com.fieb.adotefacil.model.Evento;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EventoController {
    public ArrayList<Evento> apresentarEvento(Context context) {
        ArrayList<Evento> list = new ArrayList<>();
        try {
            Statement stm = ConexaoSqlServer.conectar(context).createStatement();
            ResultSet rs = stm.executeQuery("select data_publicacao,titulo,conteudo,caminho_imagem from postagem");
            while (rs.next()) {
                Evento evento = new Evento();
                evento.setDataEvento(rs.getString(1));
                evento.setNomeEvento(rs.getString(2));
                evento.setDescricaoEvento(rs.getString(3));
                evento.setCamingoFotoEvento(rs.getString(4));
               // evento.setFotoEvento(Integer.parseInt(evento.getCamingoFotoEvento()));
                list.add(evento);
                System.out.println("MOBO getCamingoFotoEvento:::::: "+evento.getCamingoFotoEvento());
            }
          //  System.out.println("MOBO TRY:::::: ");
        } catch (Exception e) {
            e.getMessage();
            System.out.println("MOBO Exception:::::: "+e);
        }
     //   System.out.println("MOBO OLA :::::: "+list);
//        list.add(new Evento("Teste","Descrição evento","12/12/2012"));
        return list;
    }

}
