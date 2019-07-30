package com.example.tictactoe;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class pager_addapter extends FragmentStatePagerAdapter {
    public pager_addapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i==0)
        {
            History_frag history_frag=new History_frag();
            i++;
            return history_frag;

        }
        else
        {
            Scoreboard_frag scoreboard_frag=new Scoreboard_frag();
            i++;
            return scoreboard_frag;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "History";
        else
            return "Score Board";

    }
}
