package com.example.mypets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btnLogin (View view){
        Toast.makeText(this, "Empty data", Toast.LENGTH_SHORT).show();
    }

    public void btnGotoRegisterUser (View view){
        Intent i= new Intent(this,RegisterUserActivity.class);
        startActivity(i);
    }
}
