package com.jfx.app.jmovie.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jfx.app.jmovie.fragment.MovieFragment;

public class TabFragmentAdapter extends FragmentStatePagerAdapter {

    //tab数量
    int tabCounts;

    /**
     * @param fm fragment管理器
     * @param tabCounts tab数量
     */
    public TabFragmentAdapter(FragmentManager fm,int tabCounts) {
        super(fm);
        this.tabCounts = tabCounts;
    }

    /**
     * 根据位置创建fragment
     * @param i
     * @return
     */
    @Override
    public Fragment getItem(int i) {
        return MovieFragment.getFragmentInstance(i);
    }

    @Override
    public int getCount() {
        return tabCounts;
    }
}
