package com.example.michellegu.avoid.model;

import java.util.ArrayList;

/**
 * Created by michellegu on 4/23/17.
 */

public class Place {

    private String placeID;
    private String name;
    private String address;
    private int currentRating;
    private ArrayList<Post> posts;

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
}
