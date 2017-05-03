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

public class ChartFragment extends Fragment {

    // newInstance constructor for creating fragment with arguments
    public static ChartFragment newInstance() {
        ChartFragment fragmentSecond = new ChartFragment();
        Bundle args = new Bundle();
        fragmentSecond.setArguments(args);
        return fragmentSecond;
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
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        TextView chartLabel = (TextView) view.findViewById(R.id.chartLabel);
        chartLabel.setText(2 + " -- " + "Chart");

        return view;
    }
}
