package com.example.mypets;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase mypets) {
        //Create Users table
        mypets.execSQL("CREATE TABLE users (" +
                "id integer primary key autoincrement not null," +
                "email text unique not null," +
                "password text not null," +
                "firtsname text," +
                "lastname," +
                "mobilen text)"
        );
        mypets.execSQL("CREATE TABLE pets (" +
                "id integer primary key autoincrement not null," +
                "name text not null," +
                "age text," +
                "gender text," +
                "race text)"
        );
        mypets.execSQL("INSERT INTO users (email,password)" +
                "VALUES ('admin','12345')");
        mypets.execSQL("INSERT INTO users (email,password,firtsname,lastname,mobile)" +
                "VALUES ('Peter','1234567','Peter','McDonald','3000567777')");
        mypets.execSQL("INSERT INTO pets (name,age,gender,race)" +
                "VALUES ('Luna','2','Female','None')");
        mypets.execSQL("INSERT INTO pets (name,age,gender,race)" +
                "VALUES ('Lulu','5','Female','None')");
        mypets.execSQL("INSERT INTO pets (name,age,gender,race)" +
                "VALUES ('Pow','3','Male','None')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase mypets, int oldVersion, int newVersion) {

        mypets.execSQL("CREATE TABLE pets (" +
                "id integer primary key autoincrement not null," +
                "name text not null," +
                "age text," +
                "gender text," +
                "race text)"
        );
        mypets.execSQL("INSERT INTO pets (name,age,gender,race)" +
                "VALUES ('Luna','2','Female','None')");
        mypets.execSQL("INSERT INTO pets (name,age,gender,race)" +
                "VALUES ('Lulu','5','Female','None')");
        mypets.execSQL("INSERT INTO pets (name,age,gender,race)" +
                "VALUES ('Pow','3','Male','None')");
    }

}
