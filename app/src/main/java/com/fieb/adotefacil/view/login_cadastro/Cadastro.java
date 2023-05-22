package com.fieb.adotefacil.view.login_cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fieb.adotefacil.R;
import com.fieb.adotefacil.controller.LoginController;
import com.fieb.adotefacil.model.LoginModel;
import com.google.android.material.snackbar.Snackbar;

public class Cadastro extends AppCompatActivity {
Button btnSalvar ;
EditText editEmail,editSenha,editConfirma;

    LoginModel loginModel  ;
    LoginController loginController  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        btnSalvar = findViewById(R.id.btn_entrar);
        editEmail = findViewById(R.id.edit_email);
        editSenha = findViewById(R.id.edit_senha);
        editConfirma = findViewById(R.id.edit_confirma);



        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editEmail.getText().toString().isEmpty() || editSenha.getText().toString().isEmpty()|| editConfirma.getText().toString().isEmpty()) {
                    Snackbar snackBar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT);
                    snackBar.setBackgroundTint(Color.YELLOW);
                    snackBar.show();
                }else if(! editSenha.getText().toString().equals(editConfirma.getText().toString())){
                    Snackbar snackBar = Snackbar.make(view, "Senha devem ser iguais!", Snackbar.LENGTH_SHORT);
                    editSenha.requestFocus();
                    snackBar.setBackgroundTint(Color.YELLOW);
                    System.out.println("SENHA: "+editSenha.getText().toString());
                    System.out.println("CONFIRMA: "+editConfirma.getText().toString());

                    snackBar.show();
                }else {
                    loginModel = new LoginModel();
                    loginModel.setEmail(editEmail.getText().toString());
                    loginModel.setSenha(editSenha.getText().toString());

                    loginController = new LoginController();
                    int validar = loginController.cadastrarLogin(loginModel, getApplicationContext());
                    if (validar > 0) {
                        Toast.makeText(Cadastro.this, "Cadastro realizado com Sucesso!", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(Cadastro.this, "Error no Cadastro!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}