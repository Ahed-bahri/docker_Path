package com.example.dockerPath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DockerFile extends AppCompatActivity implements View.OnClickListener {
    ImageView imdockerfile, imgdockeregs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docker_file);

        //Add actionbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// provide compatibility to all the versions
        // getSupportActionBar().setTitle("Installation");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // display back btn

        imdockerfile = findViewById(R.id.img2);
        imgdockeregs = findViewById(R.id.img1);

        imdockerfile.setOnClickListener(this);
        imgdockeregs.setOnClickListener(this);

        //For animated loading placeholder
        Glide.with(DockerFile.this) // Pass activity name
                .load(DockerFile.this.getResources().getDrawable(R.drawable.dockerfilee))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imdockerfile); //set on imageView

        //For animated loading placeholder
        Glide.with(DockerFile.this) // Pass activity name
                .load(DockerFile.this.getResources().getDrawable(R.drawable.dockeresg))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgdockeregs); //set on imageView
    }

    public void onClick(View v) {
        int resourceID = 0;
        switch (v.getId()) {
            case R.id.img2:
                resourceID = getResources().getIdentifier("dockerfilee", "drawable", this.getPackageName());
                break;
            case R.id.img1:
                resourceID = getResources().getIdentifier("dockeresg", "drawable", this.getPackageName());
                break;
        }

        Intent intent = new Intent(this, FullscreenImageActivity.class);
        intent.putExtra("ResourceID", resourceID);
        startActivity(intent);

    }
}