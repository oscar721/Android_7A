package com.example.mypets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText user_namel, passwdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_namel =findViewById(R.id.txtUserLogin);
        passwdl = findViewById(R.id.txtPasswordLogin);
    }

    public void btnLogin (View view){
        //Connect to BD
        Database manager = new Database(this,"mypets",null,1);
        //Let write on DB
        //SQLiteDatabase mypets = manager.getWritableDatabase();
        SQLiteDatabase mypets = manager.getWritableDatabase();
        //Get values from IU
        String UNAME = user_namel.getText().toString();
        String PASSWD = passwdl.getText().toString();

        if (UNAME.isEmpty() || PASSWD.isEmpty()){
            Toast.makeText(this, "::: There are some empty fields :::", Toast.LENGTH_SHORT).show();
            user_namel.setError("");
            passwdl.setError("");
        }else{
            //Validate if user already exists
            Cursor row = mypets.rawQuery("SELECT * FROM users " + "WHERE email = ? AND password = ? LIMIT 1", new String[]{UNAME,PASSWD});

            if(row.getCount() > 0){
                Intent i = new Intent(this,ListUserActivity.class);
                startActivity(i);
            }else{
                Toast.makeText(this, "::: Invalid information :::", Toast.LENGTH_SHORT).show();
                user_namel.setError("");
                passwdl.setError("");
            }
        }
    }

    public void btnGotoRegisterUser (View view){
        Intent i= new Intent(this,RegisterUserActivity.class);
        startActivity(i);
    }
}
