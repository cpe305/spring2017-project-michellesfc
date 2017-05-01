package com.example.michellegu.avoid.presenter;

import com.example.michellegu.avoid.model.PlaceData;
import com.example.michellegu.avoid.model.PlacesServiceTask;
import com.example.michellegu.avoid.view.ISearchView;
import com.example.michellegu.avoid.view.activity.SearchActivity;
import com.example.michellegu.avoid.view.adapter.SearchPagerAdapter;

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
        ((SearchPagerAdapter)searchView.getPagerAdapter()).update();
    }

    public PlaceData getCurrentPlace() {
        return currentPlace;
    }

    public void createPlaceData(String id) {
        new PlacesServiceTask(this).execute(id);
    }

}
