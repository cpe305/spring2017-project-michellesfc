package com.example.michellegu.avoid.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.michellegu.avoid.R;
import com.example.michellegu.avoid.view.adapter.SearchPagerAdapter;
import com.example.michellegu.avoid.presenter.SearchPresenter;
import com.example.michellegu.avoid.view.ISearchView;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity implements ISearchView {
    private SearchPresenter searchPresenter;
    private FragmentPagerAdapter adapterViewPager;

    //view components
    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout;

    //for google places

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        //attaching presenter
        searchPresenter = new SearchPresenter();
        searchPresenter.attachView(this);

        adapterViewPager = new SearchPagerAdapter(getSupportFragmentManager(), searchPresenter);
        viewPager.setAdapter(adapterViewPager);

        //setting up view components
        initToolbar(R.id.menu_toolbar);
        tabLayout.setupWithViewPager(viewPager);

        initPlacePicker();
    }

    private void initPlacePicker() {
        try {
            Intent pickerIntent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                    .build(this);
            startActivityForResult(pickerIntent, 1);
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
        }
    }

    //handles the action of selecting a place from the place picker
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                searchPresenter.createPlaceData(place.getId());
            }
            else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                // there was an error
            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }

        }
    }

    public FragmentPagerAdapter getPagerAdapter() {
        return adapterViewPager;
    }

}
