package com.mrabid.pamedhisjav.fragment.Resep;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mrabid.pamedhisjav.fragment.History.HistoryFragment;
import com.mrabid.pamedhisjav.fragment.MyResep.MyResepFragment;

public class ResepFragmentPagerAdapter extends FragmentStatePagerAdapter {
    int numTabs;

    public ResepFragmentPagerAdapter(int numTabs,FragmentManager fm) {
        super(fm);
        this.numTabs = numTabs;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new HistoryFragment();
        } else if (i == 1){
            return new MyResepFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numTabs;
    }

}
