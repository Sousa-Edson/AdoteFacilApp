package com.fieb.adotefacil.controller;

import android.content.Context;

import com.fieb.adotefacil.api.ConexaoSqlServer;
import com.fieb.adotefacil.model.LoginModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

public class LoginController {
    public int cadastrarLogin(LoginModel loginModel, Context context) {
        int resposta = 0;
        try {
            PreparedStatement pst = ConexaoSqlServer.conectar(context).prepareStatement("insert into usuario (email,senha,ativo,permissao) values(?,?,?,?)");
            pst.setString(1, loginModel.getEmail());
            pst.setString(2, BCrypt.hashpw(loginModel.getSenha(), BCrypt.gensalt()));

            pst.setString(3, "true");
            pst.setString(4, "USUARIO");
            resposta = pst.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERRO: " + e.getMessage());
        }
        return resposta;
    }
    public static LoginModel validarLogin(Context context, String email, String senha) {
//        System.out.println("VALIDAR LOGIN - SENHA: "+
//                BCrypt.checkpw(senha,
//                        "$2a$10$abnIKBMK5MsbfZSJkH9g5uwgVMLjtWWH0E/5aJ4iMOCFEcbvgsgLq"));
        try {
            PreparedStatement pst = ConexaoSqlServer.conectar(context).prepareStatement(
                    "SELECT email, senha,nome FROM usuario WHERE email=? "); //AND senha=?
            pst.setString(1,email);
         //   pst.setString(2, BCrypt.hashpw(senha,BCrypt.gensalt()));

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                boolean passwordMatches = BCrypt.checkpw(senha,res.getString(2));
                System.out.println("SENHA DO BANCO: "+res.getString(2));
                if(passwordMatches) {
                    LoginModel loginModel = new LoginModel();
                    loginModel.setEmail(res.getString(1));
                    loginModel.setSenha(res.getString(2));
                    loginModel.setNome(res.getString(3));
                    System.out.println("DEU CERTO AO VALIDAR LOGIN: " + loginModel.getEmail());
                    return loginModel;
                }else{
                    return null;
                }
            }
        } catch (Exception e) {
            System.out.println("ERRO AO VALIDAR LOGIN: "+e.getMessage());
            e.getMessage();
        }
        return null;
    }

}
