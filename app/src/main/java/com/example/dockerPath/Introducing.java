package com.example.dockerPath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Introducing extends AppCompatActivity implements View.OnClickListener {

    ImageView imageArc, imageCompo, imagePath, imageVoila, imageStorage, imageRegs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducing);

        //Add actionbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// provide compatibility to all the versions
        // getSupportActionBar().setTitle("Installation");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // display back btn

        //Assign variables
        imageArc = findViewById(R.id.image1);
        imageCompo= findViewById(R.id.image2);
        imagePath= findViewById(R.id.image3);
        imageVoila= findViewById(R.id.image4);
        imageRegs= findViewById(R.id.image5);
        imageStorage= findViewById(R.id.image6);

        imageArc.setOnClickListener(this);
        imageCompo.setOnClickListener(this);
        imagePath.setOnClickListener(this);
        imageVoila.setOnClickListener(this);
        imageStorage.setOnClickListener(this);
        imageRegs.setOnClickListener(this);

         //For animated loading placeholder
        Glide.with(Introducing.this) // Pass activity name
                .load(Introducing.this.getResources().getDrawable(R.drawable.arcitect))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imageArc); //set on imageView

       //For animated loading placeholder
        Glide.with(Introducing.this) // Pass activity name
                .load(Introducing.this.getResources().getDrawable(R.drawable.dockercomponent))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imageCompo); //set on imageView

        //For animated loading placeholder
        Glide.with(Introducing.this) // Pass activity name
                .load(Introducing.this.getResources().getDrawable(R.drawable.path))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imagePath); //set on imageView

        //For animated loading placeholder
        Glide.with(Introducing.this) // Pass activity name
                .load(Introducing.this.getResources().getDrawable(R.drawable.voila))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imageVoila); //set on imageView

        //For animated loading placeholder
        Glide.with(Introducing.this) // Pass activity name
                .load(Introducing.this.getResources().getDrawable(R.drawable.regs))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imageRegs); //set on imageView

        //For animated loading placeholder
        Glide.with(Introducing.this) // Pass activity name
                .load(Introducing.this.getResources().getDrawable(R.drawable.storage))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imageStorage); //set on imageView
    }

    @Override
    public void onClick(View v) {
        int resourceID = 0;
        switch (v.getId()){
            case R.id.image1:
                resourceID = getResources().getIdentifier("arcitect","drawable", this.getPackageName());
                break;
            case R.id.image2:
                resourceID = getResources().getIdentifier("dockercomponent","drawable", this.getPackageName());
                break;
            case R.id.image3:
                resourceID = getResources().getIdentifier("path","drawable", this.getPackageName());
                break;
            case R.id.image4:
                resourceID = getResources().getIdentifier("voila","drawable", this.getPackageName());
                break;
            case R.id.image5:
                resourceID = getResources().getIdentifier("regs","drawable", this.getPackageName());
                break;
            case R.id.image6:
                resourceID = getResources().getIdentifier("storage","drawable", this.getPackageName());
                break;
        }
        Intent intent = new Intent(this, FullscreenImageActivity.class);
        intent.putExtra("ResourceID", resourceID);
        startActivity(intent);
    }
}
