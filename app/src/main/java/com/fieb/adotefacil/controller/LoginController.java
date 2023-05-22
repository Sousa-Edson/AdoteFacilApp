package com.fieb.adotefacil.controller;

import android.content.Context;

import com.fieb.adotefacil.api.ConexaoSqlServer;
import com.fieb.adotefacil.model.LoginModel;

import java.sql.PreparedStatement;
import org.mindrot.jbcrypt.BCrypt;
public class LoginController {
//    private BCryptPasswordEncoder passwordEncoder
    public int cadastrarLogin(LoginModel loginModel , Context context){
        int resposta=0;
        try{
            PreparedStatement pst = ConexaoSqlServer.conectar(context).prepareStatement("insert into usuario (email,senha,ativo) values(?,?,?)");
            pst.setString(1,loginModel.getEmail());
            //  passwordEncoder.encode
//            pst.setString(2,loginModel.getSenha());
            pst.setString(2,BCrypt.hashpw(loginModel.getSenha(), BCrypt.gensalt()));

            pst.setString(3,"true");
            resposta= pst.executeUpdate();
        }catch (Exception e){
            e.getMessage();
            System.out.println("ERRO: "+e.getMessage());
        }
        return resposta;}
}
