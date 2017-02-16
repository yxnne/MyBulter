package com.yxnne.mybulter.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Class Full Name  : com.yxnne.mybulter.activity.BaseActivity
 * Author Name      : yxnne
 * Create Time      : 2017/2/7
 * Project Name     : MyBulter
 * Descriptions     : Activity的基类
 *                    目的：定义：  统一属性，接口，方法
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //显示返回键，Actionbar的
        getSupportActionBar().setElevation(0);//去掉actionbar的阴影
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //菜单栏返回响应操作

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //该Id表示actionbar菜单栏的返回
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
