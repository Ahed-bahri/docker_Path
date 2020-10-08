package com.example.dockerPath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Tipstricks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipstricks);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// provide compatibility to all the versions
        // getSupportActionBar().setTitle("Installation");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // display back btn
    }
}
