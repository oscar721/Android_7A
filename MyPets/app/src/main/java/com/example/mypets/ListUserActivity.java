package com.example.mypets;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity {

    //Array variable
    ArrayList<String> listUsers;
    //Adapter variable
    ArrayAdapter adapter;
    //GUI variables
    private ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        userList = findViewById(R.id.lvListUsers);
        listUsers = new ArrayList<>();

        viewUsers();

    }

    public void viewUsers(){
        //1. Connect with Database
        Database manager = new Database(this,"mypets",null,1);
        //2. Let write on DB
        SQLiteDatabase mypets = manager.getWritableDatabase();
        //3. Get information from database
        int idAdmin = 1;
        Cursor row = mypets.rawQuery("SELECT * FROM users",null);

        if(row.getCount() == 0){
            Toast.makeText(this,":::There isn't any user registered:::",Toast.LENGTH_SHORT).show();
        }else{
            while(row.moveToNext()){
                listUsers.add(row.getString(1));
                listUsers.add(row.getString(3));
            }
            adapter = new ArrayAdapter <>(this,android.R.layout.simple_expandable_list_item_1,listUsers);
            userList.setAdapter(adapter);
        }
    }
}
