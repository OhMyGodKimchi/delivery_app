package com.example.start;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.start.main.DetailFoodActivty;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity2 extends AppCompatActivity {

    public int num;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);





        Intent intent = getIntent();
        int country = intent.getExtras().getInt("country");


        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("한식"));
        tabLayout.addTab(tabLayout.newTab().setText("일식"));
        tabLayout.addTab(tabLayout.newTab().setText("중식"));

        ViewPager viewPager = findViewById(R.id.view_page);

       DetailPageAdapter detailPageAdapter = new DetailPageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

       viewPager.setAdapter(detailPageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Log.d("number","what "+tab.getPosition());




            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setCurrentItem(country, true);



    }
    public int getPosition(int num){
        return this.num = num;
    }
}