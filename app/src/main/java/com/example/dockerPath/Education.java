package com.example.dockerPath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Education extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        //Add actionbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// provide compatibility to all the versions
        getSupportActionBar().setTitle("Education Path");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // display back btn

        //after creating a model class
        //creating MyHolder Class
        //Creating Adapter Class
        //Back To Education Class (Here)

        // >> Here we are creating the recyclerView in the Activity
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));  //position will create recyclerView in linearLayout (layout manager is OBLIGATORY)

        myAdapter= new MyAdapter(this,getMyList());
        mRecyclerView.setAdapter(myAdapter);

    }

    private ArrayList<Model> getMyList(){

        ArrayList<Model> models= new ArrayList<>();

        Model m = new Model();
        m.setTitle("Docker Installation");
        m.setDescription("Windows, Ubuntu, Mac os");
        //first add some images in drawable folder
        m.setImg(R.drawable.softwaredown);
        models.add(m);

        m = new Model();
        m.setTitle("Containers & Images");
        m.setDescription("Build, run, share, bonus");
        m.setImg(R.drawable.contimg);
        models.add(m);

        m = new Model();
        m.setTitle("Hub & Registry");
        m.setDescription("Docker hub inside look, workflow");
        m.setImg(R.drawable.regs);
        models.add(m);

        m = new Model();
        m.setTitle("DockerFile");
        m.setDescription("Definition, terms, commands");
        m.setImg(R.drawable.dockdoc);
        models.add(m);

        m = new Model();
        m.setTitle("Tips & Tricks");
        m.setDescription("Gain time and experience");
        m.setImg(R.drawable.tipsround);
        models.add(m);

        m = new Model();
        m.setTitle("Docker Tools");
        m.setDescription("Compose, swarm, machine");
        m.setImg(R.drawable.toolsicon);
        models.add(m);

        return models;

        //in case facing RecyclerView width screen problem, and that is bcz we are using wrap_content width in row.xml
    }
    //Creating an interface class
    //now go into my Holder class
    //creating an activity

}
