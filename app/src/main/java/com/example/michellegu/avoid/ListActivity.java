package com.example.michellegu.avoid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
