package com.example.michellegu.avoid.view.activity;

import android.os.Bundle;

import com.example.michellegu.avoid.R;
import com.example.michellegu.avoid.view.IBaseView;

/**
 * This activity will keep track of the places the user favorites.
 */
public class FavoritesActivity extends BaseActivity implements IBaseView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        initToolbar(R.id.my_toolbar);
    }
}
