package com.example.dockerPath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ContainersImages extends AppCompatActivity implements View.OnClickListener{
    ImageView imgdockerlayers, imgdockerdockeref, imgbootfs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_containers_images);
        //Add actionbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// provide compatibility to all the versions
        // getSupportActionBar().setTitle("Installation");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // display back btn


        imgdockerlayers = findViewById(R.id.image1);
        imgdockerdockeref = findViewById(R.id.imageXtra);
        imgbootfs = findViewById(R.id.image4);

        imgdockerlayers.setOnClickListener(this);
        imgdockerdockeref.setOnClickListener(this);
        imgbootfs.setOnClickListener(this);

        //For animated loading placeholder
        Glide.with(ContainersImages.this) // Pass activity name
                .load(ContainersImages.this.getResources().getDrawable(R.drawable.dockerlayers))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgdockerlayers); //set on imageView

        //For animated loading placeholder
        Glide.with(ContainersImages.this) // Pass activity name
                .load(ContainersImages.this.getResources().getDrawable(R.drawable.dockerdockeref))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgdockerdockeref); //set on imageView

        //For animated loading placeholder
        Glide.with(ContainersImages.this) // Pass activity name
                .load(ContainersImages.this.getResources().getDrawable(R.drawable.bootfs))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgbootfs); //set on imageView
    }

        public void onClick (View v){
            int resourceID = 0;
            switch (v.getId()) {
                case R.id.image1:
                    resourceID = getResources().getIdentifier("dockerlayers", "drawable", this.getPackageName());
                    break;
                case R.id.imageXtra:
                    resourceID = getResources().getIdentifier("dockerdockeref", "drawable", this.getPackageName());
                    break;
                case R.id.image4:
                    resourceID = getResources().getIdentifier("bootfs", "drawable", this.getPackageName());
                    break;
            }

            Intent intent = new Intent(this, FullscreenImageActivity.class);
            intent.putExtra("ResourceID", resourceID);
            startActivity(intent);

        }
    }