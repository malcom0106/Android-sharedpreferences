package com.example.exemplesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplesharedpreferences.Entities.Adherent;
import com.example.exemplesharedpreferences.Utilities.Constantes;
import com.example.exemplesharedpreferences.Utilities.Fonctions;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    Context _context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _context = this;

        final TextView textView = findViewById(R.id.txtAdherent);
        final Button btnCreer = findViewById(R.id.btnCreateAdherent);
        final Button btnDeconnexion = findViewById(R.id.btnDeconnexion);

        //On recupere l'adherent en memoire
        String adherentJson = Fonctions.getSharedPreference(_context,Constantes.ADHERENT_SHARED);
        if(!adherentJson.isEmpty()){
            Gson gson = new Gson();
            Adherent adherent = gson.fromJson(adherentJson,Adherent.class);
            //On affiche un message sur la page d'accueil
            textView.setText("Bonjour "+ adherent.getNom().toUpperCase() + " " + adherent.getPrenom());
            btnCreer.setVisibility(View.INVISIBLE);
            btnDeconnexion.setVisibility(View.VISIBLE);

        }

        btnDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fonctions.removeSharedPreference(_context, Constantes.ADHERENT_SHARED);
                btnCreer.setVisibility(View.VISIBLE);
                btnDeconnexion.setVisibility(View.INVISIBLE);
                textView.setText("");
            }
        });

        btnCreer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_context,FormAdherentActivity.class);
                startActivity(intent);
            }
        });


    }
}
