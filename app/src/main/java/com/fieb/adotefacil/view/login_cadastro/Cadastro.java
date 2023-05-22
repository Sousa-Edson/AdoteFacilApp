package com.fieb.adotefacil.view.login_cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fieb.adotefacil.R;
import com.fieb.adotefacil.controller.LoginController;
import com.fieb.adotefacil.model.LoginModel;

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
                loginModel = new LoginModel();
                loginModel.setEmail(editEmail.getText().toString());
                loginModel.setSenha(editSenha.getText().toString());

                loginController = new LoginController();
                int validar = loginController.cadastrarLogin(loginModel, getApplicationContext());
                if (validar > 0) {
//                    Auxiliares.alert(getApplicationContext(), "Cadastro realizado com Sucesso!");
                    Toast.makeText(Cadastro.this,"Cadastro realizado com Sucesso!",Toast.LENGTH_LONG).show();;
                    finish();
                } else {
                    Toast.makeText(Cadastro.this,"Error no Cadastro!",Toast.LENGTH_LONG).show();;
//                    Auxiliares.alert(getApplicationContext(), "Error no Cadastro!");
                }
            }
        });
    }
}