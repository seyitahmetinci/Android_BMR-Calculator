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

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_main3);

        backtoactivity= new Intent(MainActivity3.this, MainActivity.class);

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


        rg_buttons=findViewById(R.id.radioGroup);

        rg_buttons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                switch (i){
                    case R.id.radioButton3:
                        gender=female;
                        break;
                    case R.id.radioButton4:
                        gender=male;
                        break;
                }

            }
        });
    }

    @Override
    public void onClick(View view) {

        try {


            double n1, n2, n3, sum = 0;

            n1 = Double.parseDouble(height.getText().toString());
            n2 = Double.parseDouble(weight.getText().toString());
            n3 = Double.parseDouble(age.getText().toString());

            if (gender!=0) {

                if (gender == 1) {
                    if (n3 >= 0 && n3 <= 3) {
                        sum = 61.0 * n2 - 33.7;
                        tv_result.setText("Result: " + sum);
                    } else if (n3 >= 3 && n3 <= 10) {
                        sum = 23.3 * n2 + 514;
                        tv_result.setText("Result: " + sum);
                    } else if (n3 >= 10 && n3 <= 18) {
                        sum = 18.4 * n2 + 581;
                        tv_result.setText("Result: " + sum);
                    } else if (n3 >= 18 && n3 <= 30) {
                        sum = 16.0 * n2 + 545;
                        tv_result.setText("Result: " + sum);
                    } else if (n3 >= 30 && n3 <= 60) {
                        sum = 14.2 * n2 + 593;
                        tv_result.setText("Result: " + sum);
                    } else if (n3 > 60) {
                        sum = 13.5 * n2 + 514;
                        tv_result.setText("Result: " + sum);
                    }

                } else if (gender == 2) {

                    if (n3 >= 0 && n3 <= 3) {
                        sum = 58.9 * n2 - 23.1;
                        tv_result.setText("Result: " + sum);
                    } else if (n3 >= 3 && n3 <= 10) {
                        sum = 20.1 * n2 + 507;
                        tv_result.setText("Result: " + sum);
                    } else if (n3 >= 10 && n3 <= 18) {
                        sum = 11.1 * n2 + 761;
                        tv_result.setText("Result: " + sum);
                    } else if (n3 >= 18 && n3 <= 30) {
                        sum = 13.1 * n2 + 558;
                        tv_result.setText("Result: " + sum);
                    } else if (n3 >= 30 && n3 <= 60) {
                        sum = 9.74 * n2 + 694;
                        tv_result.setText("Result: " + sum);
                    } else if (n3 > 60) {
                        sum = 10.1 * n2 + 569;
                        tv_result.setText("Result: " + sum);
                    }


                }
            }else {
                Toast.makeText(this, "Choose Gender", Toast.LENGTH_SHORT).show();
            }

        } catch (NumberFormatException e){
            Toast.makeText(this, "Fill the fields", Toast.LENGTH_SHORT).show();
        }

    }
}

