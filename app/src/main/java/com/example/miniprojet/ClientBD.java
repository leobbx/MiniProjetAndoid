package com.example.miniprojet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClientBD extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dechet.db";

    public final String SQL_CREATE = "CREATE TABLE dechet (id INTEGER PRIMARY KEY, nom VARCHAR(50)," +
            "  matiere VARCHAR(50), tmp int, description VARCHAR(500), biodeg BOOLEAN, nomPub VARCHAR(50)," +
            " prenomPub VARCHAR(50), emailPub VARCHAR(80))";
    public final String SQL_DATA = "INSERT INTO dechet(nom,matiere,tmp,description,biodeg) ";
    public final String SQL_DELETE = "DROP TABLE IF EXISTS dechet";

    public ClientBD(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
        db.execSQL(SQL_DATA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int ov, int nv) {
        db.execSQL(SQL_DELETE);
        onCreate(db);
    }
}
