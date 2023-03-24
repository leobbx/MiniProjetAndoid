package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private List<String> valeurs = new ArrayList<String>();
    private AdapterPerso adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.adapter = new AdapterPerso(getApplicationContext(), valeurs);

        Button btn_ajout = (Button) findViewById(R.id.btn_Ajout);
        ListView lv_dechet = (ListView) findViewById(R.id.lv_dechet);

        lv_dechet.setAdapter(adapter);

        btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uniqueId = UUID.randomUUID().toString();
                valeurs.add(uniqueId);

                adapter.notifyDataSetChanged();
            }
        });
    }
}