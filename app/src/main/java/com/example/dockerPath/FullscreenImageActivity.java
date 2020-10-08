package com.example.dockerPath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.github.chrisbanes.photoview.PhotoView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        if (getIntent() != null) {
            int resourceId = getIntent().getIntExtra("ResourceID", 0);
            if (resourceId != 0) {
                photoView.setImageResource(resourceId);
            }
        }
    }

    public void goBack(View view) {
        this.finish();
    }

}
