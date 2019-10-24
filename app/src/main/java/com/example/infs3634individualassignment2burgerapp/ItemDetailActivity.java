package com.example.infs3634individualassignment2burgerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemDetailActivity extends AppCompatActivity {

    private int orderSize = 0;
    private int productCost = 0;
    // creating an integer that records total order price that will be incremented through the pressing of the Add Order Button
    private static int totalPrice = 0;

    private ArrayList<Product> productArrayList = new ArrayList<>();

    public static ArrayList<Order> orderArrayList = new ArrayList<>();

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // setting Toolbar to a specific name
        toolbar = getSupportActionBar();
        toolbar.setTitle("Food Details");

        Intent itemDetail = getIntent();
        Bundle bundle = itemDetail.getExtras();
        final int itemPosition = bundle.getInt("Position",0);

        int[] imageList = bundle.getIntArray("Image List");

        // Getting an arrayList of Product Objects to display in this activity based on clicked position from the
        // previous activity - MainActivity - > ItemDetailActivity
        final ArrayList<Product> productList = ProductDataBase.setProductList(productArrayList);

        productCost = productList.get(itemPosition).getCost();

        ImageView productImage = findViewById(R.id.productImage);

        Button addButton = findViewById(R.id.increaseOrder);
        Button minusButton = findViewById(R.id.decreaseOrder);
        Button addOrderButton = findViewById(R.id.addOrder);

        TextView costView = findViewById(R.id.totalCostText);
        TextView productName = findViewById(R.id.productName);

        final TextView productDescription = findViewById(R.id.productDescrip);
        final TextView orderAmount = findViewById(R.id.orderItemAmount);
        final TextView orderCost = findViewById(R.id.itemTotalCost);

        //Setting image based on previous click position as passed through by intent
        productImage.setImageResource(imageList[itemPosition]);

        // setting CostView to a string
        costView.setText(R.string.unitcost);

        productName.setText(productList.get(itemPosition).getName());
        productDescription.setText(productList.get(itemPosition).getDescription());
        orderAmount.setText(String.valueOf(orderSize));
        orderCost.setText("$" + String.valueOf(productCost));

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                orderSize++;
                orderAmount.setText(String.valueOf(orderSize));

            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (orderSize > 0) {
                    orderSize--;
                    orderAmount.setText(String.valueOf(orderSize));
                }

            }
        });

        addOrderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (orderSize > 0) {
                    orderArrayList.add(new Order(orderSize, productList.get(itemPosition).getName(), productCost * orderSize, itemPosition));
                    //Toasting to show order confirmation
                    Toast toast = Toast.makeText(v.getContext(), R.string.orderconfirm, Toast.LENGTH_SHORT);
                    toast.show();
                    // Incrementing the Total Price variable every time an order is confirmed
                    totalPrice = totalPrice + productCost * orderSize;
                    orderSize = 0;
                    orderAmount.setText(String.valueOf(orderSize));
                }
            }
        });




    }
// method allowing access to the Total Order Price
    public static int getTotalPrice() {
        return totalPrice;
    }
}
