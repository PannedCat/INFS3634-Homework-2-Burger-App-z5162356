package com.example.infs3634individualassignment2burgerapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Order {

    private int orderSize;
    private String orderName;
    private int orderCost;
    private int itemPosition;


    public Order(int orderSize, String orderName, int orderCost, int itemPosition) {
        this.orderSize = orderSize;
        this.orderName = orderName;
        this.orderCost = orderCost;
        this.itemPosition = itemPosition;
    }


    public int getItemPosition() {
        return itemPosition;
    }

    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    public int getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(int orderSize) {
        this.orderSize = orderSize;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(int orderCost) {
        this.orderCost = orderCost;
    }




}
