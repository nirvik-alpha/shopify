package com.example.sdproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.SportsViewHolder> {


    private static ClickListener clickListener;

    Context context;
    String[] sports_name ,sports_price;
    int[] images;

    public SportsAdapter(Context context, String[] sports_name, String[] sports_price, int[] images) {
        this.context = context;
        this.sports_name = sports_name;
        this.sports_price = sports_price;
        this.images = images;
    }

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.samplesp_layout,viewGroup,false);

        return new SportsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder sportsViewHolder, int i) {

        sportsViewHolder.sportsproduct.setText(sports_name[i]);
        sportsViewHolder.sportsprice.setText(sports_price[i]);
        sportsViewHolder.sportsimage.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        return sports_name.length;
    }

    class SportsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        TextView sportsproduct ,sportsprice;
        ImageView sportsimage;

        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);

            sportsproduct = itemView.findViewById(R.id.sportsproducttextViewId);
            sportsprice = itemView.findViewById(R.id.sportspricetextViewId);
            sportsimage = itemView.findViewById(R.id.sportsimageViewId);

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
        SportsAdapter.clickListener=clickListener;
    }


}
