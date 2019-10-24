package com.example.infs3634individualassignment2burgerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager productLayoutManager;
    private RecyclerView.Adapter productAdapter;

    private ArrayList<Product> productArrayList = new ArrayList<>();
    private ArrayList<Order> orderList = new ArrayList<>();

    // Creating an array of Images that will be passed between activities through intents
    private int[] imageList = new int[]{R.drawable.doublecheeseburger, R.drawable.fries, R.drawable.csalad,
            R.drawable.soda, R.drawable.refriedbeans, R.drawable.tbone, R.drawable.chocolatesundae, R.drawable.bratwurst,
            R.drawable.pineapplepie, R.drawable.chocopie, R.drawable.ginger, R.drawable.pancakes, R.drawable.water, R.drawable.clownhat,
            R.drawable.toffee};

    private ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Our Menu");

        RecyclerView productRecycleView = findViewById(R.id.productRecyclerView);
        Button viewOrderButton = findViewById(R.id.viewOrderButton);

        productLayoutManager = new LinearLayoutManager(this);
        productRecycleView.setLayoutManager(productLayoutManager);

        productAdapter = new ProductRecyclerAdapter(ProductDataBase.setProductList(productArrayList), imageList);
        productRecycleView.setAdapter(productAdapter);

        viewOrderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewOrderIntent = new Intent(v.getContext(), OrderActivity.class);
                viewOrderIntent.putExtra("Image List", imageList);
                v.getContext().startActivity(viewOrderIntent);
            }
        });

    }



}
