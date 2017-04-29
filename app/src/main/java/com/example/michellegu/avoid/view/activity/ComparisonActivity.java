package com.example.michellegu.avoid.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.michellegu.avoid.R;
import com.example.michellegu.avoid.view.IComparisonView;

public class ComparisonActivity extends BaseActivity implements IComparisonView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison);
        initToolbar(R.id.menu_toolbar);
    }
}
