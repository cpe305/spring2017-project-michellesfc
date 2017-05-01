package com.example.michellegu.avoid.view.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.example.michellegu.avoid.R;
import com.example.michellegu.avoid.model.PlaceData;
import com.example.michellegu.avoid.view.adapter.SearchPagerAdapter;
import com.example.michellegu.avoid.presenter.SearchPresenter;
import com.example.michellegu.avoid.view.ISearchView;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity implements ISearchView {
    private SearchPresenter searchPresenter;
    private FragmentPagerAdapter adapterViewPager;

    //view components
    @BindView(R.id.viewpager) ViewPager viewPager;
    //@BindView(R.id.placeTextView) TextView placeDetails;
    @BindView(R.id.tabLayout) TabLayout tabLayout;


    //for google places
    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

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
            startActivityForResult(pickerIntent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException e) {
            // TODO: Handle the error.
        } catch (GooglePlayServicesNotAvailableException e) {
            // TODO: Handle the error.
        }
    }

    //handles the action of selecting a place from the place picker
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                searchPresenter.createPlaceData(place.getId());
                System.out.println("place id:  " + place.getId());
                //((SearchPagerAdapter)adapterViewPager).update();
                //System.out.println("I called update");
            }
            else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                // TODO: Handle the error.

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
                // TODO: Handle the cancellation.
            }

        }
    }

    public SearchPresenter getPresenter() {
        return searchPresenter;
    }

    public Fragment getFragment(int i) {
        return adapterViewPager.getItem(i);
    }

    public FragmentPagerAdapter getPageAdapter() {
        return adapterViewPager;
    }

    public void updateDetails(PlaceData p) {
        TextView h = (TextView)findViewById(R.id.tvLabel);
        h.setText(p.getName());
    }
    /*
    public void showPlaceDetails(Place place) {
        placeDetails.setText(formatPlaceDetails(getResources(), place.getName(), place.getAddress()));
    }

    private static Spanned formatPlaceDetails(Resources res, CharSequence name, CharSequence address) {
        return Html.fromHtml(res.getString(R.string.place_details, name, address));
    }*/


}
