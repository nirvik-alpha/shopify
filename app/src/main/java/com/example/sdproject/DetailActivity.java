package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView  ,textprice ,textquantity;
    private ImageView imageView ,imageplus ,imageminus;
    private EditText grophone ,groname;
    private Button grobutton;

    DatabaseReference database;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.setTitle("Grocery Detail");


        database = FirebaseDatabase.getInstance().getReference().child("Customers");
        imageView = findViewById(R.id.detailimageview);
        imageplus =findViewById(R.id.groplus);
        imageminus = findViewById(R.id.grominus);

        textView = findViewById(R.id.detailnametext);
        textprice = findViewById(R.id.detailpricetext);
        textquantity=findViewById(R.id.groquantity);
        grophone = findViewById(R.id.grophone);
        groname = findViewById(R.id.gropersonname);
        grobutton = findViewById(R.id.grobutton);


        imageplus.setOnClickListener(this);
        imageminus.setOnClickListener(this);
        grobutton.setOnClickListener(this);




        String groceryname = getIntent().getStringExtra("grocery_name");
        textView.setText(groceryname);

        String groceryprice = getIntent().getStringExtra("grocery_price");
        textprice.setText(groceryprice);

        int groceryimage = getIntent().getIntExtra("grocery_image",0);
        imageView.setImageResource(groceryimage);







    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.groplus:
                count++;
                textquantity.setText("" + count);

                break;

            case R.id.grominus:

                if(count<=0)
                    count=0;
                else
                    count--;

                textquantity.setText("" + count);
                break;

            case R.id.grobutton:

                orderdata();
                break;



        }



    }

    private void orderdata() {
        String phone = grophone.getText().toString();
        String name = groname.getText().toString();
        String product = textView.getText().toString();
        String price = textprice.getText().toString();
        String quantity = textquantity.getText().toString();

        Customers customers = new Customers(product,price,quantity,name,phone);

        database.push().setValue(customers);


        Toast.makeText(DetailActivity.this, " Added ", Toast.LENGTH_SHORT).show();


    }
}