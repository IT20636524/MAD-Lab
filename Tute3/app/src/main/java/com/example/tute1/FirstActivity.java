package com.example.tute1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    EditText et_number1,et_number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        et_number1=findViewById(R.id.et_number1);
        et_number2=findViewById(R.id.et_number2);
    }

    //navigation
    public void openSecond(View view){
        Intent intent = new Intent(this,SecondActivity.class);

        String num1 = et_number1.getText().toString();
        String num2 = et_number2.getText().toString();

        intent.putExtra("n1",num1);
        intent.putExtra("n2",num2);

        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.custom_toast_layout));

        //create toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setView(layout);
        toast.show();

        startActivity(intent);
    }
}