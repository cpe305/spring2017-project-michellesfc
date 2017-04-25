package com.example.michellegu.avoid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
