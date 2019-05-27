package com.example.myrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private TextView nama_panggilan, umur, asal_negara, nama_karakter, caption;
    private ImageView photo;
    private ArrayList<UpinIpin> list;

    public ArrayList<UpinIpin> getList() {
        return list;
    }

    public void setList(ArrayList<UpinIpin> list) {
        this.list = list;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Upin Ipin");
        }

        list = new ArrayList<UpinIpin>();
        list.addAll(UpinIpinData.getListData());

        nama_karakter = findViewById(R.id.tv_item_name);
        caption = findViewById(R.id.tv_item_remarks);
        nama_panggilan = findViewById(R.id.nama_panggilan);
        umur = findViewById(R.id.umur);
        asal_negara = findViewById(R.id.asal_negara);
        photo = findViewById(R.id.img_item_photo);

        int id = getIntent().getIntExtra("id", 0);

        nama_karakter.setText(list.get(id).getName());
        caption.setText(list.get(id).getRemarks());
        nama_panggilan.setText("Nama Panggilan: "+list.get(id).getNama_panggilan());
        umur.setText("Umur: "+list.get(id).getUmur());
        asal_negara.setText("Asal Negara: "+list.get(id).getAsal_negara());

        Glide.with(this)
                .load(getList().get(id).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(photo);
    }
}