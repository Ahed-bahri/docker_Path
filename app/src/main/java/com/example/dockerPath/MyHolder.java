package com.example.dockerPath;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView mImageView;
    TextView mTitle, mDes;
    ItemClickListener itemClickListener;

    //ViewHolder to retrieve data using findViewById just one time for different rows
        //itemView is 1 single row for recycleView
    MyHolder(@NonNull View itemView) {
        super(itemView);
        this.mImageView = itemView.findViewById(R.id.imageIv);
        this.mTitle = itemView.findViewById(R.id.titleTv);
        this.mDes = itemView.findViewById(R.id.descriptionTV);
        //retrieve when u click to scroll
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v,getLayoutPosition());
    }


    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener= ic;
    }
}
