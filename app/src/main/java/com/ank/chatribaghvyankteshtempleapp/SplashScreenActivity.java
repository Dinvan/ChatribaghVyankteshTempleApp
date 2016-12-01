package com.ank.chatribaghvyankteshtempleapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.io.IOException;

import commons.Commons;
import commons.SharedPreferenceData;

public class SplashScreenActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mPlayer;
    ImageButton muteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
     //   this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        muteButton=(ImageButton)findViewById(R.id.btnMute);
        muteButton.setOnClickListener(this);
        getSupportActionBar().hide();
        String start_sound=SharedPreferenceData.getSharedPrefer(SplashScreenActivity.this,SharedPreferenceData.APP_START_SOUND);
        mPlayer = MediaPlayer.create(SplashScreenActivity.this, R.raw.jaishreemannarayan);
        if(start_sound.equalsIgnoreCase("")) {
            muteButton.setImageResource(R.drawable.unmute);

            mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer arg0) {
                    try {
                        // mPlayer.prepare();
                        mPlayer.start();
                    } catch (Exception e) {
                        // handle this later
                    }

                }
            });
        }
        else
        {
            muteButton.setImageResource(R.drawable.muteicon);
        }

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);


                finish();
            }
        }, Commons.SPLASH_TIME_OUT);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnMute)
        {
            String start_sound=SharedPreferenceData.getSharedPrefer(SplashScreenActivity.this,SharedPreferenceData.APP_START_SOUND);

            if(start_sound.equalsIgnoreCase(""))
            {
                SharedPreferenceData.setSharedPrefer(SplashScreenActivity.this,SharedPreferenceData.APP_START_SOUND,"yes");
                muteButton.setImageResource(R.drawable.muteicon);
                if(mPlayer!=null) {
                    mPlayer.stop();
                    mPlayer.release();
//                    mPlayer.reset();
                }

            }
            else
            {
                mPlayer = MediaPlayer.create(SplashScreenActivity.this, R.raw.jaishreemannarayan);

                if(mPlayer!=null)
                {
                    mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer arg0) {
                            try {
                                // mPlayer.prepare();
                                mPlayer.start();
                            } catch (Exception e) {
                                // handle this later
                            }

                        }
                    });
                }
                SharedPreferenceData.setSharedPrefer(SplashScreenActivity.this,SharedPreferenceData.APP_START_SOUND,"");
                muteButton.setImageResource(R.drawable.unmute);

            }
        }

    }
}
