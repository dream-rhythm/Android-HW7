package com.example.user.android_hw7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 2017/6/6.
 */

public class HotelAdapter extends ArrayAdapter<Hotel> {
    Context context;
    public HotelAdapter(Context context,List<Hotel> items){
        super(context,0,items);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout itemlayout = null;
        if (convertView == null) {
            itemlayout = (LinearLayout) inflater.inflate(R.layout.hotel_view, null);
        } else {
            itemlayout = (LinearLayout) convertView;
        }
        Hotel item = (Hotel) getItem(position);
        TextView tv_Name = (TextView) itemlayout.findViewById(R.id.tv_Name);
        tv_Name.setText(item.getName());
        TextView tv_address = (TextView) itemlayout.findViewById(R.id.tv_address);
        tv_address.setText(item.getAddress());
        ImageView iv_Pic= (ImageView) itemlayout.findViewById(R.id.iv_Pic);
        iv_Pic.setImageBitmap(item.getImgUrl());
        return itemlayout;

    }
}
