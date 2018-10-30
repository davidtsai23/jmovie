package com.jfx.app.jmovie.util;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

/**
 * 状态栏设置
 */
public class StatusBarUtils {

    public static void setStatusBar(Activity activity, boolean isSetColor, int colorId){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){ //5.0才以上可设置状态栏背景色
            //获取界面顶级视图包括状态标题栏
            View decorView = activity.getWindow().getDecorView();
            /**
             *  View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN：
             *      Activity全屏显示，但状态栏不会被隐藏覆盖，状态栏依然可见，Activity顶端布局部分会被状态遮住
             *  View.SYSTEM_UI_FLAG_LAYOUT_STABLE: 保持布局稳定，不在全屏时占据状态栏控件
             */
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            if (isSetColor){
                //根据传参设置状态栏颜色
                activity.getWindow().setStatusBarColor(activity.getResources().getColor(colorId));
            } else {
                //设置状态栏透明
                activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){ //4.4之后可以设置状态栏透明
            //状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){ //6.0以上才可以修改状态栏字体和图标
            /**
             * View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR:
             *      把状态栏标记为浅色，然后状态栏的字体颜色自动转换为深色
             */
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


    }

}
