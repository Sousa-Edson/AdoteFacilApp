package com.fieb.adotefacil.view.principal;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.fieb.adotefacil.R;
import com.fieb.adotefacil.adapter.AdapterEvento;
import com.fieb.adotefacil.controller.EventoController;
import com.fieb.adotefacil.model.Evento;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fieb.adotefacil.databinding.ActivityPrincipalBinding;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityPrincipalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarPrincipal.toolbar);
        binding.appBarPrincipal.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_principal);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    public void onResume(Bundle savedInstanceState) {
        super.onResume();
//        Toast.makeText(Principal.this, "resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        preencheTela();
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_principal);


        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();

    }

    public void preencheTela() {
// configurar o recyclerView
        RecyclerView recyclerView_Eventos = findViewById(R.id.recyclerView);
        recyclerView_Eventos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView_Eventos.setHasFixedSize(true);
//configurar o adapter
        List<Evento> listaEventos = new ArrayList<>();
        EventoController eventoController = new EventoController();
        listaEventos = eventoController.apresentarEvento(getApplicationContext());
        AdapterEvento adapterEvento = new AdapterEvento(this, listaEventos);
        recyclerView_Eventos.setAdapter(adapterEvento);


        System.out.println("EXIBINDO ");
    }
}