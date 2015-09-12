package com.liudonghua.specialties.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.liudonghua.specialties.MapActivity;
import com.liudonghua.specialties.R;
import com.liudonghua.specialties.SpecialtiesApplication;
import com.liudonghua.specialties.utils.Constant;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import butterknife.BindArray;

/**
 * Created by liudonghua on 9/10/15.
 */
public class SimpleImageFragment extends Fragment {

    public static SimpleImageFragment newInstance(int backgroundResId) {
        SimpleImageFragment fragment = new SimpleImageFragment();
        fragment.backgroundResId = backgroundResId;
        return fragment;
    }

    private static final String KEY_BACKGROUNDRESID = "backgroundResId";

    private int backgroundResId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_BACKGROUNDRESID)) {
            backgroundResId = savedInstanceState.getInt(KEY_BACKGROUNDRESID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageView view = new ImageView(getContext());
        ViewGroup.LayoutParams lp =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(lp);
        view.setImageResource(backgroundResId);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_BACKGROUNDRESID, backgroundResId);
    }

}
