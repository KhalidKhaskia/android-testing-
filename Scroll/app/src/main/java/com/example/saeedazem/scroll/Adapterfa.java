package com.example.saeedazem.scroll;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by rafat on 10/6/2015.
 */
public class Adapterfa extends BaseAdapter {


    private ArrayList<Movie> moviesList = new ArrayList<>();
    public Adapterfa(ArrayList<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    public ArrayList<Movie> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(ArrayList<Movie> moviesList) {
        this.moviesList = moviesList;
    }
    private Context pen;
    public Adapterfa(Context cont)
    {
        pen = cont;

        moviesList.add(new Movie("family",R.drawable.family1));
        moviesList.add(new Movie("family",R.drawable.family2));
        moviesList.add(new Movie("family",R.drawable.family3));

    }



    @Override
    public int getCount() {
        return moviesList.size();
    }

    @Override
    public Object getItem(int position) {
        return moviesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView poster= new ImageView(pen);
        poster.setImageResource(moviesList.get(position).getPoster());
        poster.setTag(moviesList.get(position));
        return poster;
    }
}
