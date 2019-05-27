package com.example.myrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<UpinIpin> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Upin Ipin");
        }
        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(UpinIpinData.getListData());
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list:
                showRecyclerList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                showRecyclerCardView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListAdapterUpinIpin listAdapterUpinIpin = new ListAdapterUpinIpin(this);
        listAdapterUpinIpin.setListUpinIpin(list);
        rvCategory.setAdapter(listAdapterUpinIpin);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedCharacter(list.get(position), position);
            }
        });
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridAdapterUpinIpin gridAdapterUpinIpin = new GridAdapterUpinIpin(this);
        gridAdapterUpinIpin.setListUpinIpin(list);
        rvCategory.setAdapter(gridAdapterUpinIpin);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedCharacter(list.get(position), position);
            }
        });
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapterUpinIpin cardViewAdapterUpinIpin = new CardViewAdapterUpinIpin(this);
        cardViewAdapterUpinIpin.setUpinIpinArrayList(list);
        rvCategory.setAdapter(cardViewAdapterUpinIpin);
    }

    private void showSelectedCharacter(UpinIpin upinIpin, int id) {
        Toast.makeText(this, "Kamu memilih " + upinIpin.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}