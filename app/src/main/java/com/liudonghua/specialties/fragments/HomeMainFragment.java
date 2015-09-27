package com.liudonghua.specialties.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liudonghua.specialties.R;
import com.liudonghua.specialties.adapters.HomeNavAdapter;
import com.viewpagerindicator.PageIndicator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liudonghua on 9/10/15.
 */
public class HomeMainFragment extends Fragment {

    HomeNavAdapter mAdapter;
    @Bind(R.id.nav_pager)
    ViewPager mPager;
    @Bind(R.id.nav_indicator)
    PageIndicator mIndicator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((HomeFragment)getParentFragment()).setTitle(R.string.home_bottombar_text_main);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_main, null);
        ButterKnife.bind(getActivity(), view);

        mPager = (ViewPager) view.findViewById(R.id.nav_pager);
        mIndicator = (PageIndicator) view.findViewById(R.id.nav_indicator);
        mAdapter = new HomeNavAdapter(getChildFragmentManager());
        mPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mPager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
