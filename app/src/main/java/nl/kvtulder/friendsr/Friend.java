package nl.kvtulder.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {

    private String name,bio;
    private int drawableID;
    private float rating;

    public Friend(String name, String bio, int drawableID) {
        this.name = name;
        this.bio = bio;
        this.drawableID = drawableID;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableID() {
        return drawableID;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
