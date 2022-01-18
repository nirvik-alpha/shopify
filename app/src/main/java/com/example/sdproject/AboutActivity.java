package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("About");
        setContentView(R.layout.activity_about);
    }
}