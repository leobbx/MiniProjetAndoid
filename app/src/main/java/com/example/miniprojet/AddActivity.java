package com.example.miniprojet;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        Button btn_annuler = (Button) findViewById(R.id.btn_annuler);

        this.listeValeurs = new ArrayList<>();
        Collections.addAll(this.listeValeurs,valeurs);

        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,this.listeValeurs);
        spin.setAdapter(adapter);

        btn_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
