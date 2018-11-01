package com.jfx.app.jmovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.jfx.app.jmovie.entity.Movie;

import java.util.List;

public class MovieAdapter extends CommonRecyclerAdapter<Movie> {


    public MovieAdapter(Context context, List<Movie> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void handleView(CommonViewHolder viewHolder, Movie item) {

    }
}
