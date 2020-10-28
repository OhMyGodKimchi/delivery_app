package com.example.start;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;



public class DetailPageAdapter extends FragmentStatePagerAdapter {

   private KfoodFragment kfoodFragment = new KfoodFragment();
   private JfoodFragment jfoodFragment = new JfoodFragment();
   private CfoodFragment cfoodFragment = new CfoodFragment();

    int pagecount;
    public DetailPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        pagecount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return kfoodFragment;

            case 1:
                return jfoodFragment;

            case 2:
                return cfoodFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return pagecount;
    }
}
