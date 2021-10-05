package com.example.ywasteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ywasteapp.ui.home.HomeFragment;

public class MainActivity2 extends AppCompatActivity {
    EditText userid, password;
    Button btnlogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        userid = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        btnlogin = (Button) findViewById(R.id.button3);
        DB = new DBHelper(this);
    }

    public void Su(View v) {
        Toast.makeText(this, "Sign-Up Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }

    public void goingNav(View v) {

        String user = userid.getText().toString();
        String pass = password.getText().toString();
        if (user.equals("") || pass.equals("")) {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        } else {
            Boolean checkuserpass = DB.checkuseridpassword(user, pass);
            if (checkuserpass == true) {
                Toast.makeText(this, "Successful Going To Home Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                intent.putExtra("keyname", user);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        }


    }


}
