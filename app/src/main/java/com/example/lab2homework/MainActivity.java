package com.example.lab2homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp_formula;

    String[] allformulas={"Formula","Harris-Benedict Equation","Oxford (Most Reliable)"};

    ArrayAdapter adapter;

    Intent newactivity,newactivity2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_formula=findViewById(R.id.spinner);

        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,allformulas);

        sp_formula.setAdapter(adapter);

        newactivity= new Intent(MainActivity.this, MainActivity2.class);
        newactivity2= new Intent(MainActivity.this, MainActivity3.class);

        sp_formula.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {


                if (position==1){
                    sp_formula.setSelection(0);
                    startActivity(newactivity);
                } else if (position==2) {
                    sp_formula.setSelection(0);
                    startActivity(newactivity2);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });


    }
}