package com.checkfer.test.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.checkfer.test.R;
import com.checkfer.test.models.LawyerInstance;
import com.checkfer.test.fragments.LawyerListFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    public static final int[] TAB_TITLES = new int[]{R.string.tab_featured, R.string.tab_all, R.string.tab_favs};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return LawyerListFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return getNumberOfLawyersForTab(position);
    }

    private String getNumberOfLawyersForTab(int position){

        switch (TAB_TITLES[position]){
            case R.string.tab_featured : {
                return mContext.getResources().getString(TAB_TITLES[position], LawyerInstance.getNumberOfFeaturedLawyers());
            }
            case R.string.tab_all : {
                return mContext.getResources().getString(TAB_TITLES[position], LawyerInstance.getNumberOfLawyers());
            }
            case R.string.tab_favs : {
                return mContext.getResources().getString(TAB_TITLES[position], LawyerInstance.getNumberOfFavouriteLawyers());
            }

            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }
    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}