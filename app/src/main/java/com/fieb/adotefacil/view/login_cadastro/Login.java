package com.fieb.adotefacil.view.login_cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.fieb.adotefacil.MainActivity;
import com.fieb.adotefacil.R;
import com.fieb.adotefacil.controller.LoginController;
import com.fieb.adotefacil.databinding.ActivityLoginBinding;
import com.fieb.adotefacil.model.LoginModel;
//import com.fieb.adotefacil.view.deletar_principal.Principal;
import com.google.android.material.snackbar.Snackbar;

public class Login extends AppCompatActivity {
    private ActivityLoginBinding binding;

    LoginModel loginModel  ;
    LoginController loginController  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnEntrar.setOnClickListener(view ->{
            String email = binding.editEmail.getText().toString();
            String senha = binding.editSenha.getText().toString();
            loginModel = new LoginModel();
            loginController = new LoginController();


            if (email.isEmpty() || senha.isEmpty()) {
                Snackbar snackBar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT);
                snackBar.setBackgroundTint(Color.RED);
                snackBar.show();
            } else {
                loginModel = loginController.validarLogin(getApplicationContext(), email, senha);
//                navegarTelaPrincipal();
                if (loginModel != null) {
                    navegarTelaPrincipal();
                } else {
                    Snackbar snackBar = Snackbar.make(view, "Usuário ou Senha incorretos!", Snackbar.LENGTH_SHORT);
                    snackBar.setBackgroundTint(Color.RED);
                    snackBar.show();
//                    binding.editEmail.setText("");
                    binding.editEmail.requestFocus();
//                    binding.editSenha.setText("");
                }
            }
        });
        binding.txtTelaCadastro.setOnClickListener(view ->{
            navegarCadastro();
        });
    }

    private void navegarCadastro() {
        Intent intent = new Intent(Login.this, Cadastro.class);
        startActivity(intent);
//        finish();
//        Toast.makeText(Login.this,"IR PARA TELA DE CADASTRO>>>",Toast.LENGTH_LONG).show();
    }

    private void navegarTelaPrincipal() {

        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLogged", true);
        editor.putString("EMAIL_LOGADO",loginModel.getEmail().toString());
        String nomeLogado="Adote fácil";
        if(loginModel.getNome() != null  ){
            nomeLogado=loginModel.getNome().toString();
        }
        editor.putString("NOME_LOGADO",nomeLogado);
        editor.apply();



        Intent intent = new Intent(Login.this, MainActivity.class);
//        intent.putExtra("EMAIL_LOGADO",loginModel.getEmail().toString());
//        String nomeLogado="Adote fácil";
//        if(loginModel.getNome() != null  ){
//            nomeLogado=loginModel.getNome().toString();
//        }
//        intent.putExtra("NOME_LOGADO",nomeLogado);
        startActivity(intent);
        finish();
    }
}