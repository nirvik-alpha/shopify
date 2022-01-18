package com.example.sdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<Customers> customersList;
    private CustomAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        this.setTitle("My order");
        listView = findViewById(R.id.listorder);


        databaseReference = FirebaseDatabase.getInstance().getReference("Customers");

        customersList = new ArrayList<>();

        customAdapter = new CustomAdapter(OrderActivity.this ,customersList);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.total_layout ,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.totalbuttonmenu)
        {
            Intent intent =new Intent(OrderActivity.this ,TotalActivity.class);
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                customersList.clear();

            for(DataSnapshot dataSnapshot :snapshot.getChildren())
            {
                Customers  customers = dataSnapshot.getValue(Customers.class);

                customersList.add(customers);
            }

            listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        super.onStart();
    }
}