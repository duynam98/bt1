package com.duynam.myapplication.model;

import android.media.Image;

public class Country {

    public String name;
    public int image;

    public Country(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
