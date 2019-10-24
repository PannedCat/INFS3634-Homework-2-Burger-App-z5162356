package com.example.infs3634individualassignment2burgerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager orderLayoutManager;
    private RecyclerView.Adapter orderAdapter;

    private int itemPosition;
    private int totalCost;

    private int[] imageList;

    private ArrayList<Order> orderList = new ArrayList<>();

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Your Orders");

        Intent orderIntent = getIntent();
        imageList = orderIntent.getIntArrayExtra("Image List");

        orderList = ItemDetailActivity.orderArrayList;
        totalCost = ItemDetailActivity.getTotalPrice();

        TextView totalPrice = findViewById(R.id.totalPriceText);


        totalPrice.setText(String.valueOf(totalCost));



        RecyclerView orderRecycleView = findViewById(R.id.orderRecyclerView);

        orderLayoutManager = new LinearLayoutManager(this);
        orderRecycleView.setLayoutManager(orderLayoutManager);

        orderAdapter = new OrderRecyclerAdapter(orderList, imageList);
        orderRecycleView.setAdapter(orderAdapter);

    }
}
