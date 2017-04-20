package com.example.saeedazem.scroll;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.Serializable;

/**
 * Created by rafat on 10/6/2015.
 */
public class Movie extends BaseAdapter implements Serializable {

    private String Category;
    private int poster;

    public Movie(String Category, int poster) {
        this.Category= Category;
        this.poster = poster;
    }

    public String getCategory() {
        return Category;
    }

    public int getPoster() {
        return poster;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    @Override
    public int getCount() {
        return 0;
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
        return null;
    }
}
