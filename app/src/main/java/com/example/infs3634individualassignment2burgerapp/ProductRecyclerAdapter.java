package com.example.infs3634individualassignment2burgerapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductRecyclerAdapter extends RecyclerView.Adapter <ProductRecyclerAdapter.ProductViewHolder>{

    private ArrayList<Product> productArrayList;
    private int[] imageList;


    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        public TextView itemName;

        public ImageView itemImage;

        public ConstraintLayout itemLayout;


        public ProductViewHolder(@NonNull View v) {
            super(v);

            itemName = v.findViewById(R.id.productName);

            itemImage = v.findViewById(R.id.productImage);

            itemLayout = v.findViewById(R.id.productLayout);



        }
    }

    public ProductRecyclerAdapter(ArrayList products, int[]images) {
        productArrayList = products;
        imageList = images;

    }



    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chunk, parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, final int position) {
        holder.itemName.setText(productArrayList.get(position).getName());
        holder.itemImage.setImageResource(imageList[position]);

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int clickPosition = holder.getAdapterPosition();

                Intent itemDetailSwitch = new Intent(v.getContext(), ItemDetailActivity.class);
                itemDetailSwitch.putExtra("Image List", imageList);
                itemDetailSwitch.putExtra("Position", clickPosition);
                v.getContext().startActivity(itemDetailSwitch);


            }
        });


    }



    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
}
