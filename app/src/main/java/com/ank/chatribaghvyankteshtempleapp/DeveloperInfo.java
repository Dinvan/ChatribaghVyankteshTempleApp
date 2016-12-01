package com.ank.chatribaghvyankteshtempleapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeveloperInfo extends AppCompatActivity {
    Button btnemailus,btnfollowus,btnmoreapps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    public void onButtonClick(View v)
    {
        switch (v.getId()) {
            case R.id.btnemailus:
                sendEmail();
                break;
            case R.id.btnfollowus:

                break;
            case R.id.btnmoreapps:

                Intent marketIntent = new Intent(Intent.ACTION_VIEW);
                marketIntent.setData(Uri.parse("https://play.google.com/store/search?q=infokitapps&hl=en"));
                startActivity(marketIntent);
                break;
            case R.id.btnRateUS:
                Intent rateUSIntent = new Intent(Intent.ACTION_VIEW);
                rateUSIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.infokitapps.vyankteshtemple&hl=en"));
                startActivity(rateUSIntent);

                break;
            default:
                break;
        }
    }

    protected void sendEmail()
    {
        Log.i("Send email", "");

        String[] TO = {"infokitapps@gmail.com"};
        String[] CC = {};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try
        {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(DeveloperInfo.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }



    public static void startActivity(Context context)
    {
        Intent intent =new Intent(context,DeveloperInfo.class);
        context.startActivity(intent);
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
