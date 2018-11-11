package com.jfx.app.jmovie.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jfx.app.jmovie.R;
import com.jfx.app.jmovie.adapter.MovieAdapter;
import com.jfx.app.jmovie.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment {


    private final static String TAG_KEY = "MOVIE";
    protected MovieAdapter mMovieAdapter;
    protected List<Movie> movieList;
    protected RecyclerView mRecyclerView;

    public MovieFragment() {
    }

    /**
     * 获取fragment实例
     * @param position 处于tab的位置索引，从0开始
     * @return
     */
    public static MovieFragment getFragmentInstance(int position){
        MovieFragment fragment = new MovieFragment();
        //设置bundle参数用以标记不同的fragment实例
        Bundle bundle = new Bundle();
        bundle.putInt(TAG_KEY,position);
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * 开始创建fragment的布局
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie,container,false);

        return view;
    }

    /**
     * fragment的布局初始化完毕
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recycler_movie);
        initData();
        mMovieAdapter = new MovieAdapter(getContext(),movieList,R.layout.item_movie);
        //为RecyclerView设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        //为RecyclerView设置适配器
        mRecyclerView.setAdapter(mMovieAdapter);
        //适配器触发数据展示
        mMovieAdapter.notifyDataSetChanged();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        movieList = new ArrayList<>();
        for (int i=0;i<10;i++){
            Movie movie = new Movie();
            movieList.add(movie);
        }
    }


}
