package com.example.dockerPath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Installation extends AppCompatActivity implements View.OnClickListener {

    TextView mTitleTv, mDescTv;
    ImageView mImageIv, Imgdockerappdrag, imgdockerappinapps, imgdockertutorialmac, imgupdate, imginstalkey, imgtestifwork, imgreupdate, imginstalldocker ;
    ImageView imgdockerappsearch, imgwhaleiconsystray, imgdockertutorialwin,imguninstalold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installation);

        //Add actionbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// provide compatibility to all the versions
       // getSupportActionBar().setTitle("Installation");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // display back btn

        mTitleTv= findViewById(R.id.title);
        mDescTv= findViewById(R.id.description);
        mImageIv= findViewById(R.id.imageView);

        // retrieve our data from the intent

        Intent intent = getIntent();
        String mTitle= intent.getStringExtra("iTitle");
        String mDescription= intent.getStringExtra("gDesc");
        byte[] mBytes =getIntent().getByteArrayExtra("iImage");
        //Decoding images cuz we converted earlier into Bitmap
        Bitmap bitmap= BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

        //now set our data in our view, which we ve get from our previous Activity
        mTitleTv.setText(mTitle);
        mDescTv.setText(mDescription);
        mImageIv.setImageBitmap(bitmap);


        imgdockerappsearch = findViewById(R.id.image1);
        imgwhaleiconsystray = findViewById(R.id.image2);
        imgdockertutorialwin = findViewById(R.id.image3);
        Imgdockerappdrag = findViewById(R.id.imagem);
        imgdockerappinapps = findViewById(R.id.imagem2);
        imgdockertutorialmac = findViewById(R.id.imagem3);
        imgupdate = findViewById(R.id.imageU2);
        imginstalkey = findViewById(R.id.imageU3);
        imgtestifwork = findViewById(R.id.imageU4);
        imgreupdate = findViewById(R.id.imageU5);
        imginstalldocker = findViewById(R.id.imageU6);
        imguninstalold = findViewById(R.id.imageU);


        imgdockerappsearch.setOnClickListener(this);
        imgwhaleiconsystray.setOnClickListener(this);
        imgdockertutorialwin.setOnClickListener(this);
        Imgdockerappdrag.setOnClickListener(this);
        imgdockerappinapps.setOnClickListener(this);
        imgdockertutorialmac.setOnClickListener(this);
        imgupdate.setOnClickListener(this);
        imginstalkey.setOnClickListener(this);
        imgtestifwork.setOnClickListener(this);
        imgreupdate.setOnClickListener(this);
        imginstalldocker.setOnClickListener(this);
        imguninstalold.setOnClickListener(this);

        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.dockerappsearch))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgdockerappsearch); //set on imageView

        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.whaleiconsystray))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgwhaleiconsystray); //set on imageView


        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.dockertutorialwin))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgdockertutorialwin); //set on imageView

        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.dockerappdrag))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(Imgdockerappdrag); //set on imageView

        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.dockerappinapps))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgdockerappinapps); //set on imageView

        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.dockertutorialmac))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgdockertutorialmac); //set on imageView

        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.update))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgupdate); //set on imageView

        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.instalkey))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imginstalkey); //set on imageView

        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.testifwork))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgtestifwork); //set on imageView

        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.reupdate))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imgreupdate); //set on imageView

        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.installdocker))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imginstalldocker); //set on imageView

        //For animated loading placeholder
        Glide.with(Installation.this) // Pass activity name
                .load(Installation.this.getResources().getDrawable(R.drawable.uninstalold))
                //.placeholder(R.drawable.progress_bar)//Animated progressbar
                .into(imguninstalold); //set on imageView
    }


    public void onClick(View v) {
        int resourceID = 0;
        switch (v.getId()){
            case R.id.image1:
                resourceID = getResources().getIdentifier("dockerappsearch","drawable", this.getPackageName());
                break;
            case R.id.image2:
                resourceID = getResources().getIdentifier("whaleiconsystray","drawable", this.getPackageName());
                break;
            case R.id.image3:
                resourceID = getResources().getIdentifier("dockertutorialwin","drawable", this.getPackageName());
                break;
            case R.id.imagem:
                resourceID = getResources().getIdentifier("dockerappdrag","drawable", this.getPackageName());
                break;
            case R.id.imagem2:
                resourceID = getResources().getIdentifier("dockerappinapps","drawable", this.getPackageName());
                break;
            case R.id.imagem3:
                resourceID = getResources().getIdentifier("dockertutorialmac","drawable", this.getPackageName());
                break;
            case R.id.imageU2:
                resourceID = getResources().getIdentifier("update","drawable", this.getPackageName());
                break;
            case R.id.imageU3:
                resourceID = getResources().getIdentifier("instalkey","drawable", this.getPackageName());
                break;
            case R.id.imageU4:
                resourceID = getResources().getIdentifier("testifwork","drawable", this.getPackageName());
                break;
            case R.id.imageU5:
                resourceID = getResources().getIdentifier("reupdate","drawable", this.getPackageName());
                break;
            case R.id.imageU6:
                resourceID = getResources().getIdentifier("installdocker","drawable", this.getPackageName());
                break;
            case R.id.imageU:
                resourceID = getResources().getIdentifier("uninstalold","drawable", this.getPackageName());
                break;
        }

        Intent intent = new Intent(this, FullscreenImageActivity.class);
        intent.putExtra("ResourceID", resourceID);
        startActivity(intent);
    }
}
