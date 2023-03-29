package com.example.miniprojet;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    private List<String> listeValeurs;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Affiche le Layout contenu dans le fichier xml "activity_add"
        setContentView(R.layout.activity_add);

        Spinner spin = (Spinner) findViewById(R.id.spin_matiere);
        String [] valeurs = getResources().getStringArray(R.array.valeurs);

        this.listeValeurs = new ArrayList<>();
        Collections.addAll(this.listeValeurs,valeurs);

        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,this.listeValeurs);
        spin.setAdapter(adapter);
    }
}
