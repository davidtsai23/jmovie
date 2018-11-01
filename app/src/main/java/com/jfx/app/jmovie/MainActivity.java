package com.jfx.app.jmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jfx.app.jmovie.util.StatusBarUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏
        StatusBarUtils.setStatusBar(this,true,R.color.gray_f);
        setContentView(R.layout.activity_main);

    }
}
