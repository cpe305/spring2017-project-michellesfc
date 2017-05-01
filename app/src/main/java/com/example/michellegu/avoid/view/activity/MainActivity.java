package com.example.michellegu.avoid.view.activity;

import android.os.Bundle;

import com.example.michellegu.avoid.R;
import com.example.michellegu.avoid.model.PlacesServiceTask;
import com.example.michellegu.avoid.view.IMainView;

/**
 * This activity is displayed when the app first starts up.
 */
public class MainActivity extends BaseActivity implements IMainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar(R.id.menu_toolbar);
        //String id = "ChIJdzw4-lHw7IAROl_2YvK64JU";
        //String id = "ChIJJ5n9h7Tx7IARYRUSOnzpAOI";
        //new PlacesServiceTask().execute(id);
    }
}
