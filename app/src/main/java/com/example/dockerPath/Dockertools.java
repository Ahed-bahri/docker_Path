package com.example.dockerPath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Dockertools extends AppCompatActivity implements View.OnClickListener {

    ImageView imgdockercompose, imgdockermachine, imgdockerswarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dockertools);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// provide compatibility to all the versions
        // getSupportActionBar().setTitle("Installation");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // display back btn


        imgdockercompose = findViewById(R.id.img3);
        imgdockerswarm = findViewById(R.id.img2);
        imgdockermachine = findViewById(R.id.img1);


        imgdockercompose.setOnClickListener(this);
        imgdockermachine.setOnClickListener(this);
        imgdockerswarm.setOnClickListener(this);

        //For animated loading placeholder
        Glide.with(Dockertools.this) // Pass activity name
                .load(Dockertools.this.getResources().getDrawable(R.drawable.dockercompose))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgdockercompose); //set on imageView

        //For animated loading placeholder
        Glide.with(Dockertools.this) // Pass activity name
                .load(Dockertools.this.getResources().getDrawable(R.drawable.dockerswarm))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgdockerswarm); //set on imageView
        //For animated loading placeholder
        Glide.with(Dockertools.this) // Pass activity name
                .load(Dockertools.this.getResources().getDrawable(R.drawable.dockermachine))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgdockermachine); //set on imageView
    }

    public void onClick(View v) {
        int resourceID = 0;
        switch (v.getId()) {
            case R.id.img3:
                resourceID = getResources().getIdentifier("dockercompose", "drawable", this.getPackageName());
                break;
            case R.id.img2:
                resourceID = getResources().getIdentifier("dockerswarm", "drawable", this.getPackageName());
                break;
            case R.id.img1:
                resourceID = getResources().getIdentifier("dockermachine", "drawable", this.getPackageName());
                break;
        }

        Intent intent = new Intent(this, FullscreenImageActivity.class);
        intent.putExtra("ResourceID", resourceID);
        startActivity(intent);


    }
}