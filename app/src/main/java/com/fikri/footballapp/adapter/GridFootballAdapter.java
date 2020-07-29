package com.fikri.footballapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fikri.footballapp.R;
import com.fikri.footballapp.model.Football;

import java.util.ArrayList;

public class GridFootballAdapter extends RecyclerView.Adapter<GridFootballAdapter.GridViewHolder> {
    private ArrayList<Football> listFootball;
    private OnItemClickCallback onItemClickCallback;

    public GridFootballAdapter(ArrayList<Football> list) {
        this.listFootball = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback{
        void onItemClicked(Football data);
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_football,parent,false);
       return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listFootball.get(position).getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listFootball.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFootball.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(View view) {
            super(view);
            imgPhoto = view.findViewById(R.id.img_item_photo);
        }
    }
}
