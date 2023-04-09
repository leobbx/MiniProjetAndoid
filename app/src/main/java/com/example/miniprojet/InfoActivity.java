package com.example.miniprojet;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menu_deroulant,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.quit:
                System.exit(10);
                break;
            case R.id.ajout:
                Intent intent = new Intent(InfoActivity.this,AddActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView tv_nom = (TextView) findViewById(R.id.tv_dechet);
        TextView tv_matiere = (TextView) findViewById(R.id.tv_materiaux);
        TextView tv_tmp = (TextView) findViewById(R.id.tv_tps);
        TextView tv_desc = (TextView) findViewById(R.id.tv_description);
        TextView tv_bio = (TextView) findViewById(R.id.tv_biodeg);
        Button btn_retour = (Button) findViewById(R.id.btn_retour);

        tv_nom.setText(tv_nom.getText()+" "+getIntent().getStringExtra("nom"));
        tv_matiere.setText(tv_matiere.getText()+" "+getIntent().getStringExtra("matiere"));
        tv_tmp.setText(tv_tmp.getText()+" "+String.format("%d ans", getIntent().getIntExtra("tmp", 0)));
        tv_desc.setText(tv_desc.getText()+" "+getIntent().getStringExtra("description"));
        if(getIntent().getBooleanExtra("biodeg",false)){
            tv_bio.setText(R.string.oui);
        } else {
            tv_bio.setText(R.string.non);
        }

        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
