package com.example.lab2homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Intent backtoactivity;
    EditText height,weight,age;

    TextView tv_result;

    RadioGroup rg_buttons;

    Button calculate,menu;

    int male=1;
    int female=2;
    int gender=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        backtoactivity= new Intent(MainActivity2.this, MainActivity.class);

        height=findViewById(R.id.editTextNumber);
        weight=findViewById(R.id.editTextNumber2);
        age=findViewById(R.id.editTextNumber3);

        tv_result=findViewById(R.id.textView9);

        calculate=findViewById(R.id.button);
        menu=findViewById(R.id.button2);

        calculate.setOnClickListener(this);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        rg_buttons=findViewById(R.id.radiogroup);

        rg_buttons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i){
                    case R.id.radioButton:
                        gender=female;
                        break;
                    case R.id.radioButton2:
                        gender=male;
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {


        try {
            double n1,n2,n3,sum = 0;

            n1=Double.parseDouble(height.getText().toString());
            n2=Double.parseDouble(weight.getText().toString());
            n3=Double.parseDouble(age.getText().toString());

            if (gender!=0) {

                if (gender == 1) {
                    sum = (66.4730 + (13.7516 * n2) + (5.0033 * n1) - (6.7550 * n3));
                    tv_result.setText("Result: " + sum);
                    height.setText("");
                    weight.setText("");
                    age.setText("");
                    gender = 0;
                    sum = 0;
                }
                if (gender == 2) {
                    sum = (655.0955 + (9.5634 * n2) + (1.8496 * n1) - (4.8756 * n3));
                    tv_result.setText("Result: " + sum);
                    height.setText("");
                    weight.setText("");
                    age.setText("");
                    gender = 0;
                    sum = 0;
                } else {
                    Toast.makeText(this, "Invalid entry", Toast.LENGTH_SHORT).show();
                    return;
                }
            }else {
                Toast.makeText(this, "Choose Gender", Toast.LENGTH_SHORT).show();
            }


        } catch (NumberFormatException e) {
            Toast.makeText(this, "Fill the fields", Toast.LENGTH_SHORT).show();
        }



    }
}