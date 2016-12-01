package com.ank.chatribaghvyankteshtempleapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import adapter.GalleryImageAdapter;
import commons.SharedPreferenceData;
import models.Events;
import models.GalleryItemModel;

/**
 * Created by Ankur on 16/07/2016.
 */
public class GalleryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    GalleryImageAdapter adapter;
    ArrayList<GalleryItemModel> galleryItemlist;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_view_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Firebase.setAndroidContext(this);
        galleryItemlist=new ArrayList<>();
        Firebase myFirebaseRef = new Firebase("https://chatribaghapp.firebaseio.com/");

        myFirebaseRef.child("GalleryImages/galleryItem").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                galleryItemlist=new ArrayList<>();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    GalleryItemModel galleryItem = postSnapshot.getValue(GalleryItemModel.class);
                    System.out.println("From Firebase:"+galleryItem.getImagepath() + " - " + galleryItem.getTitle());
                    galleryItemlist.add(galleryItem);
                }
                adapter=new GalleryImageAdapter(GalleryActivity.this,galleryItemlist);
                recyclerView.setAdapter(adapter);

                Gson gson=new Gson();
                String galleryDataString=gson.toJson(galleryItemlist).toString();
                SharedPreferenceData.setSharedPrefer(GalleryActivity.this,SharedPreferenceData.GALLERY_DATA,galleryDataString);

            }

            @Override public void onCancelled(FirebaseError error) { }
        });

    //   prepareImageDataList();

        setGalleryData();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setGalleryData()
    {
        try {
            String galleryDataString=SharedPreferenceData.getSharedPrefer(GalleryActivity.this,SharedPreferenceData.GALLERY_DATA);
           if(!galleryDataString.equals(""))
           {
               JSONArray jsaOwnerData = new JSONArray(galleryDataString);
               galleryItemlist = new Gson().fromJson(jsaOwnerData.toString(), new TypeToken<List<GalleryItemModel>>() {
               }.getType());
               adapter=new GalleryImageAdapter(GalleryActivity.this,galleryItemlist);
               recyclerView.setAdapter(adapter);
           }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    public void prepareImageDataList()
    {

        galleryItemlist=new ArrayList<>();
        GalleryItemModel model1=new GalleryItemModel();
        model1.setImagepath("https://s32.postimg.org/n24i7ia1h/dada_guru.jpg");
        model1.setTitle("Swamiji");
        galleryItemlist.add(model1);
        GalleryItemModel model2=new GalleryItemModel();
        model2.setImagepath("https://s31.postimg.org/vh40431d7/temple11.jpg");
        model2.setTitle("Swamiji");
        galleryItemlist.add(model2);
        GalleryItemModel model3=new GalleryItemModel();
        model3.setImagepath("https://s32.postimg.org/hu4k13tid/temple111.jpg");
        model3.setTitle("Swamiji");
        galleryItemlist.add(model3);
        GalleryItemModel model4=new GalleryItemModel();
        model4.setImagepath("https://s31.postimg.org/r0b6lq8or/temple1.jpg");
        model4.setTitle("Swamiji");
        galleryItemlist.add(model4);
        GalleryItemModel model5=new GalleryItemModel();
        model5.setImagepath("https://s31.postimg.org/4cwdywcmj/temple2.jpg");
        model5.setTitle("Swamiji");
        galleryItemlist.add(model5);
        GalleryItemModel model6=new GalleryItemModel();
        model6.setImagepath("https://s31.postimg.org/b1kjvv4ej/temple3.jpg");
        model6.setTitle("Swamiji");
        galleryItemlist.add(model6);
        GalleryItemModel model7=new GalleryItemModel();
        model7.setImagepath("https://s31.postimg.org/55oeul92z/bhagvan1.jpg");
        model7.setTitle("Swamiji");
        galleryItemlist.add(model7);
        GalleryItemModel model8=new GalleryItemModel();
        model8.setImagepath("https://s32.postimg.org/bzwa354v9/bhagvan2.jpg");
        model8.setTitle("Swamiji");
        galleryItemlist.add(model8);
        GalleryItemModel model9=new GalleryItemModel();
        model9.setImagepath("https://s32.postimg.org/klnncv5xh/bhagvan3.jpg");
        model9.setTitle("Swamiji");
        galleryItemlist.add(model9);
        GalleryItemModel model10=new GalleryItemModel();
        model10.setImagepath("https://s31.postimg.org/n252txlob/bhagvan4.png");
        model10.setTitle("Swamiji");
        galleryItemlist.add(model10);
        GalleryItemModel model11=new GalleryItemModel();
        model11.setImagepath("https://s31.postimg.org/i14ekqvi3/bhagvan5.jpg");
        model11.setTitle("Swamiji");
        galleryItemlist.add(model11);
        GalleryItemModel model12=new GalleryItemModel();
        model12.setImagepath("https://s31.postimg.org/4rkovkibf/bhagvan6.jpg");
        model12.setTitle("Swamiji");
        galleryItemlist.add(model12);
        GalleryItemModel model13=new GalleryItemModel();
        model13.setImagepath("https://s32.postimg.org/o0ly35flh/mataji.jpg");
        model13.setTitle("Swamiji");
        galleryItemlist.add(model3);
        GalleryItemModel model14=new GalleryItemModel();
        model14.setImagepath("https://s31.postimg.org/kdaqnca0b/mandir_decorate.jpg");
        model14.setTitle("Swamiji");
        galleryItemlist.add(model14);
        GalleryItemModel model15=new GalleryItemModel();
        model15.setImagepath("https://s31.postimg.org/647wdzl0r/dada_guru.png");
        model15.setTitle("Swamiji");
        galleryItemlist.add(model15);
        GalleryItemModel model16=new GalleryItemModel();
        model16.setImagepath("https://s31.postimg.org/ctvw9q9kr/swamijinivasa.jpg");
        model16.setTitle("Swamiji");
        galleryItemlist.add(model16);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_settings:
                DeveloperInfo.startActivity(GalleryActivity.this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
