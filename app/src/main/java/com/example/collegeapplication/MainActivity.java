package com.example.collegeapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button signup,gotologin;
    FirebaseAuth College;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        gotologin = findViewById(R.id.gotologin);
        College = FirebaseAuth.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance("https://collegeapplication-bb0cf-default-rtdb.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference("college");

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stremail =  email.getText().toString();
                String strpassword =  password.getText().toString();


                College.createUserWithEmailAndPassword(stremail,strpassword).addOnCompleteListener(
                        MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {

                                    String id = College.getUid().toString();
                                    RegisterModel registerModel = new RegisterModel();
                                    registerModel.setId(id);
                                    registerModel.setEmail(stremail);
                                    registerModel.setPassword(strpassword);
                                    databaseReference.child(id).setValue(registerModel);
                                    Intent i = new Intent(MainActivity.this,LoginActivity.class);
                                    startActivity(i);
                                }
                            }
                        });
            }
        });
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}