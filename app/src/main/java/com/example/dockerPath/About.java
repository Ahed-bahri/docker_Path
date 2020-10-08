package com.example.dockerPath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class About extends AppCompatActivity implements View.OnClickListener {

    Button Msgcontact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Add actionbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// provide compatibility to all the versions
         getSupportActionBar().setTitle("Feedbacks");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // display back btn

        Msgcontact = findViewById(R.id.contact);
        Msgcontact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try{
            Intent sendemail = new Intent(Intent.ACTION_SEND);
            sendemail.setData(Uri.parse("mailto:"));
            sendemail.setType("message/rfc822");
            sendemail.putExtra(Intent.EXTRA_EMAIL,"ahedelbahri@gmail.com");
            sendemail.putExtra(Intent.EXTRA_SUBJECT," About Docker Path App");
            startActivity(sendemail);
        }catch(Exception e){
            Toast.makeText(this,"Sorry you Got no Messaging App",Toast.LENGTH_LONG).show();
        }
    }
}
