package com.checkfer.test.models;

import android.os.Build;

import com.checkfer.test.R;
import com.checkfer.test.adapter.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is not a singleton instance - This is just somewhere to put an ArrayList
 * Normally you'd get this data from JSON either from assets / Http Request using Retrofit or OkHttp
 */
public class LawyerInstance {

    private static final ArrayList<LawyerModel> lawyers = new ArrayList<>();

    public static void init() {
        for (int i = 0; i < 20; i++) {
            lawyers.add(new LawyerModel());
        }
    }

    public static long getNumberOfFeaturedLawyers() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return lawyers.stream().filter(LawyerModel::isFeatured).count();
        } else {
            int count = 0;
            for (LawyerModel lawyer : lawyers) {
                if (lawyer.isFeatured()) count++;
            }
            return count;
        }
    }

    public static long getNumberOfFavouriteLawyers() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return lawyers.stream().filter(LawyerModel::getFavourite).count();
        } else {
            int count = 0;
            for (LawyerModel lawyer : lawyers) {
                if (lawyer.getFavourite()) count++;
            }
            return count;
        }
    }

    public static long getNumberOfLawyers() {
        return lawyers.size();
    }

    private static List<LawyerModel> getFeaturedLawyers() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return lawyers.stream().filter(LawyerModel::isFeatured).collect(Collectors.toList());
        } else {
            List<LawyerModel> lawyerModel = new ArrayList<>();
            for (LawyerModel lawyer : lawyers) {
                if (lawyer.isFeatured()) lawyerModel.add(lawyer);
            }
            return lawyerModel;
        }
    }

    private static List<LawyerModel> getFavouriteLawyers() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return lawyers.stream().filter(LawyerModel::getFavourite).collect(Collectors.toList());
        } else {
            List<LawyerModel> lawyerModel = new ArrayList<>();
            for (LawyerModel lawyer : lawyers) {
                if (lawyer.getFavourite()) lawyerModel.add(lawyer);
            }
            return lawyerModel;
        }
    }

    public static List<LawyerModel> getLawyers(int position) {
        switch (SectionsPagerAdapter.TAB_TITLES[position - 1]) {
            case R.string.tab_featured: {
                return getFeaturedLawyers();
            }
            case R.string.tab_favs: {
                return getFavouriteLawyers();
            }
            default: {
                return getAllLawyers();
            }
        }
    }

    private static List<LawyerModel> getAllLawyers() {
        return lawyers;
    }
}