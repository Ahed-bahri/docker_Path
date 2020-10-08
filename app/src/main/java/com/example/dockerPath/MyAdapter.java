package com.example.dockerPath;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/* Adapter takes the item=row and place data=model on it, then control which item to display at which position */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    // This arrayList create a list of array which parameters define in our Model Class
    ArrayList<Model> models;

    //Creating a parametred construtctor

    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    //to create view holders that screen display in the beginning (init)
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //this line inflate(the process of adding a view(.xml) to activity on runtime) our row;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null);
        return new MyHolder(view); // This will return our view to holder class
    }

    //to recycle the created view holders
    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {

        holder.mTitle.setText(models.get(position).getTitle());
        holder.mDes.setText(models.get(position).getDescription());
        holder.mImageView.setImageResource(models.get(position).getImg());
        //setImageResource bcz we will use images in our Resource folder which is drawable


        //This method is than u can use wn u want to use one activity
        //To get data from previous Activity

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                if (models.get(position).getTitle().equals("Docker Installation")){
                    String gTitle = models.get(position).getTitle();
                    String gDesc = models.get(position).getDescription(); //objects to get our data from previous activity

                    BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImageView.getDrawable(); //to get our images from drawable
                    Bitmap bitmap = bitmapDrawable.getBitmap();

                    ByteArrayOutputStream stream = new ByteArrayOutputStream(); // image will get stream and bytes

                    bitmap.compress(Bitmap.CompressFormat.PNG,100,stream); // to compress our images
                    //coding
                    byte[] bytes= stream.toByteArray();

                    //pass our data via the intent
                    Intent intent = new Intent(c, Installation.class);
                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc); // get data and put in intent
                    intent.putExtra("iImage", bytes);
                    c.startActivity(intent);

                }

                if (models.get(position).getTitle().equals("Containers & Images")){
                    String gTitle = models.get(position).getTitle();
                    String gDesc = models.get(position).getDescription(); //objects to get our data from previous activity
                    BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImageView.getDrawable(); //to get our images from drawable
                    Bitmap bitmap = bitmapDrawable.getBitmap();

                    ByteArrayOutputStream stream = new ByteArrayOutputStream(); // image will get stream and bytes

                    bitmap.compress(Bitmap.CompressFormat.PNG,100,stream); // to compress our images
                    //coding
                    byte[] bytes= stream.toByteArray();

                    //pass our data via the intent
                    Intent intent = new Intent(c, ContainersImages.class);
                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc); // get data and put in intent
                    intent.putExtra("iImage", bytes);
                    c.startActivity(intent);

                }

                if (models.get(position).getTitle().equals("Hub & Registry")){
                    String gTitle = models.get(position).getTitle();
                    String gDesc = models.get(position).getDescription(); //objects to get our data from previous activity
                    BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImageView.getDrawable(); //to get our images from drawable
                    Bitmap bitmap = bitmapDrawable.getBitmap();

                    ByteArrayOutputStream stream = new ByteArrayOutputStream(); // image will get stream and bytes

                    bitmap.compress(Bitmap.CompressFormat.PNG,100,stream); // to compress our images
                    //coding
                    byte[] bytes= stream.toByteArray();

                    //pass our data via the intent
                    Intent intent = new Intent(c, Hubregistry.class);
                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc); // get data and put in intent
                    intent.putExtra("iImage", bytes);
                    c.startActivity(intent);

                }

                if (models.get(position).getTitle().equals("DockerFile")){
                    String gTitle = models.get(position).getTitle();
                    String gDesc = models.get(position).getDescription(); //objects to get our data from previous activity
                    BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImageView.getDrawable(); //to get our images from drawable
                    Bitmap bitmap = bitmapDrawable.getBitmap();

                    ByteArrayOutputStream stream = new ByteArrayOutputStream(); // image will get stream and bytes

                    bitmap.compress(Bitmap.CompressFormat.PNG,100,stream); // to compress our images
                    //coding
                    byte[] bytes= stream.toByteArray();

                    //pass our data via the intent
                    Intent intent = new Intent(c, DockerFile.class);
                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc); // get data and put in intent
                    intent.putExtra("iImage", bytes);
                    c.startActivity(intent);

                }

                if (models.get(position).getTitle().equals("Tips & Tricks")){
                    String gTitle = models.get(position).getTitle();
                    String gDesc = models.get(position).getDescription(); //objects to get our data from previous activity
                    BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImageView.getDrawable(); //to get our images from drawable
                    Bitmap bitmap = bitmapDrawable.getBitmap();

                    ByteArrayOutputStream stream = new ByteArrayOutputStream(); // image will get stream and bytes

                    bitmap.compress(Bitmap.CompressFormat.PNG,100,stream); // to compress our images
                    //coding
                    byte[] bytes= stream.toByteArray();

                    //pass our data via the intent
                    Intent intent = new Intent(c, Tipstricks.class);
                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc); // get data and put in intent
                    intent.putExtra("iImage", bytes);
                    c.startActivity(intent);

                }

                if (models.get(position).getTitle().equals("Docker Tools")){

                    String gTitle = models.get(position).getTitle();
                    String gDesc = models.get(position).getDescription(); //objects to get our data from previous activity
                    BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImageView.getDrawable(); //to get our images from drawable
                    Bitmap bitmap = bitmapDrawable.getBitmap();

                    ByteArrayOutputStream stream = new ByteArrayOutputStream(); // image will get stream and bytes

                    bitmap.compress(Bitmap.CompressFormat.PNG,100,stream); // to compress our images
                    //coding
                    byte[] bytes= stream.toByteArray();

                    //pass our data via the intent
                    Intent intent = new Intent(c, Dockertools.class);
                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc); // get data and put in intent
                    intent.putExtra("iImage", bytes);
                    c.startActivity(intent);

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
