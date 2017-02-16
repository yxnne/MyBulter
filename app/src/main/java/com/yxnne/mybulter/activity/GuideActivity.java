package com.yxnne.mybulter.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yxnne.mybulter.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    //ViewPager
    private ViewPager mViewPager;
    //引导页1，2，3对应 res/layout下，page_item_1,2,3
    private View view1,view2,view3;
    //方View 的容器
    private List<View> mViewList = new ArrayList<>();
    //viewpager的指示小圆点
    private ImageView mIvPoint1,mIvPoint2,mIvPoint3;
    //跳过的按钮
    private TextView mTvSkip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {

        //指示小圆点
        mIvPoint1 = (ImageView) findViewById(R.id.iv_point1);
        mIvPoint2 = (ImageView) findViewById(R.id.iv_point2);
        mIvPoint3 = (ImageView) findViewById(R.id.iv_point3);
        //设置小圆点的始位置
        setIndicatorImage(0);

        mViewPager = (ViewPager) findViewById(R.id.vp_glide);
        //加载View
        view1 = View.inflate(this,R.layout.page_item_1,null);
        view2 = View.inflate(this,R.layout.page_item_2,null);
        view3 = View.inflate(this,R.layout.page_item_3,null);

        //第三页的进入按钮
        Button btnAccess = (Button) view3.findViewById(R.id.btn_access_app_guidepage3);
        btnAccess.setOnClickListener(this);

        //前两页的跳过文字
        mTvSkip = (TextView) findViewById(R.id.tv_skip_guide_guide);
        mTvSkip.setOnClickListener(this);

        //装在容器
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

        //Viewpager 设置适配器,这里不是继承FragmentPagerAdapter
        mViewPager.setAdapter(new GlideAdapter());
        //viewpager设置监听器
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setSkipState(position);
                setIndicatorImage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * 根据状态设置跳过的状态
     * @param position 第 position页时
     */
    private void setSkipState(int position) {
        if(position == 2 ){
            mTvSkip.setVisibility(View.GONE);

        }else{
            mTvSkip.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 根据状态设置指示小圆点的图片
     * @param i //第 i 页时
     */
    private void setIndicatorImage(int i) {
        switch(i) {
            //第 i 页时
            case 0:
                mIvPoint1.setImageResource(R.drawable.point_on);
                mIvPoint2.setImageResource(R.drawable.point_off);
                mIvPoint3.setImageResource(R.drawable.point_off);
                break;
            case 1:
                mIvPoint1.setImageResource(R.drawable.point_off);
                mIvPoint2.setImageResource(R.drawable.point_on);
                mIvPoint3.setImageResource(R.drawable.point_off);
                break;
            case 2:
                mIvPoint1.setImageResource(R.drawable.point_off);
                mIvPoint2.setImageResource(R.drawable.point_off);
                mIvPoint3.setImageResource(R.drawable.point_on);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_skip_guide_guide:
            case R.id.btn_access_app_guidepage3:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }


    private class GlideAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //实例化 单项
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));

            return mViewList.get(position);
        }
        //移除
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
            //super.destroyItem(container, position, object);
        }
    }
}
