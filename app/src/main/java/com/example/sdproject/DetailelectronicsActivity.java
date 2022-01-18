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

public class DetailelectronicsActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView1,textprice1 ,textquantity;
    private ImageView imageView1 ,imageplus ,imageminus;
    private EditText electrophone ,electroname ;
    private Button electrobutton;

    DatabaseReference database;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailelectronics);
        this.setTitle("Electronics Detail");

        database = FirebaseDatabase.getInstance().getReference().child("Customers");

        imageView1 = findViewById(R.id.detailelectroimageview);
        imageplus = findViewById(R.id.elecplus);
        imageminus = findViewById(R.id.elecminus);

        textView1 = findViewById(R.id.detailelectronametext);
        textprice1 = findViewById(R.id.detailelectropricetext);
        textquantity = findViewById(R.id.elecquantity);
        electrophone = findViewById(R.id.electronicsPhone);
        electroname = findViewById(R.id.electronicstextname);

        electrobutton = findViewById(R.id.electronicsorderbtn);

        imageplus.setOnClickListener(this);
        imageminus.setOnClickListener(this);
        electrobutton.setOnClickListener(this);


        String electroname = getIntent().getStringExtra("electro_name");
        textView1.setText(electroname);

        String electroprice = getIntent().getStringExtra("electro_price");
        textprice1.setText(electroprice);

        int electroimage = getIntent().getIntExtra("electro_image",0);
        imageView1.setImageResource(electroimage);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.elecplus:
                count++;
                textquantity.setText("" + count);

                break;

            case R.id.elecminus:

                if(count<=0)
                    count=0;
                else
                    count--;

                textquantity.setText("" + count);
                break;

            case R.id.electronicsorderbtn:

                orderdata();
                break;


        }


    }

    private void orderdata() {
        String phone = electrophone.getText().toString();
        String name = electroname.getText().toString();
        String product = textView1.getText().toString();
        String price = textprice1.getText().toString();
        String quantity = textquantity.getText().toString();

        Customers customers = new Customers(product,price,quantity,name,phone);

        database.push().setValue(customers);


        Toast.makeText(DetailelectronicsActivity.this, " Added  ", Toast.LENGTH_SHORT).show();

    }
}