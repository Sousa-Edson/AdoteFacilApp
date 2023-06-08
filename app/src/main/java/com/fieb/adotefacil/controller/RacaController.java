package com.fieb.adotefacil.controller;

import android.content.Context;

import com.fieb.adotefacil.api.ConexaoSqlServer;
import com.fieb.adotefacil.model.Animal;
import com.fieb.adotefacil.model.Raca;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RacaController {
    public ArrayList<Raca> listarRaca(Context context) {
        ArrayList<Raca> list = new ArrayList<>();
        try {
            Statement stm = ConexaoSqlServer.conectar(context).createStatement();
            ResultSet rs = stm.executeQuery("select id, raca,especie ,ativo from pet_raca;");
            while (rs.next()) {
                Raca raca = new Raca();
                raca.setId(rs.getInt(1));
                raca.setRaca(rs.getString(2));
                raca.setEspecie(rs.getString(3));

                list.add(raca);
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("MOBO Exception:::::: "+e);
        }
        //   System.out.println("MOBO OLA :::::: "+list);
        return list;
    }
}
