package com.example.lab5.adapters;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.lab5.activities.DetailActivity;
import com.example.lab5.models.Item;
import com.example.lab5.models.LikedItem;
import com.example.lab5.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ExampleViewHolder> implements Serializable {
    private Context mContext;
    private ArrayList<Item> mExampleList;
    private List<LikedItem> LikedList = new ArrayList<LikedItem>();
    public String imageUrl;



    public Adapter(Context context, ArrayList<Item> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Item currentItem = mExampleList.get(position);
        String imageUrl = currentItem.getImageUrl();
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public Button like_btn;
        public Button dislike_btn;
        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            like_btn = itemView.findViewById(R.id.like);
            dislike_btn = itemView.findViewById(R.id.dislike);

            like_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    like_btn.setBackgroundColor(0xFF0000);
                    int position=getAdapterPosition();
                    Item currentItem = mExampleList.get(position);
                    imageUrl = currentItem.getImageUrl();
                    LikedList.add(new LikedItem(imageUrl));
                    Log.d("123", imageUrl);
                    Singleton.getInstance().setItems(LikedList);
                }
            });

            dislike_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dislike_btn.setBackgroundColor(0xFF0045);
                }
            });

        }

    }
}

