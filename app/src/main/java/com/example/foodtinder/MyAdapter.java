package com.example.foodtinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> mImages;
    private List<String> mTexts;

    public MyAdapter(Context context, List<Integer> images, List<String> texts) {
        mContext = context;
        mImages = images;
        mTexts = texts;
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public Object getItem(int position) {
        return mImages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        }
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setImageResource(mImages.get(position));
        TextView textView = view.findViewById(R.id.helloText);
        textView.setText(mTexts.get(position));
        return view;
    }
}

