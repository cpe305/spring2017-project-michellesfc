package com.example.michellegu.avoid.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.michellegu.avoid.model.PlaceData;
import com.example.michellegu.avoid.presenter.SearchPresenter;
import com.example.michellegu.avoid.view.fragment.ChartFragment;
import com.example.michellegu.avoid.view.fragment.DetailsFragment;
import com.example.michellegu.avoid.view.fragment.PostsFragment;
import com.google.android.gms.location.places.Place;

/**
 * Created by michellegu on 4/24/17.
 */

public class SearchPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    private SearchPresenter searchPresenter;
    private PlaceData place;
    public SearchPagerAdapter(FragmentManager fragmentManager, SearchPresenter searchPresenter) {
        super(fragmentManager);
        this.searchPresenter = searchPresenter;
    }

    public void update() {
        notifyDataSetChanged();
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
                return DetailsFragment.newInstance(searchPresenter.getCurrentPlace());
            case 1:
                return ChartFragment.newInstance();
            case 2:
                return PostsFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getItemPosition(Object object) {
    // POSITION_NONE makes it possible to reload the PagerAdapter
        System.out.print("im inside lik");
        if (object instanceof DetailsFragment) {
            ((DetailsFragment) object).updatePlace(searchPresenter.getCurrentPlace());
        }
        return super.getItemPosition(object);
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
