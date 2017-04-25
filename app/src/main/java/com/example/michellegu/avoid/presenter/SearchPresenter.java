package com.example.michellegu.avoid.presenter;

import com.example.michellegu.avoid.model.Place;
import com.example.michellegu.avoid.view.ISearchView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by michellegu on 4/23/17.
 */

public class SearchPresenter {
    private ISearchView searchView;

    public SearchPresenter(ISearchView searchView) {
        this.searchView = searchView;
    }

    public void getCurrentRating(String placeID) {
        System.out.println("Place id is:      " + placeID);
    }

}
