package com.myGame.thunder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBUtils extends SQLiteOpenHelper {

    public DBUtils(Context context, String name, int version) {
        super(context, name, null, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("CREATE TABLE data (top_score INTEGER,name varchar(255));");
        db.execSQL("INSERT INTO data (top_score) VALUES (0);");
        //	db.execSQL("INSERT INTO data (name) VALUES ();");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
