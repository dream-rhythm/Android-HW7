package com.example.user.android_hw7;

import android.graphics.Bitmap;

/**
 * Created by user on 2017/6/6.
 */

public class Hotel {
    Bitmap imgUrl;
    String name;
    String address;

    public void setImgUrl(Bitmap imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
