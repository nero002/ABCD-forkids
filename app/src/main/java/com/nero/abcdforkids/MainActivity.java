package com.nero.abcdforkids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.nero.abcdforkids.models.Alphabet;
import com.nero.abcdforkids.resources.Alphabets;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //wigets
    private ViewPager mMyViewPager;
    private TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tab_layout);

        init();
    }
    private void init(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        Alphabet[]alphabets = Alphabets.getAlphabets();
        for (Alphabet alphabet: alphabets){
            ViewPagerItemFragment fragment = ViewPagerItemFragment.getInstance(alphabet);
            fragments.add(fragment);
        }
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        mMyViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mMyViewPager, true);
    }
}
