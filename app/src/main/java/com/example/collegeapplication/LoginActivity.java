package com.example.collegeapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {


    EditText email,password;
    Button login,forget,author_login;
    FirebaseAuth College;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        College = FirebaseAuth.getInstance();
//        author_login = findViewById(R.id.author_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        forget = findViewById(R.id.buttonforgetpasswordd);
        College = College.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance("https://collegeapplication-bb0cf-default-rtdb.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference("College");
//        if(mAuth.getCurrentUser() != null)
//        {
//            startActivity(new Intent(login.this,ListView.class));
//        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stremail = email.getText().toString();
                String strpassword = password.getText().toString();
                String strid = databaseReference.push().getKey();
                College.signInWithEmailAndPassword(stremail,strpassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(email.getText().toString().equals(stremail) && password.getText().toString().equals(strpassword) ){
                                Intent i = new Intent(LoginActivity.this, Dashboard.class);
                                startActivity(i);
                            }
                            else{
                                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(LoginActivity.this);
                                dlgAlert.setMessage("wrong password or username");
                                dlgAlert.setTitle("Error Message...");
                                dlgAlert.setPositiveButton("OK", null);
                                dlgAlert.setCancelable(true);
                                dlgAlert.create().show();

                                dlgAlert.setPositiveButton("Ok",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        });
                            }
                        }
                });

            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this, Forget_password.class);
                startActivity(it);
            }
        });
//        author_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(LoginActivity.this, AuthorLogin.class);
//                startActivity(i);
//            }
//        });
    }
}