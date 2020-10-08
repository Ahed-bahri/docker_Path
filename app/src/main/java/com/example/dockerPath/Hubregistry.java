package com.example.dockerPath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Hubregistry extends AppCompatActivity implements View.OnClickListener {

    ImageView imgimgHub, imgimageXtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubregistry);
        //Add actionbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// provide compatibility to all the versions
        // getSupportActionBar().setTitle("Installation");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // display back btn

        imgimgHub = findViewById(R.id.imgHub);
        imgimageXtra = findViewById(R.id.imageXtra);

        imgimgHub.setOnClickListener(this);
        imgimageXtra.setOnClickListener(this);


        //For animated loading placeholder
        Glide.with(Hubregistry.this) // Pass activity name
                .load(Hubregistry.this.getResources().getDrawable(R.drawable.dockerdesktop))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgimgHub); //set on imageView


        //For animated loading placeholder
        Glide.with(Hubregistry.this) // Pass activity name
                .load(Hubregistry.this.getResources().getDrawable(R.drawable.registryhub))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgimageXtra); //set on imageView

    }

    @Override
    public void onClick(View v) {

        int resourceID = 0;
        switch (v.getId()) {
            case R.id.imgHub:
                resourceID = getResources().getIdentifier("dockerdesktop", "drawable", this.getPackageName());
                break;
            case R.id.imageXtra:
                resourceID = getResources().getIdentifier("registryhub", "drawable", this.getPackageName());
                break;
        }
        Intent intent = new Intent(this, FullscreenImageActivity.class);
        intent.putExtra("ResourceID", resourceID);
        startActivity(intent);
    }
}