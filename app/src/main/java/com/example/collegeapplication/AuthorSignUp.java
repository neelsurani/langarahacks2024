package com.example.collegeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthorSignUp extends AppCompatActivity {

    EditText email, password;
    Button signup,gotologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_sign_up);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        gotologin = findViewById(R.id.gotologin);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stremail =  email.getText().toString();
                String strpassword =  password.getText().toString();

                Intent i = new Intent(AuthorSignUp.this, Dashboard.class);
                startActivity(i);
            }
        });
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AuthorSignUp.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}