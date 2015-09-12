package com.liudonghua.specialties.adapters;

import android.app.Activity;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.liudonghua.specialties.R;
import com.liudonghua.specialties.fragments.SimpleImageFragment;
import com.liudonghua.specialties.fragments.SplashFragment;

//import butterknife.BindArray;


/**
 * Created by liudonghua on 9/10/15.
 */
public class HomeNavAdapter extends FragmentPagerAdapter {

    int[] imageResIds = {R.drawable.specialty_1, R.drawable.specialty_2, R.drawable.specialty_3};

    public HomeNavAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return SimpleImageFragment.newInstance(imageResIds[position]);
    }

    @Override
    public int getCount() {
        return imageResIds.length;
    }
}
