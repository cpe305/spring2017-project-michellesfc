package com.example.michellegu.avoid.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.michellegu.avoid.view.fragment.ChartFragment;
import com.example.michellegu.avoid.view.fragment.DetailsFragment;
import com.example.michellegu.avoid.view.fragment.PostsFragment;

/**
 * Created by michellegu on 4/24/17.
 */

public class SearchPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public SearchPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return DetailsFragment.newInstance();
            case 1:
                return ChartFragment.newInstance();
            case 2:
                return PostsFragment.newInstance();
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Details";
            case 1:
                return "Chart";
            case 2:
                return "Posts";
            default:
        }
        return "Page " + position;
    }

}
