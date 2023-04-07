package com.example.miniprojet;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        EditText nom = (EditText) findViewById(R.id.edit_txt_nom);
        EditText mail = (EditText) findViewById(R.id.edit_txt_mail);
        Button btn_retour = (Button) findViewById(R.id.btn_annl);
        Button btn_valider = (Button) findViewById(R.id.btn_valider);

        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClientBD bdd = new ClientBD(LogActivity.this);
                SQLiteDatabase db = bdd.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put("nom",getIntent().getStringExtra("nom"));
                values.put("matiere",getIntent().getStringExtra("matiere"));
                values.put("tmp",getIntent().getStringExtra("temps"));
                values.put("description",getIntent().getStringExtra("description"));

                if (getIntent().getIntExtra("bio",0)== R.id.rd_oui) {
                    values.put("biodeg",true);
                } else {
                    values.put("biodeg",false);
                }
                values.put("nomPub", String.valueOf(nom.getText()));
                values.put("emailPub",String.valueOf(mail.getText()));
                db.insert("dechet",null,values);

                Intent intent = new Intent(LogActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Ajout avec succés",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
