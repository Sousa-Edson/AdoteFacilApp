package com.fieb.adotefacil;


import static com.fieb.adotefacil.R.id.txt_nome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fieb.adotefacil.view.AboutFragment;
import com.fieb.adotefacil.view.GalleryFragment;
import com.fieb.adotefacil.view.HomeFragment;
import com.fieb.adotefacil.view.SettingsFragment;
import com.fieb.adotefacil.view.ShareFragment;
import com.google.android.material.navigation.NavigationView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    TextView textViewNome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);



        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }



    }
    @Override
    public  void onResume(){
        super.onResume();
// Inflar o layout que contém o TextView
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View layout = inflater.inflate(R.layout.nav_header, null);
//
//        // Encontrar o TextView no layout inflado
//         textViewNome = layout.findViewById(R.id.txt_nome);
//        System.out.println("OLA: "+textViewNome.getText().toString());
//        textViewNome.setText("Edson de Sousa");
//        System.out.println("OLA MUDADO: "+textViewNome.getText().toString());
//        String nome ="OLA aqui";
//     textViewNome.setText(nome);
//        System.out.println("OLA MUDADO 2: "+textViewNome.getText().toString());


        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);

        NavigationView navigationView = findViewById(R.id.nav_view); // Obtém a referência ao NavigationView
        View headerView = navigationView.getHeaderView(0); // Obtém a referência ao cabeçalho do NavigationView

        TextView textViewUsername = headerView.findViewById(R.id.txt_nome); // Obtém a referência ao TextView no cabeçalho
        textViewUsername.setText(sharedPreferences.getString("NOME_LOGADO", "")); // Define o novo valor do texto no TextView

        TextView textViewEmail = headerView.findViewById(R.id.txt_email);
        textViewEmail.setText(sharedPreferences.getString("EMAIL_LOGADO", ""));


    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() ==  R.id.nav_home){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        } else if(item.getItemId() ==  R.id.nav_gelery){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new GalleryFragment()).commit();
        } else if(item.getItemId() ==  R.id.nav_settings){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
        }
        else if(item.getItemId() ==  R.id.nav_share){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShareFragment()).commit();
        }
        else if(item.getItemId() ==  R.id.nav_about){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
        }
        else if(item.getItemId() ==  R.id.nav_logout){
            Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();

            SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLogged", false);
            editor.apply();

            finish();

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
