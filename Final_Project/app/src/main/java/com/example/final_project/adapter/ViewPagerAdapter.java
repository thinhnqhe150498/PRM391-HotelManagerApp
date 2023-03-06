package com.example.final_project.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.final_project.fragment.Fragment1;
import com.example.final_project.fragment.Fragment2;
import com.example.final_project.fragment.Fragment3;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
            default:
                return new Fragment3();

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
