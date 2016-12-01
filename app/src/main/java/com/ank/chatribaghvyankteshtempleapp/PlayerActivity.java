package com.ank.chatribaghvyankteshtempleapp;

import android.content.ContentValues;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class PlayerActivity extends AppCompatActivity {
    private ImageButton b2, b4;
    private ImageButton b1, b3;
    private MediaPlayer mediaPlayer;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private TextView tx1, tx2, tx3;
    private ListView listViewSound;
    public static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b1 = (ImageButton) findViewById(R.id.button);
        b2 = (ImageButton) findViewById(R.id.button2);
        b3 = (ImageButton) findViewById(R.id.button3);
        b4 = (ImageButton) findViewById(R.id.button4);

        listViewSound = (ListView) findViewById(R.id.listViewSound);
        final String[] soundName = {"Arti","Stuti", "Shri Vyanktesha", "Govinda", "Shri Venkatesham", "Dhun", "Bhajan", "Mantra"};
        final int[] soundSound = {R.raw.aarti,R.raw.one, R.raw.two, R.raw.three, R.raw.four, R.raw.five, R.raw.six, R.raw.mantra};
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, soundName);
        listViewSound.setAdapter(adapter);
        listViewSound.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tx3.setText(soundName[position]);
                startTime = 0;
                resetPlayer(mediaPlayer);
                mediaPlayer = MediaPlayer.create(PlayerActivity.this, soundSound[position]);
                seekbar = (SeekBar) findViewById(R.id.seekBar);
                seekbar.setClickable(false);
                b2.setEnabled(false);

                startPlayer();
            }
        });

        tx1 = (TextView) findViewById(R.id.textView2);
        tx2 = (TextView) findViewById(R.id.textView3);
        tx3 = (TextView) findViewById(R.id.textView4);
        tx3.setText(soundName[0]);

        mediaPlayer = MediaPlayer.create(this, R.raw.aarti);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setClickable(false);
        b2.setEnabled(false);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPlayer(mediaPlayer);
               // mediaPlayer = MediaPlayer.create(PlayerActivity.this, R.raw.aarti);
                startPlayer();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(getApplicationContext(), "Pausing sound", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                b2.setEnabled(false);
                b3.setEnabled(true);

                b2.setVisibility(View.GONE);
                b3.setVisibility(View.VISIBLE);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;

                if ((temp + forwardTime) <= finalTime) {
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int) startTime);
                   Toast.makeText(getApplicationContext(), "You have Jumped forward 5 seconds", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Cannot jump forward 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;

                if ((temp - backwardTime) > 0) {
                    startTime = startTime - backwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(), "You have Jumped backward 5 seconds", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Cannot jump backward 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer!=null)
        {

            mediaPlayer.stop();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void startPlayer() {
       // Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
        mediaPlayer.start();

        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();

        if (oneTimeOnly == 0) {
            seekbar.setMax((int) finalTime);
            oneTimeOnly = 1;
        }
        tx2.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime)))
        );

        tx1.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)))
        );

        seekbar.setProgress((int) startTime);
        myHandler.postDelayed(UpdateSongTime, 100);
        b2.setEnabled(true);
        b3.setEnabled(false);

        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.GONE);
    }


    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            tx1.setText(String.format("%d min, %d sec",

                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekbar.setProgress((int) startTime);
            if (startTime == finalTime) resetPlayer(mediaPlayer);
            myHandler.postDelayed(this, 100);
        }
    };

    public void resetPlayer(MediaPlayer mediaPlayer) {
        startTime = 0;
        finalTime = 0;
        oneTimeOnly = 0;
        forwardTime = 5000;
        backwardTime = 5000;

        if (mediaPlayer!=null&&mediaPlayer.isPlaying()) {
            mediaPlayer.stop();

            mediaPlayer.release();
        }

        b2.setEnabled(false);
        b3.setEnabled(true);

        b2.setVisibility(View.GONE);
        b3.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
