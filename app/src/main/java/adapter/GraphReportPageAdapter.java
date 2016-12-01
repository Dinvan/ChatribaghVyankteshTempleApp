package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbagv_000 on 7/14/2016.
 */
public class GraphReportPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public GraphReportPageAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        mFragmentTitleList.add(title);
    }

}
