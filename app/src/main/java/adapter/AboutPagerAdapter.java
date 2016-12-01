package adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ank.chatribaghvyankteshtempleapp.R;

import java.util.NoSuchElementException;

import commons.ScaleImageView;

/**
 * Created by dell on 29/05/2016.
 */
public class AboutPagerAdapter extends PagerAdapter {
    private LayoutInflater mLayoutInflater;
    Context context;
    private int[] layouts;
    Typeface tf;

    public AboutPagerAdapter(Context context, int[] layouts) {
        super();
        this.context = context;
        this.layouts = layouts;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.tf = Typeface.createFromAsset(context.getAssets(), "Adobe.otf");
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        /*View view = layoutInflater.inflate(layouts[position], container, false);
        ImageView img=(ImageView)view.findViewById(R.id.img1);
       // img.setScaleType();
        img.setImageResource(R.drawable.balajilogo);
        container.addView(view);*/
        View itemView = null;
        TextView textView, textViewDescription;
        switch (position) {
            case 0:
                itemView = mLayoutInflater.inflate(R.layout.about_temple_page1, container, false);
                textView = (TextView) itemView.findViewById(R.id.title);
                textView.setTypeface(tf);
                textViewDescription = (TextView) itemView.findViewById(R.id.description);
                textViewDescription.setTypeface(tf);
                break;
            case 1:
                itemView = mLayoutInflater.inflate(R.layout.about_temple_page2, container, false);
                textView = (TextView) itemView.findViewById(R.id.title);
                textView.setTypeface(tf);
                textViewDescription = (TextView) itemView.findViewById(R.id.description);
                textViewDescription.setTypeface(tf);
                break;
            case 2:
                itemView = mLayoutInflater.inflate(R.layout.about_temple_page3, container, false);
                textView = (TextView) itemView.findViewById(R.id.title);
                textView.setTypeface(tf);
                textViewDescription = (TextView) itemView.findViewById(R.id.description);
                textViewDescription.setTypeface(tf);
                break;
            case 3:
                itemView = mLayoutInflater.inflate(R.layout.about_temple_page4, container, false);
                textView = (TextView) itemView.findViewById(R.id.title);
                textView.setTypeface(tf);
                textViewDescription = (TextView) itemView.findViewById(R.id.description);
                textViewDescription.setTypeface(tf);
                break;

        }
        container.addView(itemView);
        return itemView;
    }


    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }






}
