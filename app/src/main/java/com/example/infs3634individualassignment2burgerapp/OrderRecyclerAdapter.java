package com.example.infs3634individualassignment2burgerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderRecyclerAdapter extends RecyclerView.Adapter <OrderRecyclerAdapter.OrderViewHolder>{

    private ArrayList<Order> orderArrayList = new ArrayList<>();
    private int[] imageList;

    public static class OrderViewHolder extends RecyclerView.ViewHolder{
        public TextView orderName;
        public TextView orderTotalPrice;
        public TextView orderAmount;

        public ImageView orderImage;


        public OrderViewHolder(@NonNull View v) {
            super(v);
            orderName = v.findViewById(R.id.orderitemName);
            orderTotalPrice = v.findViewById(R.id.itemTotalCost);
            orderAmount = v.findViewById(R.id.orderItemAmount);
            orderImage = v.findViewById(R.id.orderItemImage);
        }
    }

    public OrderRecyclerAdapter(ArrayList orders, int[] images){
        orderArrayList = orders;
        imageList = images;

    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderlayout, parent, false);
        OrderViewHolder orderViewHolder = new OrderViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        holder.orderName.setText(orderArrayList.get(position).getOrderName());

        holder.orderTotalPrice.setText("$" + String.valueOf(orderArrayList.get(position).getOrderCost()));

        holder.orderAmount.setText(String.valueOf(orderArrayList.get(position).getOrderSize()));

        holder.orderImage.setImageResource(imageList[orderArrayList.get(position).getItemPosition()]);


    }



    @Override
    public int getItemCount() {
        return orderArrayList.size();
    }
}
