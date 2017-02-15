package com.yxnne.mybulter.util;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Class Full Name  : com.yxnne.mybulter.util.UtilTools
 * Author Name      : yxnne
 * Create Time      : 2017/2/7
 * Project Name     : MyBulter
 * Descriptions     : 工具类
 */
public class UtilTools {
    /**
     * 给textview设置字体
     * @param context 上下文，用来得到assets
     * @param tv 设置的tv
     */
    public static void setFonts(Context context, TextView tv){
        Typeface typeface = Typeface.createFromAsset(context.getAssets()
                ,"fonts/FONT.TTF");
        tv.setTypeface(typeface);
    }
}
