package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {


    private CardView fashioncardview,electronicscardview,grocerycardview,sportscardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        this.setTitle("Category");

        fashioncardview = findViewById(R.id.fashion);
        electronicscardview = findViewById(R.id.electronics);
        sportscardview = findViewById(R.id.sports);
        grocerycardview = findViewById(R.id.grocery);

        fashioncardview.setOnClickListener(this);
        electronicscardview.setOnClickListener(this);
        sportscardview.setOnClickListener(this);
        grocerycardview.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.fashion)
        {
            Intent intent = new Intent(CategoryActivity.this,FashionActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.sports)
        {
            Intent intent = new Intent(CategoryActivity.this,SportsActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.grocery)
        {
            Intent intent = new Intent(CategoryActivity.this,GroceryActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.electronics)
        {
            Intent intent = new Intent(CategoryActivity.this,ElectronicsActivity.class);
            startActivity(intent);
        }

    }
}