package com.example.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ExecutorService queue = Executors.newSingleThreadExecutor();
    private final static String KEY = "6498e268f2de120d0cd71288c41cbcc6";
    private final static String DOMAINT = "https://api.openweathermap.org/data/2.5/weather";
    private final static String IMGDOMAIN = "https://openweathermap.org/img/w/";
    //private final static String FORMAT = "https://api.openweathermap.org/data/2.5/weather?q=Cali,co&appid=6498e268f2de120d0cd71288c41cbcc6";

    private EditText txtSearch;
    private TextView lblCurrent, lblMin, lblMax , lblDescription;
    private ImageView imgWeather;

    private double lng = 0;//Lon
    private double lat = 0;//Lat



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSearch = findViewById(R.id.txtSearch);
        lblCurrent = findViewById(R.id.lblCurrent);
        lblMin = findViewById(R.id.lblMin);
        lblMax = findViewById(R.id.lblMax);
        lblDescription = findViewById(R.id.lblDescription);
        imgWeather = findViewById(R.id.imgWeather);
    }
}
