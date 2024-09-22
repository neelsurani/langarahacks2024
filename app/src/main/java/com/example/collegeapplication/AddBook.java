package com.example.collegeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

public class AddBook extends AppCompatActivity {

    EditText BookT,AuthorN,BookP,Content;
    Button Add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        BookT = findViewById(R.id.BookT);
        AuthorN = findViewById(R.id.AuthorN);
        BookP = findViewById(R.id.BookP);
        Content = findViewById(R.id.Context);
        Add = findViewById(R.id.ADD);
    }
}