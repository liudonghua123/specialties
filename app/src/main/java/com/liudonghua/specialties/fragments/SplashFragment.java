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

import com.liudonghua.specialties.MainActivity;
import com.liudonghua.specialties.MapActivity;
import com.liudonghua.specialties.R;
import com.liudonghua.specialties.SpecialtiesApplication;
import com.liudonghua.specialties.utils.Constant;

import butterknife.Bind;
//import butterknife.BindArray;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liudonghua on 9/10/15.
 */
public class SplashFragment extends Fragment {

    public static SplashFragment newInstance(int index, String content, int backgroundResId, boolean isLast) {
        SplashFragment fragment = new SplashFragment();
        fragment.index = index;
        fragment.content = content;
        fragment.backgroundResId = backgroundResId;
        fragment.isLast = isLast;
        return fragment;
    }

    private static final String KEY_INDEX = "index";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_BACKGROUNDRESID = "backgroundResId";
    private static final String KEY_ISLAST = "isLast";

    private int index;
    private String content;
    private int backgroundResId;
    private boolean isLast;

    @Bind(R.id.splash_background_imageview)
    ImageView backgroundImageView;

    @Bind(R.id.splash_content_textview)
    TextView contentTextView;

    @Bind(R.id.splash_enter_button)
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_INDEX)) {
            index = savedInstanceState.getInt(KEY_INDEX);
        }
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            content = savedInstanceState.getString(KEY_CONTENT);
        }
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_BACKGROUNDRESID)) {
            backgroundResId = savedInstanceState.getInt(KEY_BACKGROUNDRESID);
        }
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_ISLAST)) {
            isLast = savedInstanceState.getBoolean(KEY_ISLAST);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        ButterKnife.bind(this, view);
        button.setVisibility(isLast ? View.VISIBLE : View.GONE);
        contentTextView.setText(content);
        backgroundImageView.setImageResource(backgroundResId);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX, index);
        outState.putString(KEY_CONTENT, content);
        outState.putInt(KEY_BACKGROUNDRESID, backgroundResId);
        outState.putBoolean(KEY_ISLAST, isLast);
    }

    @OnClick(R.id.splash_enter_button)
    void enter() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
        // set is_first preference to false
        SpecialtiesApplication.getDefaultPreferences().edit().putBoolean(Constant.PREF_KEY_IS_FIRST, false).commit();
    }
}
