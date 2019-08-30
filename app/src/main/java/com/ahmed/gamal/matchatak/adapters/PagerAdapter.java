package com.ahmed.gamal.matchatak.adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ahmed.gamal.matchatak.ui.MatchesFragment;
import com.ahmed.gamal.matchatak.ui.TeamsFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int id;
    private int season;

    public PagerAdapter(FragmentManager fm, int id, int season) {
        super(fm);
        this.id = id;
        this.season = season;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return MatchesFragment.newInstance(id, season);
        } else if (position == 1)
            return TeamsFragment.newInstance(id);
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return "Matches";
        }
        if (position==1){
            return "Teams";
        }
        return super.getPageTitle(position);

    }

    @Override
    public int getCount() {
        return 2;
    }
}
