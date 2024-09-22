package com.example.collegeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PriceActivity extends AppCompatActivity {

    Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        pay=findViewById(R.id.pay_amt);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(PriceActivity.this, "Payment Successful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(PriceActivity.this,nextpaymentpage.class);
            startActivity(i);
            }
        });

    }
}