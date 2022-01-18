package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DetailsportActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView1,textprice1 ,textquantity;
    private ImageView imageView1 ,imageView2, imageView3;
    private EditText sportname ,sportphone ;
    private Button sportbutton;

   DatabaseReference database;


    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsport);
        this.setTitle("Sports Detail");


        database = FirebaseDatabase.getInstance().getReference().child("Customers");

        textView1 = findViewById(R.id.detailsponametext);

        imageView1 = findViewById(R.id.detailspoimageview);
        textprice1 = findViewById(R.id.detailspopricetext);
        imageView2 = findViewById(R.id.plussign);
        imageView3 = findViewById(R.id.minussign);

        textquantity = findViewById(R.id.quantity);

        sportname =findViewById(R.id.sportordernameid);
        sportphone =findViewById(R.id.sportorderPhoneid);
        sportbutton =findViewById(R.id.sportorderbutton);

        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        sportbutton.setOnClickListener(this);

        String spname = getIntent().getStringExtra("sp_name");
        textView1.setText(spname);

        String spprice = getIntent().getStringExtra("sp_price");
        textprice1.setText(spprice);

        int spimage = getIntent().getIntExtra("sp_image",0);
        imageView1.setImageResource(spimage);



    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.plussign:
                count++;
                textquantity.setText("" + count);

                break;

            case R.id.minussign:

                if(count<=0)
                    count=0;
                else
                    count--;

                textquantity.setText("" + count);
                break;


            case R.id.sportorderbutton:

                orderdata();

                break;

        }


    }

    public void orderdata()
    {
        String phone = sportphone.getText().toString();
        String name = sportname.getText().toString();
        String product = textView1.getText().toString();
        String price = textprice1.getText().toString();
        String quantity = textquantity.getText().toString();

        Customers customers = new Customers(product,price,quantity,name,phone);

        database.push().setValue(customers);


        Toast.makeText(DetailsportActivity.this, " Added ", Toast.LENGTH_SHORT).show();

    }

}