package com.example.tute1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tute1.Database.DBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et_username,et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
    }

    public void AddData(View view){
        DBHelper dbHelper = new DBHelper(this);

        long val = dbHelper.addInfo(et_username.getText().toString(),et_password.getText().toString());

        if(val>0){
            Toast.makeText(this,"Data successfully inserted",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Data not inserted",Toast.LENGTH_SHORT).show();
        }
    }

    public void viewall(View view){
        DBHelper dbHelper = new DBHelper(this);

        List usernames = dbHelper.readAllInfo("username");
        Toast.makeText(this,usernames.toString(),Toast.LENGTH_SHORT).show();
    }

    public void DeleteData(View view){
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.deleteInfo(et_username.getText().toString());
        Toast.makeText(this,et_username.getText().toString()+ " Deleted successfully", Toast.LENGTH_SHORT).show();
    }

    public void UpdateData(View view){
        DBHelper dbHelper = new DBHelper(this);

        int val = dbHelper.updateInfo(et_username.getText().toString(),et_password.getText().toString());

        if(val>0){
            Toast.makeText(this,"Data updated successfully",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Data not updated",Toast.LENGTH_SHORT).show();
        }
    }

    public void  SignIn(View view){
        DBHelper dbHelper = new DBHelper(this);

        List usernames = dbHelper.readAllInfo("username");
        List passwords = dbHelper.readAllInfo("password");

        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        if(usernames.indexOf(username)>=0){
            if(passwords.get(usernames.indexOf(username)).equals(password)){
                Toast.makeText(this,"SignIn successfully",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"SignIn failed",Toast.LENGTH_SHORT).show();
            }
        }
    }



}