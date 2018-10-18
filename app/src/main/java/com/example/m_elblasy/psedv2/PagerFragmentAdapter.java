package com.example.m_elblasy.psedv2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;

public class PagerFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

    protected static final int[] ICONS = new int[] {
            R.drawable.official,
            R.drawable.golden,
            R.drawable.platin,
            R.drawable.bronze
    };

    private int mCount = ICONS.length;

    public PagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new PagerFragment(ICONS[position]);
    }

    @Override
    public int getIconResId(int index) {
        return ICONS[index % ICONS.length];
    }

    @Override
    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}
