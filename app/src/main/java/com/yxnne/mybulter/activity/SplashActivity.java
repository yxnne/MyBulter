package com.yxnne.mybulter.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yxnne.mybulter.MainActivity;
import com.yxnne.mybulter.R;
import com.yxnne.mybulter.util.SharedPrefUtil;
import com.yxnne.mybulter.util.StaticClass;
import com.yxnne.mybulter.util.UtilTools;

/**
 * 闪屏页面，用途：展示logo，2，广告，3初始化数据，4，自定义字体
 * 延时
 * 全屏的方法在style里面搞
 * 自定义字体
 * 1，和java，res同级别的建立文件夹assets
 * 2，在assets中建立fonts，拷贝ttf文件
 */
public class SplashActivity extends AppCompatActivity {
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case StaticClass.HANDLER_SPLASH:
                    //程序是否是第一次运行

                    if(isFirst()){
                        Intent intent = new Intent(SplashActivity.this,
                                GuideActivity.class);
                        startActivity(intent);

                    }else{
                        Intent intent = new Intent(SplashActivity.this,
                                LoginActivity.class);
                        startActivity(intent);
                    }
                    finish();
                break;
            }
        }
    };

    /**
     * 判断是否是试一次运行程序
     */
    private boolean isFirst() {
        boolean isFirst = SharedPrefUtil.getBoolean(this,StaticClass.FIRST_RUN_APP,true);
        if(isFirst){
            SharedPrefUtil.putBoolean(this,StaticClass.FIRST_RUN_APP,false);
            return true;
        }else {
            return false;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    /**
     * 在本页面禁掉返回键
     */
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    private void init() {
        //延时2000ms
        mHandler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,2000);

        //自定义字体
        //Typeface fontType =Typeface.createFromAsset(getAssets(),"fonts/FONT.TTF");
        //tv.setTypeFace(fontType);
        //抽象成工具方法

        TextView tvAppname = (TextView) findViewById(R.id.tv_appname_splash);
        tvAppname.setText("测试字体");
        UtilTools.setFonts(this,tvAppname);
    }
}
