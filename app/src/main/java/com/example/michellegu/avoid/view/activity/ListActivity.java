package com.example.michellegu.avoid.view.activity;

import android.os.Bundle;

import com.example.michellegu.avoid.R;

/**
 * This activity will keep track of the places the user favorites.
 */
public class ListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initToolbar(R.id.my_toolbar);
        //TODO: this activity will keep track of the places the user favorited
        //TextView textView = (TextView)findViewById(R.id.secondTextView);
    }
}
