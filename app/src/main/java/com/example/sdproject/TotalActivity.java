package com.example.sdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class TotalActivity extends AppCompatActivity {


    private TextView mtotal;
    private DatabaseReference mDatabase;

    Button proceed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);


        proceed =findViewById(R.id.proceedid);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TotalActivity.this ,LocationActivity.class);
                startActivity(intent);
            }
        });


        mtotal = findViewById(R.id.totalamountid);

        mDatabase  = FirebaseDatabase.getInstance().getReference().child("Customers");



        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int sum=0;
                for(DataSnapshot ds : snapshot.getChildren())
                {
                    Map<String,Object> map = (Map<String,Object>) ds.getValue();

                    Object price = map.get("price");
                    Object quantity = map.get("quantity");

                    int pvalue = Integer.parseInt(String.valueOf(price));
                    int qvalue = Integer.parseInt(String.valueOf(quantity));

                    sum+=pvalue*qvalue;

                    mtotal.setText(String.valueOf(sum));


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}