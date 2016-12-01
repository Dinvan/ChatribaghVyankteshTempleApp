package com.ank.chatribaghvyankteshtempleapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.panxw.android.imageindicator.AutoPlayManager;
import com.panxw.android.imageindicator.ImageIndicatorView;

public class HomeActivity extends AppCompatActivity{
    Typeface tf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityj);
        this.tf = Typeface.createFromAsset(getBaseContext().getAssets(), "Adobe.otf");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageIndicatorView   imageIndicatorView = (ImageIndicatorView) findViewById(R.id.indicate_view);
        final Integer[] resArray = new Integer[] {
                R.drawable.slide_6,
                R.drawable.slide_1,
                R.drawable.ramanuj_ji,
                R.drawable.swamiji_01,
                R.drawable.slide_2,
                R.drawable.slide_3,

                R.drawable.slide_4,
                R.drawable.slide_5
        };
        imageIndicatorView.setupLayoutByDrawable(resArray);
        imageIndicatorView.setIndicateStyle(ImageIndicatorView.INDICATE_ARROW_ROUND_STYLE);
        imageIndicatorView.show();
        AutoPlayManager autoBrocastManager =  new AutoPlayManager(imageIndicatorView);
        autoBrocastManager.setBroadcastEnable(true);
        autoBrocastManager.setBroadCastTimes(5);//loop times
        autoBrocastManager.setBroadcastTimeIntevel(3 * 1000, 3 * 1000);//set first play time and interval
        autoBrocastManager.loop();

        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent marketIntent = new Intent(Intent.ACTION_VIEW);
                marketIntent.setData(Uri.parse("https://www.facebook.com/venkteshdevsthanam"));
                startActivity(marketIntent);
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
                DeveloperInfo.startActivity(HomeActivity.this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onHomeItemClick(View v)
    {
        Intent intent=new Intent();
            switch (v.getId()) {

                case R.id.latestEventsLayout:
                    intent.setClass(this,EventsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.aboutSwamijiLayout:
                    intent.setClass(this,AboutSwamijiActivity.class);
                    startActivity(intent);
                    break;
                case R.id.aboutTempleLayout:
                    intent.setClass(this,AboutTempleActivity.class);
                    startActivity(intent);
                    break;

                case R.id.contactUsLayout:
                    intent.setClass(this,ContactUsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.galleryLayout:
                    intent.setClass(this,GalleryActivity.class);
                    startActivity(intent);
                    break;
                case R.id.artiStrotamLayout:
                    Intent inte=new Intent(this,PlayerActivity.class);
                    // intent.setClass(this,GalleryActivity.class);
                    startActivity(inte);
                    break;

            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

}
