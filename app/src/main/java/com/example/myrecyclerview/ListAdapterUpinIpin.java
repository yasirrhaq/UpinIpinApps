package com.example.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListAdapterUpinIpin extends RecyclerView.Adapter<ListAdapterUpinIpin.CategoryViewHolder> {

    private Context context;
    private ArrayList<UpinIpin> listUpinIpin;

    public ListAdapterUpinIpin(Context context) {
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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_upin_ipin, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvName.setText(getListUpinIpin().get(i).getName());
        categoryViewHolder.tvRemarks.setText(getListUpinIpin().get(i).getRemarks());

        Glide.with(context)
                .load(getListUpinIpin().get(i).getPhoto())
                .apply(new RequestOptions().circleCropTransform())
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListUpinIpin().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}