package com.jfx.app.jmovie;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jfx.app.jmovie.adapter.MovieAdapter;
import com.jfx.app.jmovie.adapter.TabFragmentAdapter;
import com.jfx.app.jmovie.entity.Movie;
import com.jfx.app.jmovie.util.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    String[] tabTitles = {"正在热映","即将上映"};

    TabFragmentAdapter tabFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏
        StatusBarUtils.setStatusBar(this,true,R.color.gray_f);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.toolbar_tab);
        viewPager = findViewById(R.id.viewpager_movie);

        //为tab添加内容
        for (int i=0;i<tabTitles.length;i++){
            tabLayout.addTab(tabLayout.newTab().setText(tabTitles[i]));
        }

        //初始化pager adapter
        tabFragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(),tabTitles.length);

        //viewpager设置adapter
        viewPager.setAdapter(tabFragmentAdapter);

        //添加viewpager改变监听
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //添加tab点击切换监听
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



}
