package com.fieb.adotefacil.controller;

import android.content.Context;

import com.fieb.adotefacil.api.ConexaoSqlServer;
import com.fieb.adotefacil.model.Animal;
import com.fieb.adotefacil.model.Evento;
import com.fieb.adotefacil.model.LoginModel;
import com.fieb.adotefacil.model.PetImagem;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
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
            ResultSet rs = stm.executeQuery("select id,sexo,nome,resumo,observacao ,nascimento from animal");
//            ResultSet rs = stm.executeQuery("SELECT animal.id, animal.sexo, animal.nome, animal.resumo, animal.observacao, MIN(pet_imagem.url_imagem) AS primeira_imagem" +
//                    " FROM animal JOIN pet_imagem ON animal.id = pet_imagem.animal_id GROUP BY animal.id, animal.sexo, animal.nome, animal.resumo, animal.observacao");
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt(1));
                animal.setSexo(rs.getInt(2));
                animal.setNome(rs.getString(3));
                animal.setResumo(rs.getString(4));
                animal.setObservacao(rs.getString(5));
                animal.setNascimento(rs.getDate(6));
//                animal.setFotoAnimal(rs.getString(1));
//                animal.setCaminhoFotoAnimal((List<PetImagem>) rs.getArray(6));
                // evento.setFotoEvento(Integer.parseInt(evento.getCamingoFotoEvento()));
                animal.setCaminhoFotoAnimal(listaImagem(context,rs.getString(1)));
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

    public ArrayList<PetImagem> listaImagem(Context context,String animalId) {
        ArrayList<PetImagem> list = new ArrayList<>();
        try {
            Statement stm = ConexaoSqlServer.conectar(context).createStatement();
            ResultSet rs = stm.executeQuery("select url_imagem,animal_id from pet_imagem where animal_id = "+animalId );
            while (rs.next()) {
                PetImagem petImagem = new PetImagem();
                petImagem.setCaminhoImagem(rs.getString(1));
                petImagem.setIdAnimal(rs.getInt(2));
                list.add(petImagem);
                System.out.println("IMAGEM :::::: "+petImagem.getCaminhoImagem());
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("MOBO Exception:::::: "+e);
        }
        return list;
    }
    public int criarAnimal(Animal animalModel, Context context){
        int resposta = 0;
        try {
            PreparedStatement pst = ConexaoSqlServer.conectar(context).prepareStatement("INSERT INTO animal " +
                    "(disponivel, especie, nascimento, nome, observacao, porte, resumo, sexo, vacina, cor_id, raca_id, usuario_id) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);");
            pst.setBoolean(1,true);
            pst.setString(2,animalModel.getEspecie().toString());
            pst.setDate(3,animalModel.getNascimento());
            pst.setString(4,animalModel.getNome().toString());
            pst.setString(5,animalModel.getObservacao().toString());
            pst.setString(6,animalModel.getPorte().toString());
            pst.setString(7,animalModel.getResumo().toString());
            pst.setInt(8,animalModel.getSexo());
            pst.setInt(9,animalModel.getVacina());
            pst.setInt(10,animalModel.getCor());
            pst.setInt(11,animalModel.getRaca());
            pst.setInt(12,1);

            resposta = pst.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERRO: " + e.getMessage());
        }
        return resposta;
    }

}
