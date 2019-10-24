package com.example.infs3634individualassignment2burgerapp;

import android.os.ProxyFileDescriptorCallback;

import java.lang.reflect.Array;
import java.util.ArrayList;

// This class is used to provide access to a method of initialising the arrayList that contains the Product Objects
// The arrayList will then be used to feed multiple recyclerViews defined in other classes of this package
public class ProductDataBase {



    public static ArrayList<Product> setProductList(ArrayList<Product> itemList) {

        itemList.add(new Product(1,"Double Cheeseburger", 10, "More than two slices of cheese"));
        itemList.add(new Product(2,"French Fries", 5, "Long and Golden"));
        itemList.add(new Product(3,"Caesar Salad", 8, "Now with tomatoes of Roma"));
        itemList.add(new Product(4,"Large Soda", 4, "Perfectly Aerated"));
        itemList.add(new Product(5,"Refried Beans", 9, "Liquid Lard"));
        itemList.add(new Product(6,"T-Bone Steak", 5, "Throw it at your foes"));
        itemList.add(new Product(7, "Choc Sundae", 4, "Chocolate Heaven"));
        itemList.add(new Product(8, "Bratwurst", 6, "Ze German Sausage"));
        itemList.add(new Product(9, "Pineapple Pie", 3, "Tropiamericana"));
        itemList.add(new Product(10, "ChocoPie", 3, "Round and Sweeter"));
        itemList.add(new Product(11, "Ginger", 5, "Good for your stomach"));
        itemList.add(new Product(12, "Pancakes", 10, "Very Flattttt"));
        itemList.add(new Product(13, "Water", 4, "Pure H2O"));
        itemList.add(new Product(14, "Clown Hat", 13, "Real Clown Hours"));
        itemList.add(new Product(15, "Toffee", 2, "Always between the teeth"));


        return itemList;
    }





}
