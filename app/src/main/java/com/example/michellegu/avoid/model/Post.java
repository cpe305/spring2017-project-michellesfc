package com.example.michellegu.avoid.model;

/**
 * Created by michellegu on 4/23/17.
 */

public class Post {

    private long id;
    private User author;
    private String message;
    private int rating;
    private int votes;
    private String timeStamp;

    public Post() {

    }

    public Post(User author, String message, int rating) {
        this.author = author;
        this.message = message;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
