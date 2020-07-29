package com.fikri.footballapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fikri.footballapp.DetailActivity;
import com.fikri.footballapp.R;
import com.fikri.footballapp.model.Football;

import java.util.ArrayList;

public class ListFootballAdapter extends RecyclerView.Adapter<ListFootballAdapter.ListViewHolder> {
    private ArrayList<Football> listFootball;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback{
        void onItemClicked(Football data);
    }

    public ListFootballAdapter(ArrayList<Football> list){
        this.listFootball = list;
    }

    @NonNull
    @Override
    public ListFootballAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_football,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Football football =listFootball.get(position);

        Glide.with(holder.itemView.getContext())
                .load(football.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(football.getName());

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

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;

        public ListViewHolder(View view) {
            super(view);
            imgPhoto = view.findViewById(R.id.img_item);
            tvName = view.findViewById(R.id.tv_item_name);
        }
    }
}
