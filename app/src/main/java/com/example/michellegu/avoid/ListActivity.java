package com.example.michellegu.avoid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initToolbar(R.id.my_toolbar);
        //TextView textView = (TextView)findViewById(R.id.secondTextView);
    }
}
