package com.nero.abcdforkids;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mFragments;
    public MyPagerAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        mFragments  = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {

        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
