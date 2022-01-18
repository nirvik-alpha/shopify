package com.example.sdproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FashionAdapter extends RecyclerView.Adapter<FashionAdapter.FashionViewHolder> {


    private static ClickListener clickListener;

    Context context;
    String[] fashion_name ,fashion_price;
    int[] images;

    public FashionAdapter(Context context, String[] fashion_name, String[] fashion_price, int[] images) {
        this.context = context;
        this.fashion_name = fashion_name;
        this.fashion_price = fashion_price;
        this.images = images;
    }

    @NonNull
    @Override
    public FashionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.samplef_layout,viewGroup,false);

        return new FashionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FashionViewHolder fashionViewHolder, int i) {

        fashionViewHolder.fashionproduct.setText(fashion_name[i]);
        fashionViewHolder.fashionprice.setText(fashion_price[i]);
        fashionViewHolder.fashionimage.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        return fashion_name.length;
    }

    class FashionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        TextView fashionproduct ,fashionprice;
        ImageView fashionimage;

        public FashionViewHolder(@NonNull View itemView) {
            super(itemView);

            fashionproduct = itemView.findViewById(R.id.producttextViewId);
            fashionprice = itemView.findViewById(R.id.pricetextViewId);
            fashionimage = itemView.findViewById(R.id.fashionimageViewId);

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
        FashionAdapter.clickListener=clickListener;
    }


}
