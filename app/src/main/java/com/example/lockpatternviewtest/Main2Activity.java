package com.example.lockpatternviewtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mylibrary.ViewPagerIndicator;

public class Main2Activity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerIndicator viewPagerIndicator;
    String[] title = {"头条","八卦","娱乐","亲子节目","大漩涡","我的收藏","系统文件","设置"};
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPagerIndicator = (ViewPagerIndicator) findViewById(R.id.view_Pager_indicator);
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return NewFragment.getInstance(title[position]);
            }

            @Override
            public int getCount() {
                return title.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        };
        viewPager.setAdapter(adapter);
        viewPagerIndicator.setViewPager(viewPager);

    }

}
