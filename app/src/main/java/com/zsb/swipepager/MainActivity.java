package com.zsb.swipepager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private Fragment1 mfragment1;
    private Fragment2 mfragment2;
    private Fragment3 mfragment3;

    private List<Fragment> fragments;    //页面列表
    private List<String> titleList = new ArrayList<String>(); //标题列表
    //通过pagerTabStrip可以设置标题的属性
    private PagerTabStrip pagerTabStrip;
    private PagerTitleStrip pagerTitleStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPager();
    }

    void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagertab);

        //设置下划线颜色
        pagerTabStrip.setTabIndicatorColor(
                getResources().getColor(android.R.color.holo_green_dark));
        //设置背景颜色
        pagerTabStrip.setBackgroundColor(
                getResources().getColor(android.R.color.holo_blue_bright));

//        pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pagertitle);
//        pagerTitleStrip.setBackgroundColor(
//                getResources().getColor(android.R.color.holo_blue_bright));


        mfragment1 = new Fragment1();
        mfragment2 = new Fragment2();
        mfragment3 = new Fragment3();

        fragments = new ArrayList<Fragment>();
        fragments.add(mfragment1);
        fragments.add(mfragment2);
        fragments.add(mfragment3);

        titleList.add("第1页");
        titleList.add("第2页");
        titleList.add("第3页");

        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}
