package com.yxnne.mybulter.util;

import android.util.Log;

/**
 * Class Full Name  : com.yxnne.mybulter.util.L
 * Author Name      : yxnne
 * Create Time      : 2017/2/9
 * Project Name     : MyBulter
 * Descriptions     : 系统log的简单封装
 *                      Debug Info Warning Erroe Fital
 */
public class L {
    //开关Log的测试模式
    public static final boolean DEBUG = true;
    //TAG
    public static final String TAG = "mybulter";

    /**
     * 封装Debug级别
     * @param msg message to Log
     */
    public static void d(String msg){
        if(DEBUG){
            Log.d(TAG,msg);
        }
    }
    /**
     * Info级别
     * @param msg message to Log
     */
    public static void i(String msg){
        if(DEBUG){
            Log.i(TAG,msg);
        }
    }
    /**
     * Warnning级别
     * @param msg message to Log
     */
    public static void w(String msg){
        if(DEBUG){
            Log.w(TAG,msg);
        }
    }

    /**
     * Error级别
     * @param msg message to Log
     */
    public static void e(String msg){
        if(DEBUG){
            Log.e(TAG,msg);
        }
    }

}
