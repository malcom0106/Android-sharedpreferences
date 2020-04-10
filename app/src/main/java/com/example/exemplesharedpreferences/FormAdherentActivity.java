package com.example.exemplesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.exemplesharedpreferences.Entities.Adherent;
import com.example.exemplesharedpreferences.Utilities.Constantes;
import com.example.exemplesharedpreferences.Utilities.Fonctions;
import com.google.gson.Gson;

public class FormAdherentActivity extends AppCompatActivity {
    Context _context;

    //On declare les widgets utilisés ici
    EditText txtNom;
    EditText txtPrenom ;
    EditText txtEmail;
    EditText txtTelephone;
    CheckBox cbxSeSouvenir;
    Button btnValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_adherent);
        _context = this;
        //On initialise les Widgets
        initWidget();

        //On click sur Button Valider
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = txtNom.getText().toString().trim();
                String prenom = txtPrenom.getText().toString().trim();
                String telephone = txtTelephone.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();

                Adherent adherent = new Adherent();
                adherent.setNom(nom);
                adherent.setPrenom(prenom);
                adherent.setTelephone(telephone);
                adherent.setEmail(email);

                if(cbxSeSouvenir.isChecked()){
                    Gson gson = new Gson();
                    String adherentJson = gson.toJson(adherent);
                    Fonctions.insertSharedPreference(_context, Constantes.ADHERENT_SHARED,adherentJson);
                }

                Intent intent = new Intent(_context,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void initWidget(){
        txtNom = findViewById(R.id.txtNom);
        txtPrenom = findViewById(R.id.txtPrenom);
        txtEmail = findViewById(R.id.txtMail);
        txtTelephone = findViewById(R.id.txtTelephone);
        cbxSeSouvenir = findViewById(R.id.cbxSeSouvenir);
        btnValider = findViewById(R.id.btnValider);
    }
}
