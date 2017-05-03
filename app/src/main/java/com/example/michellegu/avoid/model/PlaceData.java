package com.example.michellegu.avoid.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by michellegu on 4/23/17.
 *
 * Note: I decided to name this class PlaceData instead of the more suited name Place
 * because Google Places API returns a Place object. This would have led to some confusion.
 */

public class PlaceData implements Parcelable{

    private String placeID;
    private String name;
    private String address;
    private int currentRating;
    private ArrayList<Post> posts;
    private WeekRating overallRating;

    public PlaceData() {}

    private PlaceData(Parcel in) {
        placeID = in.readString();
        name = in.readString();
        address = in.readString();
        currentRating = in.readInt();
    }

    public PlaceData(String placeID, String name, String address, int currentRating) {
        this.placeID = placeID;
        this.name = name;
        this.address = address;
        this.currentRating = currentRating;
    }

    public String getPlaceID() {
        return placeID;
    }

    public void setPlaceID(String placeID) {
        this.placeID = placeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCurrentRating() {
        return currentRating;
    }

    public void setCurrentRating(int currentRating) {
        this.currentRating = currentRating;
    }

    public void addPost(Post p) {
        posts.add(p);
    }

    public void removePost(Post p) {
        posts.remove(p);
    }

    public WeekRating getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(WeekRating overallRating) {
        this.overallRating = overallRating;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(placeID);
        out.writeString(name);
        out.writeString(address);
        out.writeInt(currentRating);
    }

    public static final Parcelable.Creator<PlaceData> CREATOR
            = new Parcelable.Creator<PlaceData>() {
        public PlaceData createFromParcel(Parcel in) {
            return new PlaceData(in);
        }

        public PlaceData[] newArray(int size) {
            return new PlaceData[size];
        }
    };


}
