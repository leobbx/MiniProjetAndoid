package com.example.miniprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private List<Dechet> valeurs = new ArrayList<Dechet>();
    private AdapterPerso adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClientBD bdd = new ClientBD(this);

        SQLiteDatabase bd = bdd.getReadableDatabase();

        String[] col = {"nom","matiere","tmp","description","biodeg"};
        String[] select = {};

        Cursor cur = bd.query("dechet",col,"",select,null,null,"nom ASC");

        if(cur.moveToFirst()){
            do{
                valeurs.add(new Dechet(cur.getString(cur.getColumnIndexOrThrow("nom")),
                        cur.getString(cur.getColumnIndexOrThrow("matiere")),
                        cur.getInt(cur.getColumnIndexOrThrow("tmp")),
                        cur.getString(cur.getColumnIndexOrThrow("description")),
                        cur.getInt(cur.getColumnIndexOrThrow("biodeg"))
                ));
            } while (cur.moveToNext());
        }

        cur.close();
        bd.close();

        this.adapter = new AdapterPerso(getApplicationContext(), valeurs);

        Button btn_ajout = (Button) findViewById(R.id.btn_Ajout);
        ListView lv_dechet = (ListView) findViewById(R.id.lv_dechet);

        lv_dechet.setAdapter(adapter);

        btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });

        lv_dechet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                intent.putExtra("nom",valeurs.get(pos).getNom());
                intent.putExtra("matiere",valeurs.get(pos).getMatiere());
                intent.putExtra("tmp",valeurs.get(pos).getTmp());
                intent.putExtra("description",valeurs.get(pos).getDescription());
                intent.putExtra("biodeg",valeurs.get(pos).getBio());
                startActivity(intent);
            }
        });
    }
}