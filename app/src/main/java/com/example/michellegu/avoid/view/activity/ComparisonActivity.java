package com.example.michellegu.avoid.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.michellegu.avoid.R;

public class ComparisonActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison);
        initToolbar(R.id.my_toolbar);
    }
}
