package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // definición de variables
    private EditText edit1,edit2;
    private Button btn, btn2;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    private String a;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creacion de las variables
        edit1 = (EditText) findViewById(R.id.editProduct);
        edit2 = (EditText) findViewById(R.id.editQuantity);
        btn = (Button) findViewById(R.id.add);
        btn2 = (Button) findViewById(R.id.buy);
        list = (ListView) findViewById(R.id.ListP);

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a = edit1.getText().toString() + "\n" + edit2.getText().toString();
                arrayList.add(a);
                adapter.notifyDataSetChanged();
                edit1.setText("");
                edit2.setText("");

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText("");
                edit2.setText("");
                adapter.clear();
            }
        });


    }
}
