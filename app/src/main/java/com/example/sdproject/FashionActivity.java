package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FashionActivity extends AppCompatActivity {

    int[] images = {
            R.drawable.jacket1, R.drawable.watch, R.drawable.wallet, R.drawable.hoodie, R.drawable.pant, R.drawable.sneakershoe, R.drawable.shirtcasual, R.drawable.tshirtred, R.drawable.sharee, R.drawable.perfume,R.drawable.womenbag
    };

    FashionAdapter fashionAdapter;

    String[] fashion_name,fashion_price;

    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);
        this.setTitle("Fashion ");

        recyclerView = findViewById(R.id.recyclerViewId);


        fashion_name = getResources().getStringArray(R.array.product_Name);
        fashion_price = getResources().getStringArray(R.array.product_price);

        fashionAdapter = new FashionAdapter(this,fashion_name,fashion_price,images);

        recyclerView.setAdapter(fashionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fashionAdapter.setonItemClickListener(new FashionAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(FashionActivity.this,DetailfashionActivity.class);

                intent.putExtra("fashion_name",fashion_name[position]);
                intent.putExtra("fashion_price",fashion_price[position]);
                intent.putExtra("fashion_image",images[position]);

                startActivity(intent);

            }

            @Override
            public void onItemLongClick(int position, View v) {

                Intent intent = new Intent(FashionActivity.this,DetailfashionActivity.class);
                intent.putExtra("fashion_name",fashion_name[position]);
                intent.putExtra("fashion_price",fashion_price[position]);
                intent.putExtra("fashion_image",images[position]);

                startActivity(intent);

            }
        });


    }
}