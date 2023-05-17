package com.fieb.adotefacil.view.login_cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.fieb.adotefacil.R;
import com.fieb.adotefacil.databinding.ActivityLoginBinding;
import com.fieb.adotefacil.view.principal.Principal;
import com.google.android.material.snackbar.Snackbar;

public class Login extends AppCompatActivity {
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnEntrar.setOnClickListener(view ->{
            String email = binding.editEmail.getText().toString();
            String senha = binding.editSenha.getText().toString();
            if (email.isEmpty() || senha.isEmpty()) {
                Snackbar snackBar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT);
                snackBar.setBackgroundTint(Color.RED);
                snackBar.show();
            } else {
                navegarTelaPrincipal();
            }
        });
        binding.txtTelaCadastro.setOnClickListener(view ->{
            navegatCadastro();
        });
    }

    private void navegatCadastro() {
        Intent intent = new Intent(Login.this, Cadastro.class);
        startActivity(intent);
//        finish();
//        Toast.makeText(Login.this,"IR PARA TELA DE CADASTRO>>>",Toast.LENGTH_LONG).show();
    }

    private void navegarTelaPrincipal() {
        Intent intent = new Intent(Login.this, Principal.class);
        startActivity(intent);
        finish();
    }
}