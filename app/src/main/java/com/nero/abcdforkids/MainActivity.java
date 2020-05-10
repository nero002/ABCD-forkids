package com.nero.abcdforkids;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.nero.abcdforkids.models.Alphabet;
import com.nero.abcdforkids.resources.Alphabets;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //wigets
    private ViewPager mMyViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
       mMyViewPager = findViewById(R.id.view_pager);

       ImageButton back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageButton last_btn = findViewById(R.id.last_btn);
        ImageButton next_btn = findViewById(R.id.next_btn);

        last_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyViewPager.setCurrentItem(mMyViewPager.getCurrentItem() - 1, true);
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyViewPager.setCurrentItem(mMyViewPager.getCurrentItem() + 1, true);
            }
        });


        init();
    }

    private void init() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        Alphabet[] alphabets = Alphabets.getAlphabets();
        for (Alphabet alphabet : alphabets) {
            ViewPagerItemFragment fragment = ViewPagerItemFragment.getInstance(alphabet);
            fragments.add(fragment);
        }
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        mMyViewPager.setAdapter(pagerAdapter);
        }

}


