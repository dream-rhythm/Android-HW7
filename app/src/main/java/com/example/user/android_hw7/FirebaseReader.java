package com.example.user.android_hw7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/6/6.
 */

public class FirebaseReader extends Thread {
    private DataSnapshot dataSnapshot;

    public FirebaseReader(DataSnapshot dataSnapshot){
        this.dataSnapshot=  dataSnapshot;
    }
    public  void run(){
        List<Hotel> Hotel_list = new ArrayList<>();
        for(DataSnapshot ds:dataSnapshot.getChildren()){
            DataSnapshot ds_Name = ds.child("Name");
            DataSnapshot ds_Picture = ds.child("Picture1");
            DataSnapshot ds_address = ds.child("Add");
            String Name = (String) ds_Name.getValue();
            String Picture_url = (String) ds_Picture.getValue();
            String address = (String) ds_address.getValue();
            Bitmap Picture = getImgBitmap(Picture_url);
            Hotel hotel = new Hotel();
            hotel.setAddress(address);
            hotel.setName(Name);
            hotel.setImgUrl(Picture);
            Hotel_list.add(hotel);
            Log.v("123", "Name:" + Name);
        }
    }

    private Bitmap getImgBitmap(String imgUrl) {
        try {
            URL url = new URL(imgUrl);
            Bitmap bm = BitmapFactory.decodeStream(
                    url.openConnection()
                            .getInputStream());
            return bm;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
