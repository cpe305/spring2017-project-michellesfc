package com.example.michellegu.avoid.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.michellegu.avoid.R;
import com.example.michellegu.avoid.model.PlaceData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by michellegu on 4/24/17.
 */

public class DetailsFragment extends Fragment {
    // Store instance variables
    private PlaceData place;

    @BindView(R.id.detailsText) TextView detailsText;

    // newInstance constructor for creating fragment with arguments
    public static DetailsFragment newInstance(PlaceData place) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("currentPlace", place);

        DetailsFragment fragmentFirst = new DetailsFragment();

        fragmentFirst.setArguments(bundle);
        return fragmentFirst;
    }

    public void updatePlace(PlaceData place) {
        if(place != null) {
            this.place = place;
            detailsText.setText(place.getName() + " " + place.getAddress());
        }
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        place = getArguments().getParcelable("currentPlace");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);

        if(place != null) {
            detailsText.setText(place.getName() + " " + place.getAddress());
        }
        return view;
    }
    
}
