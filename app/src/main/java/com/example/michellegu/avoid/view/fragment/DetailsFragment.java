package com.example.michellegu.avoid.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.michellegu.avoid.R;

/**
 * Created by michellegu on 4/24/17.
 */

public class DetailsFragment extends Fragment {
    // Store instance variables
    private String title = "Details";
    private int page = 1;

    // newInstance constructor for creating fragment with arguments
    public static DetailsFragment newInstance() {
        DetailsFragment fragmentFirst = new DetailsFragment();
        Bundle args = new Bundle();
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        tvLabel.setText(page + " -- " + title);

        return view;
    }
}
