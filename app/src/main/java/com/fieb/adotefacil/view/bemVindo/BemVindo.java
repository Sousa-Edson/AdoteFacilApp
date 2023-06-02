package com.fieb.adotefacil.view.bemVindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.fieb.adotefacil.MainActivity;
import com.fieb.adotefacil.R;
import com.fieb.adotefacil.api.ConexaoSqlServer;
import com.fieb.adotefacil.view.login_cadastro.Login;

import java.sql.PreparedStatement;

public class BemVindo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarLogin();
            }
        },2000);

    }
    private void mostrarLogin(){
        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        boolean isLogged = sharedPreferences.getBoolean("isLogged", false);
        PreparedStatement pst = (PreparedStatement) ConexaoSqlServer.conectar(getApplicationContext());

        if (isLogged) {

            // Redirecione o usuário para a tela principal
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish(); // Opcional, para finalizar a tela de entrada
        }else{


        Intent intent = new Intent(BemVindo.this, Login.class);
        startActivity(intent);
        finish();}
    }

}