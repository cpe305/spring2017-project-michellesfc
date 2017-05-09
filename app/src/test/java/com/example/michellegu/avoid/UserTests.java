package com.example.michellegu.avoid.model;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*; 


public class UserTests {

    User user = new User();

    @Test
    public void testUserName() {
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    @Test
    public void testUserNameEmpty() {
        user.setName("");
        assertEquals("", user.getName());
    }

    @Test
    public void testUserGetFavoritePlaces() {
        List<PlaceData> favoritePlaces = new ArrayList<PlaceData>();
        PlaceData placeData = new PlaceData("203", "Lecture Room 203", "Cal Poly, SLO", 10);
        favoritePlaces.add(placeData);
        user.setFavoritePlaces(favoritePlaces);
        assertEquals(user.getFavoritePlaces().get(0).getPlaceID(), "203");
    }
}
