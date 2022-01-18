package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ElectronicsActivity extends AppCompatActivity {

    int[] images = {
            R.drawable.mouse, R.drawable.keyboard, R.drawable.blutooth, R.drawable.headphone, R.drawable.webcam, R.drawable.mobile, R.drawable.powerbank, R.drawable.cctv, R.drawable.laptop, R.drawable.tripod,R.drawable.monitor
    };

    ElectronicsAdapter electronicsAdapter;

    String[] electronics_name,electronics_price;

    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);
        this.setTitle("Electronics");

        recyclerView = findViewById(R.id.recyclerViewelectronicsId);


        electronics_name = getResources().getStringArray(R.array.electronics_product_Name);
        electronics_price = getResources().getStringArray(R.array.electronics_product_price);

        electronicsAdapter = new ElectronicsAdapter(this,electronics_name,electronics_price,images);

        recyclerView.setAdapter(electronicsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        electronicsAdapter.setonItemClickListener(new ElectronicsAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Intent intent = new Intent(ElectronicsActivity.this,DetailelectronicsActivity.class);
                intent.putExtra("electro_name",electronics_name[position]);
                intent.putExtra("electro_price",electronics_price[position]);
                intent.putExtra("electro_image",images[position]);

                startActivity(intent);

            }

            @Override
            public void onItemLongClick(int position, View v) {
                Intent intent = new Intent(ElectronicsActivity.this,DetailelectronicsActivity.class);

                intent.putExtra("electro_name",electronics_name[position]);
                intent.putExtra("electro_price",electronics_price[position]);
                intent.putExtra("electro_image",images[position]);
                startActivity(intent);


            }
        });


    }
}