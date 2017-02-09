package com.yxnne.mybulter;

import android.content.Intent;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yxnne.mybulter.activity.SettingActivity;
import com.yxnne.mybulter.fragment.ButlerFragment;
import com.yxnne.mybulter.fragment.GrilFragment;
import com.yxnne.mybulter.fragment.UserFragment;
import com.yxnne.mybulter.fragment.WeChatFragment;
import com.yxnne.mybulter.util.L;
import com.yxnne.mybulter.util.SharedPrefUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //控件
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FloatingActionButton mFab;

    //mTabLayout 要使用的标签列表
    private List<String> mTittle;
    //ViewPager 中放入的Fragment
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //去掉actionbar的阴影
        getSupportActionBar().setElevation(0);
        initData();
        initView();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_main);
        mViewPager = (ViewPager) findViewById(R.id.vp_main);
        mFab = (FloatingActionButton) findViewById(R.id.fab_main);
        //懸浮按鈕點擊事件
        mFab.setOnClickListener(this);
        //首页隐藏掉
        mFab.setVisibility(View.GONE);

        //ViewPager预加载
        mViewPager.setOffscreenPageLimit(mFragments.size());
        //ViewPager设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            //设置标题
            @Override
            public CharSequence getPageTitle(int position) {
                return mTittle.get(position);
            }
        });
        //ViewPager的滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //在第一页隐藏掉FloatingActionButton
                if(mFab != null) {
                    if (position == 0) {
                        mFab.setVisibility(View.GONE);

                    }else{
                        mFab.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //ViewPager和TabLayout进行绑定
        mTabLayout.setupWithViewPager(mViewPager);

    }

    /**
     * 初始化数据
     */
    private void initData() {
        mTittle = new ArrayList<>();
        mTittle.add(getString(R.string.tag_main_1));
        mTittle.add(getString(R.string.tag_main_2));
        mTittle.add(getString(R.string.tag_main_3));
        mTittle.add(getString(R.string.tag_main_4));

        mFragments = new ArrayList<>();
        mFragments.add(new ButlerFragment());
        mFragments.add(new WeChatFragment());
        mFragments.add(new GrilFragment());
        mFragments.add(new UserFragment());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_main://跳转到设置界面
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }
    }
}
