package com.example.sdproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {


    private static ClickListener clickListener;

    Context context;
    String[] grocery_name ,grocery_price;
    int[] images;

    public GroceryAdapter(Context context, String[] grocery_name, String[] grocery_price, int[] images) {
        this.context = context;
        this.grocery_name = grocery_name;
        this.grocery_price = grocery_price;
        this.images = images;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sampleg_layout,viewGroup,false);

        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder groceryViewHolder, int i) {

        groceryViewHolder.groceryproduct.setText(grocery_name[i]);
        groceryViewHolder.groceryprice.setText(grocery_price[i]);
        groceryViewHolder.groceryimage.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        return grocery_name.length;
    }

    class GroceryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        TextView groceryproduct ,groceryprice;
        ImageView groceryimage;

        public GroceryViewHolder(@NonNull View itemView) {
            super(itemView);

            groceryproduct = itemView.findViewById(R.id.groceryproducttextViewId);
            groceryprice = itemView.findViewById(R.id.grocerypricetextViewId);
            groceryimage = itemView.findViewById(R.id.groceryimageViewId);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View v) {

            clickListener.onItemClick(getAdapterPosition(),v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(),v);
            return false;
        }
    }


    public interface ClickListener{

        void onItemClick(int position ,View v);
        void onItemLongClick(int position ,View v);

    }

    public void setonItemClickListener(ClickListener clickListener)
    {
        GroceryAdapter.clickListener=clickListener;
    }


}
