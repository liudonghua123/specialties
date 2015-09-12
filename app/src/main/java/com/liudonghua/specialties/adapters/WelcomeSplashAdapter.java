package com.liudonghua.specialties.adapters;

import android.app.Activity;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.liudonghua.specialties.R;
import com.liudonghua.specialties.fragments.SplashFragment;

//import butterknife.BindArray;
import butterknife.ButterKnife;

/**
 * Created by liudonghua on 9/10/15.
 */
public class WelcomeSplashAdapter extends FragmentPagerAdapter {

    TypedArray backgroundImages;

    //@BindArray(R.array.splash_content)
    String[] contents;

    public WelcomeSplashAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        //ButterKnife.bind(activity, activity.findViewById(android.R.id.content));
        backgroundImages = activity.getResources().obtainTypedArray(R.array.splash_background_image);
        contents = activity.getResources().getStringArray(R.array.splash_content);
    }

    @Override
    public Fragment getItem(int position) {
        return SplashFragment.newInstance(position,
                contents[position],
                backgroundImages.getResourceId(position, -1),
                position == contents.length - 1);
    }

    @Override
    public int getCount() {
        return contents.length;
    }
}
