package com.example.sdproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ElectronicsAdapter extends RecyclerView.Adapter<ElectronicsAdapter.ElectronicsViewHolder> {


    private static ClickListener clickListener;

    Context context;
    String[] electronics_name ,electronics_price;
    int[] images;

    public ElectronicsAdapter(Context context, String[] electronics_name, String[] electronics_price, int[] images) {
        this.context = context;
        this.electronics_name = electronics_name;
        this.electronics_price = electronics_price;
        this.images = images;
    }

    @NonNull
    @Override
    public ElectronicsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sampleelec_layout,viewGroup,false);

        return new ElectronicsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElectronicsViewHolder electronicsViewHolder, int i) {

        electronicsViewHolder.electronicsproduct.setText(electronics_name[i]);
        electronicsViewHolder.electronicsprice.setText(electronics_price[i]);
        electronicsViewHolder.electronicsimage.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        return electronics_name.length;
    }

    class ElectronicsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        TextView electronicsproduct ,electronicsprice;
        ImageView electronicsimage;

        public ElectronicsViewHolder(@NonNull View itemView) {
            super(itemView);

            electronicsproduct = itemView.findViewById(R.id.electronicsproducttextViewId);
            electronicsprice = itemView.findViewById(R.id.electronicspricetextViewId);
            electronicsimage = itemView.findViewById(R.id.electronicsimageViewId);

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
        ElectronicsAdapter.clickListener=clickListener;
    }


}
