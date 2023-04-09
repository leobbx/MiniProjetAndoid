package com.example.miniprojet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        Button btn_Ajout = (Button) findViewById(R.id.btn_add);
        EditText txt_name = (EditText) findViewById(R.id.txt_nom);
        EditText txt_temps = (EditText) findViewById(R.id.txtnb_temps);
        RadioGroup rd_bio = (RadioGroup) findViewById(R.id.rd_degradable);
        EditText txt_description = (EditText) findViewById(R.id.txt_description);

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

        btn_Ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddActivity.this,LogActivity.class);
                intent.putExtra("nom",txt_name.getText().toString());
                intent.putExtra("matiere",spin.getSelectedItem().toString());
                intent.putExtra("temps",txt_temps.getText().toString());
                intent.putExtra("bio",rd_bio.getCheckedRadioButtonId());
                intent.putExtra("description",txt_description.getText().toString());
                startActivity(intent);
            }
        });
    }
}
