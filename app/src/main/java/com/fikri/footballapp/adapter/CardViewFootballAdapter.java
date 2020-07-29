package com.fikri.footballapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fikri.footballapp.Preferences;
import com.fikri.footballapp.R;
import com.fikri.footballapp.model.Football;

import java.util.ArrayList;

public class CardViewFootballAdapter extends RecyclerView.Adapter<CardViewFootballAdapter.CardViewHolder> {
    private ArrayList<Football> listFootball;
    private OnItemClickCallback onItemClickCallback;
    private OnBtnClickCallback onBtnClickCallback;

    public CardViewFootballAdapter(ArrayList<Football> list){
        this.listFootball = list;
    }

    public interface OnItemClickCallback{
        void onItemClicked(Football data);
    }

    public interface OnBtnClickCallback{
        void onBtnClicked(Football data);
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setOnBtnClickCallback(OnBtnClickCallback onBtnClickCallback) {
        this.onBtnClickCallback = onBtnClickCallback;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_football,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        Football football = listFootball.get(position);

        Glide.with(holder.itemView.getContext())
                .load(football.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(football.getName());

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBtnClickCallback.onBtnClicked(listFootball.get(holder.getAdapterPosition()));
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
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

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        Button btnShare;

        public CardViewHolder(View view) {
            super(view);
            imgPhoto = view.findViewById(R.id.img_item);
            tvName = view.findViewById(R.id.tv_item_name);
            btnShare = view.findViewById(R.id.btn_share);
        }
    }
}
