package com.ank.chatribaghvyankteshtempleapp;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import adapter.GraphReportPageAdapter;
import fragment.EventFragment;
import fragment.VratFragment;
public class EventsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupViewPager();
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


    public void setupViewPager() {
        GraphReportPageAdapter pageAdapter = new GraphReportPageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(EventFragment.newInstance("व्रतोत्सव निर्णय", "evetns"),"व्रतोत्सव निर्णय");
        pageAdapter.addFragment(VratFragment.newInstance("एकादशी व्रत", "vrat"),"एकादशी व्रत");
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }
}
