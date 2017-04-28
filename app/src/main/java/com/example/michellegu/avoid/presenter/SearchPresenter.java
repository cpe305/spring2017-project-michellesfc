package com.example.michellegu.avoid.presenter;

import com.example.michellegu.avoid.model.PlaceData;
import com.example.michellegu.avoid.view.ISearchView;

/**
 * Created by michellegu on 4/23/17.
 */

public class SearchPresenter {
    private ISearchView searchView;

    public SearchPresenter(ISearchView searchView) {
        this.searchView = searchView;
    }

}
