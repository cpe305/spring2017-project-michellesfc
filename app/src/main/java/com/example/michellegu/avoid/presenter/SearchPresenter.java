package com.example.michellegu.avoid.presenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.michellegu.avoid.R;
import com.example.michellegu.avoid.model.PlaceData;
import com.example.michellegu.avoid.model.PlacesServiceTask;
import com.example.michellegu.avoid.view.ISearchView;
import com.example.michellegu.avoid.view.activity.SearchActivity;
import com.example.michellegu.avoid.view.adapter.SearchPagerAdapter;
import com.example.michellegu.avoid.view.fragment.DetailsFragment;

/**
 * Created by michellegu on 4/23/17.
 */

public class SearchPresenter {
    private ISearchView searchView;
    private PlaceData currentPlace;

    public SearchPresenter() {
    }

    public void attachView(ISearchView view) {
        searchView = view;
    }
    public void dettachView() {
        searchView = null;
    }

    public void setCurrentPlace(PlaceData place) {
        currentPlace = place;
        ((SearchPagerAdapter)((SearchActivity)searchView).getPageAdapter()).update();
    }

    public PlaceData getCurrentPlace() {
        return currentPlace;
    }

    public void createPlaceData(String id) {
        new PlacesServiceTask(this).execute(id);
    }



}
