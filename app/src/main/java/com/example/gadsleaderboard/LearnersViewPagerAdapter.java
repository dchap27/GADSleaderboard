package com.example.gadsleaderboard;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LearnersViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public LearnersViewPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TopLearnerFragment();
            case 1:
                return new SkillIQFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.top_learners);
            case 1:
                return mContext.getString(R.string.skill_iq);
        }
        return super.getPageTitle(position);
    }
}
