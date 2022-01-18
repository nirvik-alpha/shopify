package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LocationActivity extends AppCompatActivity {

    EditText name ,division ,location ,mail, phone;
    Button orderbutt;
    ProgressDialog progressDialog;
    DatabaseReference database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);


        progressDialog = new ProgressDialog(LocationActivity.this);
        progressDialog.setTitle("Orders");
        progressDialog.setMessage("Ordering products...");

        database = FirebaseDatabase.getInstance().getReference().child("ShippingInfo");
        name = findViewById(R.id.personname);
        division = findViewById(R.id.divisionname);
        location =findViewById(R.id.locationname);
        mail = findViewById(R.id.emailname);
        phone = findViewById(R.id.phonename);
        orderbutt =findViewById(R.id.lastorder);

        orderbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                savedata();

            }
        });


    }

    public void savedata()
    {
        String pname = name.getText().toString();
        String pdivision = division.getText().toString();
        String plocation = location.getText().toString();
        String pmail = mail.getText().toString();
        String pphone = phone.getText().toString();


    Shipping shipping =new Shipping(pname,pdivision,plocation,pmail,pphone);
        database.push().setValue(shipping);

        Toast.makeText(LocationActivity.this, " completed orders ", Toast.LENGTH_SHORT).show();

    }
}