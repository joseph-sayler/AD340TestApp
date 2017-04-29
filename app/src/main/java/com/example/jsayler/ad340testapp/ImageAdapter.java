package com.example.jsayler.ad340testapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(600, 800));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.arrow, R.drawable.nes01,
            R.drawable.nes02, R.drawable.nes03,
            R.drawable.nes04, R.drawable.nes05,
            R.drawable.nes06, R.drawable.nes07,
            R.drawable.nes08, R.drawable.nes09,
            R.drawable.nes10, R.drawable.nes11,
            R.drawable.nes12, R.drawable.nes13,
            R.drawable.nes14, R.drawable.nes15,
            R.drawable.nes16, R.drawable.nes17,
            R.drawable.nes18, R.drawable.nes19,
            R.drawable.nes20, R.drawable.nes21,
            R.drawable.nes22, R.drawable.nes23,
            R.drawable.nes24, R.drawable.nes25,
            R.drawable.nes26, R.drawable.nes27
    };

}
