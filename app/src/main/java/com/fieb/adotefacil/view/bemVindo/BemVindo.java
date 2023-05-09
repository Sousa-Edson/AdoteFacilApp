package com.fieb.adotefacil.view.bemVindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fieb.adotefacil.R;
import com.fieb.adotefacil.controller.EventoController;
import com.fieb.adotefacil.view.principal.Principal;

public class BemVindo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        Button acesso = findViewById(R.id.btn_acesso);
        acesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventoController eventoController = new EventoController();
                System.out.println("MOBO:::::: "+eventoController.apresentarEvento(getApplicationContext()));
                Intent intent = new Intent(BemVindo.this, Principal.class);
                startActivity(intent);

            }
        });
    }

}