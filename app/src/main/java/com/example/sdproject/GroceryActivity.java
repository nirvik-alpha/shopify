package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class GroceryActivity extends AppCompatActivity {

    int[] images = {
            R.drawable.chillpowder, R.drawable.danomilk, R.drawable.biscuit, R.drawable.drycake, R.drawable.rice, R.drawable.oil, R.drawable.maggi, R.drawable.wheelpowder, R.drawable.salt, R.drawable.pringles,R.drawable.turmeric
    };

    GroceryAdapter groceryAdapter;

    String[] grocery_name,grocery_price;

    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);
        this.setTitle("Grocery ");

        recyclerView = findViewById(R.id.recyclerViewgroceryId);


        grocery_name = getResources().getStringArray(R.array.grocery_product_Name);
        grocery_price = getResources().getStringArray(R.array.grocery_product_price);

        groceryAdapter = new GroceryAdapter(this,grocery_name,grocery_price,images);

        recyclerView.setAdapter(groceryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        groceryAdapter.setonItemClickListener(new GroceryAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(GroceryActivity.this,DetailActivity.class);
                intent.putExtra("grocery_name",grocery_name[position]);
                intent.putExtra("grocery_price",grocery_price[position]);
                intent.putExtra("grocery_image",images[position]);

                startActivity(intent);

            }

            @Override
            public void onItemLongClick(int position, View v) {

                Intent intent = new Intent(GroceryActivity.this,DetailActivity.class);
                intent.putExtra("grocery_name",grocery_name[position]);
                intent.putExtra("grocery_price",grocery_price[position]);
                intent.putExtra("grocery_image",images[position]);

                startActivity(intent);


            }
        });


    }
}