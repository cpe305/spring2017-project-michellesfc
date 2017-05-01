package com.example.michellegu.avoid.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.michellegu.avoid.R;
import com.example.michellegu.avoid.view.IBaseView;

/**
 * Created by michellegu on 4/23/17.
 * This class will be extended by all activities that require a toolbar menu.
 */

public class BaseActivity extends AppCompatActivity implements IBaseView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_search);
    }

    public void initToolbar(int toolbarID) {
        Toolbar myToolbar = (Toolbar) findViewById(toolbarID);
        myToolbar.setTitle("AVOID");
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.app_bar_favorites:
                Intent favoriteActivity = new Intent(this, FavoritesActivity.class);
                startActivity(favoriteActivity);
                return true;
            case R.id.app_bar_search:
                Intent searchActivity = new Intent(this, SearchActivity.class);
                startActivity(searchActivity);
                return true;
            case R.id.app_bar_comparison:
                Intent comparisonActivity = new Intent(this, ComparisonActivity.class);
                startActivity(comparisonActivity);
                return true;
            default:
                System.out.println("unable to determine user's action");
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
