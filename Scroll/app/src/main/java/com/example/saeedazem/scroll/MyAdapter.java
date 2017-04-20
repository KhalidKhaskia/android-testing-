package com.example.saeedazem.scroll;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by karam on 12/08/2015.
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> mFood;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        mFood = new ArrayList<>();
        mFood.add("HUMUS");
        mFood.add("HUMUS");
        mFood.add("HUMUS");
        mFood.add("HUMUS");
        mFood.add("HUMUS");

    }

    @Override
    public int getCount() {
        return mFood.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(this.mContext);
        tv.setText(mFood.get(position));
        return tv;
    }
}