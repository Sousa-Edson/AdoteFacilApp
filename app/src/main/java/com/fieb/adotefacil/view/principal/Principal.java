package com.fieb.adotefacil.view.principal;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.fieb.adotefacil.R;
import com.fieb.adotefacil.adapter.AdapterAnuncio;
import com.fieb.adotefacil.model.Anuncio;
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
    public void onResume(Bundle savedInstanceState){
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
    public void preencheTela(){
// configurar o recyclerView
        RecyclerView recyclerView_anuncios = findViewById(R.id.recyclerView);
        recyclerView_anuncios.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView_anuncios.setHasFixedSize(true);
//configurar o adapter
        List<Anuncio> listaAnuncios = new ArrayList<>();

        AdapterAnuncio adapterAnuncio = new AdapterAnuncio(this,listaAnuncios);
        recyclerView_anuncios.setAdapter(adapterAnuncio);

        Anuncio anuncio1 = new Anuncio(
                R.drawable.tiger,
                "Tigre",
                "Tigres têm corpos musculosos com membros anteriores poderosos, " +
                        "grandes cabeças, caudas longas e garras enormes. A pelagem é densa e pesada;" +
                        " a varia entre tons de laranja e marrom com áreas ventrais brancas e listras " +
                        "pretas verticais distintas, cujos padrões são únicos para cada indivíduo.",
                "02/05/2023"
        );
//        listaAnuncios.add(anuncio1);
        for (int i = 0; i <10 ; i++) {
            Anuncio anuncio = new Anuncio();
            anuncio.setFotoAnuncio(   R.drawable.tiger);
            anuncio.setNomeAnuncio(  "Tigre");
            anuncio.setDescricaoAnuncio(  "Tigres têm corpos musculosos com membros anteriores poderosos, " +
                    "grandes cabeças, caudas longas e garras enormes. A pelagem é densa e pesada;" +
                    " a varia entre tons de laranja e marrom com áreas ventrais brancas e listras " +
                    "pretas verticais distintas, cujos padrões são únicos para cada indivíduo.");
            anuncio.setDataAnuncio(   "02/05/2023");


            anuncio.setNomeAnuncio(  "Tigre "+i);
            listaAnuncios.add(anuncio);
        }
        System.out.println("EXIBINDO ");
    }
}