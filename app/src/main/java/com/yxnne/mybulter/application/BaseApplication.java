package com.yxnne.mybulter.application;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;
import com.yxnne.mybulter.util.StaticClass;

import cn.bmob.v3.Bmob;

/**
 * Class Full Name  : com.yxnne.mybulter.application.BaseApplication
 * Author Name      : yxnne
 * Create Time      : 2017/2/7
 * Project Name     : MyBulter
 * Descriptions     : 项目最近本的Application类
 */
public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化Tencent Crash framework Bugly，
        //参数1：上下文；参数2：申请的ID;参数3：logcat显示，测试时设置为true最好
        CrashReport.initCrashReport(getApplicationContext(),
                StaticClass.BUGLY_APP_ID, true);

        //初始化Bmob模块
        Bmob.initialize(this,StaticClass.BMOB_APP_ID);

    }
}
