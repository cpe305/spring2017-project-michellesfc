package com.example.michellegu.avoid.model;

import java.util.List;

/**
 * Created by michellegu on 4/28/17.
 */

public class User {

    private String name;
    private List<PlaceData> favoritePlaces;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlaceData> getFavoritePlaces() {
        return favoritePlaces;
    }

    public void setFavoritePlaces(List<PlaceData> favoritePlaces) {
        this.favoritePlaces = favoritePlaces;
    }

    public void addFavoritePlace(PlaceData place) {
        favoritePlaces.add(place);
    }

    public void removeFavoritePlace(PlaceData place) {
        favoritePlaces.remove(place);
    }

}
