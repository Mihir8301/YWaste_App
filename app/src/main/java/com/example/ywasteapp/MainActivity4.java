package com.example.ywasteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    EditText userid, password, repassword, name;
    Button signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        userid = (EditText) findViewById(R.id.editTextTextPersonName3);
        name = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPassword2);
        repassword = (EditText) findViewById(R.id.editTextTextPassword3);
        signup = (Button) findViewById(R.id.button4);
        DB = new DBHelper(this);
    }

    public void si(View v) {
        String user = userid.getText().toString();
        String uname = name.getText().toString();
        String pass = password.getText().toString();
        String repass = repassword.getText().toString();
        if (user.equals("") || pass.equals("") || uname.equals("") || repass.equals("")) {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        } else {
            if (pass.equals(repass)) {
                Boolean checkuser = DB.checkuserid(user);
                if (checkuser == false) {
                    Boolean insert = DB.insertData(user, uname, pass);
                    if (insert == true) {
                        Toast.makeText(this, "Successfully Sign UP", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MainActivity2.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Sign UP failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "User already exists!", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Password mismatch", Toast.LENGTH_SHORT).show();
            }
        }


    }

}