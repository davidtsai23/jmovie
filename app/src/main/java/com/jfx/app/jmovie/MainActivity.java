package com.jfx.app.jmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jfx.app.jmovie.adapter.MovieAdapter;
import com.jfx.app.jmovie.entity.Movie;
import com.jfx.app.jmovie.util.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected MovieAdapter mMovieAdapter;
    protected List<Movie> movieList;
    protected RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏
        StatusBarUtils.setStatusBar(this,true,R.color.gray_f);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_movie);
        initData();
        mMovieAdapter = new MovieAdapter(this,movieList,R.layout.item_movie);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(mMovieAdapter);
        mMovieAdapter.notifyDataSetChanged();
    }

    private void initData() {
        movieList = new ArrayList<>();
        for (int i=0;i<10;i++){
            Movie movie = new Movie();
            movieList.add(movie);
        }
    }
}
