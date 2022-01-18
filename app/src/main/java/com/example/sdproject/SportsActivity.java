package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SportsActivity extends AppCompatActivity {

    int[] sports_images = {
            R.drawable.football, R.drawable.headbadminton, R.drawable.helmet, R.drawable.basketball, R.drawable.carom, R.drawable.battingpad, R.drawable.cricketbat, R.drawable.keepinggloves, R.drawable.tennis, R.drawable.tennisbat,R.drawable.hockey
    };

    SportsAdapter sportsAdapter;

    String[] sports_name,sports_price;

    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        this.setTitle("Sports ");

        recyclerView = findViewById(R.id.recyclerViewsportsId);


        sports_name = getResources().getStringArray(R.array.sports_product_Name);
        sports_price = getResources().getStringArray(R.array.sports_product_price);


        sportsAdapter = new SportsAdapter(this,sports_name,sports_price,sports_images);

        recyclerView.setAdapter(sportsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sportsAdapter.setonItemClickListener(new SportsAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Intent intent = new Intent(SportsActivity.this,DetailsportActivity.class);
                intent.putExtra("sp_name",sports_name[position]);
                intent.putExtra("sp_price",sports_price[position]);
                intent.putExtra("sp_image",sports_images[position]);

                startActivity(intent);

            }

            @Override
            public void onItemLongClick(int position, View v) {

                Intent intent = new Intent(SportsActivity.this,DetailsportActivity.class);
                intent.putExtra("sp_name",sports_name[position]);
                intent.putExtra("sp_price",sports_price[position]);
                intent.putExtra("sp_image",sports_images[position]);

                startActivity(intent);

            }
        });


    }
}