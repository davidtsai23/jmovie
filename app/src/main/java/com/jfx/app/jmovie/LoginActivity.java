package com.jfx.app.jmovie;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.jfx.app.jmovie.util.StatusBarUtils;

public class LoginActivity extends AppCompatActivity {

    private TextView mUserName;
    private TextView mUserPwd;
    private Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏
        StatusBarUtils.setStatusBar(this,true,R.color.white);
        setContentView(R.layout.activity_login);
        mUserName = findViewById(R.id.userName);
        mUserPwd  = findViewById(R.id.userPwd);
        mLoginBtn = findViewById(R.id.loginBtn);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转main界面
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
