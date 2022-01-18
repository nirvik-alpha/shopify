package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailfashionActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView1,textprice1 ,textquantity;
    private ImageView imageView1 ,imageplus ,imageminus;
    private Button fashbutton;
    private EditText fashphone ,fashname;

    DatabaseReference database;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailfashion);
        this.setTitle("Fashion Detail");

        database = FirebaseDatabase.getInstance().getReference().child("Customers");

        imageView1 = findViewById(R.id.detailfashimageview);
        imageplus =findViewById(R.id.fashplus);
        imageminus =findViewById(R.id.fashminus);

        textView1 = findViewById(R.id.detailfashnametext);
        textprice1 = findViewById(R.id.detailfashpricetext);
        textquantity = findViewById(R.id.fashquantity);
        fashphone = findViewById(R.id.fashionphone);
        fashname = findViewById(R.id.fashionpersonname);
        fashbutton = findViewById(R.id.fashionbutton);

        imageplus.setOnClickListener(this);
        imageminus.setOnClickListener(this);
        fashbutton.setOnClickListener(this);


        String fashname = getIntent().getStringExtra("fashion_name");
        textView1.setText(fashname);

        String fashprice = getIntent().getStringExtra("fashion_price");
        textprice1.setText(fashprice);

        int fashimage = getIntent().getIntExtra("fashion_image",0);
        imageView1.setImageResource(fashimage);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.fashplus:
                count++;
                textquantity.setText("" + count);

                break;

            case R.id.fashminus:

                if(count<=0)
                    count=0;
                else
                    count--;

                textquantity.setText("" + count);
                break;

            case R.id.fashionbutton:

                orderdata();
                break;


        }



    }

    private void orderdata() {

        String phone = fashphone.getText().toString();
        String name = fashname.getText().toString();
        String product = textView1.getText().toString();
        String price = textprice1.getText().toString();
        String quantity = textquantity.getText().toString();

        Customers customers = new Customers(product,price,quantity,name,phone);

        database.push().setValue(customers);


        Toast.makeText(DetailfashionActivity.this, " Added  ", Toast.LENGTH_SHORT).show();


    }
}