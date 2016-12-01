package adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ank.chatribaghvyankteshtempleapp.R;

/**
 * Created by dbagv_000 on 7/1/2016.
 */
public class AboutSwaminiAdapter extends PagerAdapter {
    private LayoutInflater mLayoutInflater;
    Context context;
    private int[] layouts;
    Typeface tf;

    public AboutSwaminiAdapter(Context context, int[] layouts) {
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
                itemView = mLayoutInflater.inflate(R.layout.about_swamiji_page1, container, false);
                textView = (TextView) itemView.findViewById(R.id.title);
                textView.setTypeface(tf);
                textViewDescription = (TextView) itemView.findViewById(R.id.description);
                textViewDescription.setTypeface(tf);
                break;
            case 1:
                itemView = mLayoutInflater.inflate(R.layout.about_swamiji_page2, container, false);
                textView = (TextView) itemView.findViewById(R.id.title);
                textView.setTypeface(tf);
                textViewDescription = (TextView) itemView.findViewById(R.id.description);
                textViewDescription.setTypeface(tf);
                break;
            case 2:
                itemView = mLayoutInflater.inflate(R.layout.about_swamiji_page3, container, false);
                textView = (TextView) itemView.findViewById(R.id.title);
                textView.setTypeface(tf);
                textViewDescription = (TextView) itemView.findViewById(R.id.description);
                textViewDescription.setTypeface(tf);
                break;
            case 3:
                itemView = mLayoutInflater.inflate(R.layout.about_swamiji_page4, container, false);
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
