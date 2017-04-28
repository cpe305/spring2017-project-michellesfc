package com.example.michellegu.avoid.model;

import java.util.ArrayList;

/**
 * Created by michellegu on 4/28/17.
 */

public class User {

    private String name;
    private ArrayList<PlaceData> favoritePlaces;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PlaceData> getFavoritePlaces() {
        return favoritePlaces;
    }

    public void setFavoritePlaces(ArrayList<PlaceData> favoritePlaces) {
        this.favoritePlaces = favoritePlaces;
    }

    public void addFavoritePlace(PlaceData place) {
        favoritePlaces.add(place);
    }

    public void removeFavoritePlace(PlaceData place) {
        favoritePlaces.remove(place);
    }

}
