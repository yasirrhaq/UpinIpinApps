package com.example.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Objects;

public class GridAdapterUpinIpin extends RecyclerView.Adapter<GridAdapterUpinIpin.GridViewHolder> {
    private Context context;
    private ArrayList<UpinIpin> listUpinIpin;

    public GridAdapterUpinIpin(Context context) {
        this.context = context;
    }

    public ArrayList<UpinIpin> getListUpinIpin() {
        return listUpinIpin;
    }

    public void setListUpinIpin(ArrayList<UpinIpin> listUpinIpin) {
        this.listUpinIpin = listUpinIpin;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_upin_ipin, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        Glide.with(context)
                .load(getListUpinIpin().get(i).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(gridViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListUpinIpin().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}