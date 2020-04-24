package com.example.colors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class Palette extends AppCompatActivity
    implements SeekBar.OnSeekBarChangeListener {


    //Variables
    private SeekBar vRed = null;
    private SeekBar vGreen = null;
    private SeekBar vBlue = null;
    private SeekBar vAlpha = null;
    private View vFilter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        //Code here....
        //Get components' id's

        vRed = findViewById(R.id.sbrRed);
        vGreen = findViewById(R.id.sbrGreen);
        vBlue = findViewById(R.id.sbrBlue);
        vAlpha = findViewById(R.id.sbrAlpha);
        vFilter = findViewById(R.id.vieColors);

        vRed.setOnSeekBarChangeListener(this);
        vGreen.setOnSeekBarChangeListener(this);
        vBlue.setOnSeekBarChangeListener(this);
        vAlpha.setOnSeekBarChangeListener(this);

        //Show the context menu WHEN I do along press in the component
        registerForContextMenu(vFilter);
    }

    //Show the options menu on the Device.

    //******************************************************
    // OPTIONS MENUS
    //******************************************************
    //Show the options menu on the Device.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Item actions.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.icHelp:
            Toast.makeText(this,"You've pressed Help",Toast.LENGTH_SHORT).show();
            break;

            case R.id.icTransparent:
                Toast.makeText(this,"You've pressed Transparent",Toast.LENGTH_SHORT).show();
                break;

            case R.id.iteTransparent:
                vAlpha.setProgress(0);
               // Toast.makeText(this, "This color id going to change",Toast.LENGTH_SHORT).show();
                break;

            case R.id.iteSemitransparent:
                vAlpha.setProgress(128);
                break;

            case R.id.iteOpaque:
                vAlpha.setProgress(255);
                break;

            case R.id.iteBlack:
                break;

            case R.id.iteWhite:
                break;

            case R.id.iteRed:
                vRed.setProgress(255);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;

            case R.id.iteGreen:
                vRed.setProgress(0);
                vGreen.setProgress(255);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;

            case R.id.iteBlue:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                break;

            case R.id.iteCyan:
                break;

            case R.id.iteMagenta:
                break;

            case R.id.iteYellow:
                break;

            case R.id.iteReset:
                break;

            case R.id.iteAboutof:
                //Go to About Of activity
                Intent intent = new Intent(this,AboutofActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //******************************************************
    // CONTEXT MENUS
    //******************************************************

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater2 = getMenuInflater();
        inflater2.inflate(R.menu.menu2,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.iteHelp:
                Toast.makeText(this,"You've pressed Help",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    //******************************************************
    //seekBAR MENUS
    //******************************************************

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean bo) {
        //1. Get SeekBar values
        int r = vRed.getProgress();
        int g = vGreen.getProgress();
        int b = vBlue.getProgress();
        int a = vAlpha.getProgress();

        //2. Convert values (in step 1) to ARGB function
        int filter_color = Color.argb(a,r,g,b);

        /*
        int filter_color = Color.argb(
        vAlpha.getProgress(),
        vRed.getProgress(),
        vGreen.getProgress(),
        vBlue.getProgress());
        */

        //3. Set the new color to Image (View)
        vFilter.setBackgroundColor(filter_color);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
