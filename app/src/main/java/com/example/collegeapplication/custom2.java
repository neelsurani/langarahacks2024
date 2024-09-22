package com.example.collegeapplication;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class custom2 extends AppCompatActivity {
    ImageView image;
    TextView text;
    Button bybook,download,chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom2);
        text=findViewById(R.id.tv_data);
        image=findViewById(R.id.img_dp);
        download=findViewById(R.id.buy);
        chat=findViewById(R.id.chat);
        bybook=findViewById(R.id.payment);
        Intent intent =getIntent();
//        String data = intent.getStringExtra("listview");
        text.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image",0));
        bybook.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent i = new Intent(custom2.this,PriceActivity.class);
                startActivity(i);
            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(custom2.this,"Item is Download :"+text, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(custom2.this,DashboardFragment.class);
                startActivity(i);
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(custom2.this,ChatActivity.class);
                startActivity(in);
            }
        });
    }
}