package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Creating app on device", Toast.LENGTH_LONG).show();
    }

    @Override

    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "Creating app on started", Toast.LENGTH_LONG).show();
    }

    @Override

    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "Creating app on screen", Toast.LENGTH_LONG).show();
    }

    @Override

    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "Creating app on paused", Toast.LENGTH_LONG).show();
    }

    @Override

    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "Creating app on stopped", Toast.LENGTH_LONG).show();
    }

    @Override

    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, "The app has been restarted", Toast.LENGTH_LONG).show();
    }
}
