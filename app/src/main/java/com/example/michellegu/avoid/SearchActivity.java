package com.example.michellegu.avoid;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.example.michellegu.avoid.presenter.SearchPresenter;
import com.example.michellegu.avoid.view.ISearchView;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

public class SearchActivity extends BaseActivity implements ISearchView {

    private TextView mPlaceDetailsText;
    private SearchPresenter searchPresenter;
    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //attaching presenter
        searchPresenter = new SearchPresenter(this);

        //setting up view components
        initToolbar(R.id.my_toolbar);
        mPlaceDetailsText = (TextView) findViewById(R.id.placeTextView);

        createPicker();
    }

    private void createPicker() {
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
        mPlaceDetailsText.setText(formatPlaceDetails(getResources(), place.getName(),
                place.getId(), place.getAddress(), place.getPhoneNumber(),
                place.getWebsiteUri()));
    }


    private static Spanned formatPlaceDetails(Resources res, CharSequence name, String id,
                                              CharSequence address, CharSequence phoneNumber, Uri websiteUri) {

        return Html.fromHtml(res.getString(R.string.place_details, name, id, address, phoneNumber,
                websiteUri));

    }

}
