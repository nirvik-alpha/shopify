package com.example.sdproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Customers> {

    private Activity context;
    private int totalprice=0;

    private List<Customers> customerlist;


    public CustomAdapter(Activity context,  List<Customers> customerlist) {
        super(context, R.layout.sampleorder_layout, customerlist);
        this.context = context;
        this.customerlist = customerlist;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
       View view =  layoutInflater.inflate(R.layout.sampleorder_layout,null ,true );

       Customers customers = customerlist.get(position);

        TextView t1 = view.findViewById(R.id.listproductname);
        TextView t2 = view.findViewById(R.id.listprice);
        TextView t3 = view.findViewById(R.id.listquantity);

        t1.setText("Product: "+customers.getProduct());
        t2.setText("Price: "+customers.getPrice());
        t3.setText("Quantity: "+customers.getQuantity());




        return view;
    }
}
