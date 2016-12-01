package com.ank.chatribaghvyankteshtempleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import adapter.GalleryImageAdapter;

public class FullScreenGalleryImageActivity extends AppCompatActivity {

    ImageView imgFullScreen;
    AppCompatButton btnSetAsWallpaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_gallery_image);
        imgFullScreen=(ImageView)findViewById(R.id.imgFullScreen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final String imagePath=getIntent().getStringExtra("imagePath");
        GalleryImageAdapter.downloadProfileImages(imagePath,imgFullScreen);

        btnSetAsWallpaper=(AppCompatButton)findViewById(R.id.btnSetAsWallpaper);
        btnSetAsWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryImageAdapter.setImageAsWallPaper(imagePath,FullScreenGalleryImageActivity.this);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_settings:
                DeveloperInfo.startActivity(FullScreenGalleryImageActivity.this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
