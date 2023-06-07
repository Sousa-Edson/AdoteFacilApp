package com.fieb.adotefacil.controller;

import android.content.Context;

import com.fieb.adotefacil.api.ConexaoSqlServer;
import com.fieb.adotefacil.model.Cor;
import com.fieb.adotefacil.model.Raca;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CorController {
    public ArrayList<Cor> listarCor(Context context) {
        ArrayList<Cor> list = new ArrayList<>();
        try {
            Statement stm = ConexaoSqlServer.conectar(context).createStatement();
            ResultSet rs = stm.executeQuery("select id, cor ,ativo from pet_cor;");
            while (rs.next()) {
                Cor cor = new Cor();
                cor.setId(rs.getInt(1));
                cor.setCor(rs.getString(2));

                list.add(cor);
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("MOBO Exception:::::: "+e);
        }
        //   System.out.println("MOBO OLA :::::: "+list);
        return list;
    }
}
