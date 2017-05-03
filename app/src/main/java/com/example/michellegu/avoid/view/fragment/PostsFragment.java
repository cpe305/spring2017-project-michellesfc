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

public class PostsFragment extends Fragment {
    // Store instance variables

    // newInstance constructor for creating fragment with arguments
    public static PostsFragment newInstance() {
        PostsFragment fragmentThird = new PostsFragment();
        Bundle args = new Bundle();
        fragmentThird.setArguments(args);
        return fragmentThird;
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
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        TextView postLabel = (TextView) view.findViewById(R.id.postLabel);
        postLabel.setText(3 + " -- " + "Post");

        return view;
    }
}
