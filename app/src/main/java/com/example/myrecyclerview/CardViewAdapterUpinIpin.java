package com.example.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewAdapterUpinIpin extends RecyclerView.Adapter<CardViewAdapterUpinIpin.CardViewViewHolder> {
    private Context context;
    private ArrayList<UpinIpin> upinIpinArrayList;

    public CardViewAdapterUpinIpin(Context context) {
        this.context = context;
    }

    public ArrayList<UpinIpin> getUpinIpinArrayList() {
        return upinIpinArrayList;
    }

    public void setUpinIpinArrayList(ArrayList<UpinIpin> upinIpinArrayList) {
        this.upinIpinArrayList = upinIpinArrayList;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_upin_ipin, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, final int i) {
        UpinIpin upinIpin = getUpinIpinArrayList().get(i);

        cardViewViewHolder.tvName.setText(upinIpin.getName());
        cardViewViewHolder.tvRemarks.setText(upinIpin.getRemarks());

        Glide.with(context)
                .load(upinIpin.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite " + getUpinIpinArrayList().get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+ getUpinIpinArrayList().get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getUpinIpinArrayList().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}