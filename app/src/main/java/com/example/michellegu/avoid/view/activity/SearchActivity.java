package com.example.michellegu.avoid.view.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.example.michellegu.avoid.R;
import com.example.michellegu.avoid.view.adapter.SearchPagerAdapter;
import com.example.michellegu.avoid.presenter.SearchPresenter;
import com.example.michellegu.avoid.view.ISearchView;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

public class SearchActivity extends BaseActivity implements ISearchView {
    private SearchPresenter searchPresenter;
    private FragmentPagerAdapter adapterViewPager;

    //view components
    private TextView mPlaceDetailsText;
    private TextView mCurrentRatingsText;
    private TabLayout mTabLayout;


    //for google places
    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //attaching presenter
        searchPresenter = new SearchPresenter(this);

        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        adapterViewPager = new SearchPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        //setting up view components
        initToolbar(R.id.my_toolbar);
        mPlaceDetailsText = (TextView) findViewById(R.id.placeTextView);
        mCurrentRatingsText = (TextView) findViewById(R.id.currentRatingTextView);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(vpPager);

        createPlacePicker();
    }

    private void createPlacePicker() {
        try {
            Intent pickerIntent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                    .build(this);
            startActivityForResult(pickerIntent, 1);
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

                showPlaceDetails(place);
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

    public void showPlaceDetails(Place place) {
        mPlaceDetailsText.setText(formatPlaceDetails(getResources(), place.getName(), place.getAddress()));
    }

    private static Spanned formatPlaceDetails(Resources res, CharSequence name, CharSequence address) {
        return Html.fromHtml(res.getString(R.string.place_details, name, address));
    }

}
