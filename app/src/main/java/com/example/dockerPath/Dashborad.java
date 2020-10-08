package com.example.dockerPath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Dashborad extends AppCompatActivity {

    Button btn_intro, btn_education, btn_links, btn_quiz,btn_download, btn_settings;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    // the direct reference to our file
    StorageReference ref;
    DownloadManager downloadManager;
    public static String PACKAGE_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homedashborad);

        btn_intro=(Button)findViewById(R.id.buttonProfile);
        btn_education=(Button)findViewById(R.id.buttonEducation);
        btn_links=(Button)findViewById(R.id.usefullinks);
        btn_quiz=(Button)findViewById(R.id.buttonQuiz);
        btn_download=(Button)findViewById(R.id.buttonDownload);
        btn_settings=(Button)findViewById(R.id.buttonSetting);


        btn_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashborad.this,Introducing.class);
                startActivity(intent);
            }
        });

        btn_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashborad.this,Education.class);
                startActivity(intent);
            }
        });


        btn_links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashborad.this,Usefulinks.class);
                startActivity(intent);
            }
        });

        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashborad.this,About.class);
                startActivity(intent);
            }
        });

        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
        PACKAGE_NAME= getApplicationContext().getPackageName();

        btn_settings.setOnClickListener(new View.OnClickListener() {

            //get the package name
            @Override
            public void onClick(View v) {
                shareApp(v);
            }
        });
    }

    public void download(){
        //get the reference instance of the storage
        storageReference = firebaseStorage.getInstance().getReference();
        //direct child
        ref=storageReference.child("Docker-Cheat-Sheet.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                //to convert the uri to string
                String url= uri.toString();
                //call the default downloadManager for Android
                downloadFiles(Dashborad.this, "Docker-Cheat-Sheet", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Dashborad.this, "Oops, Something went wrong !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void shareApp(View view) {
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String value="https://play.google.com/store/apps/details?id="+PACKAGE_NAME;
        intent.putExtra(Intent.EXTRA_TEXT,value);
        startActivity(Intent.createChooser(intent,"Sharing is caring"));
    }

    //context of ur prog or activity, fileName is ur going to download, fileExtension is the extension of the file ur going to download
    //destinationDirectory u can give it a cutsom path
    public void downloadFiles(Context context, String fileName, String fileExtension, String destinationDirectory, String url){

        downloadManager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        // when the download is over the bar stay visible
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory,fileName + fileExtension);
        //Add a reference
        downloadManager.enqueue(request);
    }

}
