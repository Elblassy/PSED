package com.example.m_elblasy.psedv2.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.m_elblasy.psedv2.PagerFragmentAdapter;
import com.example.m_elblasy.psedv2.R;
import com.viewpagerindicator.CirclePageIndicator;

public class SplashScreen extends FragmentActivity {

    private static int SPLASH_TIME_OUT = 3000;
    PagerFragmentAdapter mAdapter;
    ViewPager mPager;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        button = findViewById(R.id.skip);
        mAdapter = new PagerFragmentAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 3) {
                    button.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onPageSelected(int position) {
                System.out.println("selected page is :" + position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        CirclePageIndicator mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;
        mIndicator.setRadius(7 * density);
        mIndicator.setStrokeWidth(1 * density);
    }

    public void skip(View view) {
        Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(homeIntent);
        finish();
    }
       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);*/

}

