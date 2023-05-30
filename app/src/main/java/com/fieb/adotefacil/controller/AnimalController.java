package com.fieb.adotefacil.controller;

import android.content.Context;

import com.fieb.adotefacil.api.ConexaoSqlServer;
import com.fieb.adotefacil.model.Animal;
import com.fieb.adotefacil.model.Evento;
import com.fieb.adotefacil.model.PetImagem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalController {

    public ArrayList<Animal> apresentarAnimal(Context context) {
        ArrayList<Animal> list = new ArrayList<>();
        try {
            Statement stm = ConexaoSqlServer.conectar(context).createStatement();
            ResultSet rs = stm.executeQuery("select id,sexo,nome,resumo,observacao from animal");
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt(1));
                animal.setSexo(rs.getInt(2));
                animal.setNome(rs.getString(3));
                animal.setResumo(rs.getString(4));
                animal.setObservacao(rs.getString(5));
                animal.setCaminhoFotoAnimal((List<PetImagem>) rs.getArray(6));
               // evento.setFotoEvento(Integer.parseInt(evento.getCamingoFotoEvento()));
                list.add(animal);
                System.out.println("MOBO getCaminhoFotoAnimal:::::: "+animal.getCaminhoFotoAnimal());
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
