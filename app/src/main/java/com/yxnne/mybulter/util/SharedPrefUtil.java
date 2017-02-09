package com.yxnne.mybulter.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Class Full Name  : com.yxnne.mybulter.util.SharedPrefUtil
 * Author Name      : yxnne
 * Create Time      : 2017/2/9
 * Project Name     : MyBulter
 * Descriptions     : SharedPreference的封装
 *                  基本上三个功能：
 *                                1，get ，put(int boolean string)
 *                                2,删除某一个
 *                                3，删除全部
 * Others           :现在android推荐用apply代替commit了，因为Android的设计人员发现,
 *                  开发人员对commit的返回值不感兴趣（commit使用同步的方法并且有返回值的）,
 *                  而且在数据并发处理时使用commit要比apply效率低,所以推荐使用apply.
 */
public class SharedPrefUtil {

    private static final String NAME = "my_config";

    /**
     * 存放String类型
     * @param context 上下文
     * @param k 键
     * @param v 值
     */
    public static void putString(Context context , String k,String v){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putString(k,v).apply();
    }

    /**
     * 取到首选项中key对应的值
     * @param context 上下文
     * @param k 键
     * @param defaultValue 默认值
     * @return String值
     */
    public static String getString(Context context , String k,String defaultValue){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getString(k,defaultValue);
    }
    /**
     * 存放int类型
     * @param context 上下文
     * @param k 键
     * @param v 值
     */
    public static void putInt(Context context , String k,int v){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(k,v).apply();
    }

    /**
     * 取到首选项中key对应的int值
     * @param context 上下文
     * @param k 键
     * @param defaultValue 默认值
     * @return int值
     */
    public static int getInt(Context context , String k,int defaultValue){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getInt(k,defaultValue);
    }
    /**
     * 存放boolean类型
     * @param context 上下文
     * @param k 键
     * @param v 值
     */
    public static void putBoolean(Context context , String k,boolean v){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(k,v).apply();
    }

    /**
     * 取到首选项中key对应的boolean值
     * @param context 上下文
     * @param k 键
     * @param defaultValue 默认值
     * @return boolean值
     */
    public static boolean getBoolean(Context context , String k,boolean defaultValue){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getBoolean(k,defaultValue);
    }

    /**
     * 删除某个值
     * @param context 上下文
     * @param k 键
     */
    public static void deleteValueByKey(Context context,String k){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().remove(k).apply();
    }
    /**
     * 删除所有值
     * @param context 上下文
     */
    public static void deleteAll(Context context){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().clear().apply();
    }

}
