package com.example.tute1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText et_number1,et_number2;
    TextView tv_answer;

    String number1,number2;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et_number1=findViewById(R.id.et_number1);
        et_number2=findViewById(R.id.et_number2);
        tv_answer=findViewById(R.id.tv_answer);

        Intent intent = getIntent();
        number1=intent.getStringExtra("n1");
        number2=intent.getStringExtra("n2");

        et_number1.setText(number1);
        et_number2.setText(number2);

        num1=Integer.parseInt(number1);
        num2=Integer.parseInt(number2);

    }
    public void add(View view){
        tv_answer.setText(number1+"+"+number2+"="+(num1+num2));
    }
    public void substract(View view){
        tv_answer.setText(number1+"-"+number2+"="+(num1-num2));
    }
    public void multiply(View view){
        tv_answer.setText(number1+"*"+number2+"="+(num1*num2));
    }
    public void divide(View view){
        tv_answer.setText(number1+"/"+number2+"="+(num1/num2));
    }
}