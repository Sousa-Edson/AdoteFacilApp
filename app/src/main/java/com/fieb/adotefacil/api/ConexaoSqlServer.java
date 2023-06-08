package com.fieb.adotefacil.api;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoSqlServer {
    public static Connection conectar (Context context){
        //Objeto de conexão
        Connection conn = null;
        try{
            //Adiocionar politica de criação de thread
            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            //Verificar se o driver de Conexão está importada no projeto
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            //conexão de teste
            conn=DriverManager.getConnection("jdbc:jtds:sqlserver://adocaofieb2023.mssql.somee.com;databaseName=adocaofieb2023;" +
                    "user=rm87949edson_SQLLogin_2;password=oibzq36kuv;");

        }catch (android.database.SQLException e){
            //SQLException
            Toast.makeText(context,"Servidor Indisponivel",Toast.LENGTH_LONG).show();
            e.getMessage();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (java.sql.SQLException e){
            Toast.makeText(context,"Conection "+conn,Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return conn;
    }
}
