package com.example.michellegu.avoid.model;

import android.os.AsyncTask;
import android.util.Log;

import com.example.michellegu.avoid.presenter.SearchPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by michellegu on 4/30/17.
 */

public class PlacesServiceTask extends AsyncTask<String, Void, String> {

    private static final String API_KEY = "AIzaSyC2sNzHoR3n0fq1ryhxFWhM9qBlG62Q88Q";

    private SearchPresenter searchPresenter;

    public PlacesServiceTask(SearchPresenter presenter) {
        searchPresenter = presenter;
    }

    private String makeUrl(String id) {
        StringBuilder urlString = new StringBuilder(
                "https://maps.googleapis.com/maps/api/place/details/json?");
        urlString.append("placeid=");
        urlString.append(id);
        urlString.append("&key=");
        urlString.append(API_KEY);
        return urlString.toString();
    }

    protected String doInBackground(String... places) {

        try {
            URL url = new URL(makeUrl(places[0]));
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    protected void onPostExecute(String response) {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }

        try {
            JSONObject object = new JSONObject(response);
            JSONObject results = object.getJSONObject("result");
            String id = results.getString("place_id");
            String address = results.getString("formatted_address");
            String name = results.getString("name");

            //store opening hours


            PlaceData place = new PlaceData(id, address, name, 0);
            searchPresenter.setCurrentPlace(place);
            //DayRating
            //opening hours check if they have it
            //check for weekday_text

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
