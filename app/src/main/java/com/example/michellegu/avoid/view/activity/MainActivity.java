package com.example.michellegu.avoid.view.activity;

import android.os.Bundle;

import com.example.michellegu.avoid.R;

/**
 * This activity is displayed when the app first starts up.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar(R.id.my_toolbar);
    }
}
