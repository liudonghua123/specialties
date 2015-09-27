package com.liudonghua.specialties.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liudonghua.specialties.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liudonghua on 9/10/15.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

//    @Bind(R.id.home_bottom_main)
//    LinearLayout buttonMain;
//    @Bind(R.id.home_bottom_forum)
//    LinearLayout buttonForum;
//    @Bind(R.id.home_bottom_shoppingcart)
//    LinearLayout buttonShoppingcart;
//    @Bind(R.id.home_bottom_profile)
//    LinearLayout buttonProfile;

    @Bind(R.id.home_title_text_view)
    TextView homeTitleTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getChildFragmentManager().beginTransaction().replace(R.id.home_main_container, new HomeMainFragment()).commit();
    }

    @OnClick({R.id.home_bottom_main, R.id.home_bottom_location, R.id.home_bottom_share, R.id.home_bottom_shoppingcart, R.id.home_bottom_profile})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_bottom_main:
                getChildFragmentManager().beginTransaction().replace(R.id.home_main_container, new HomeMainFragment()).commit();
                break;
            case R.id.home_bottom_location:
                getChildFragmentManager().beginTransaction().replace(R.id.home_main_container, new HomeLocationFragment()).commit();
                break;
            case R.id.home_bottom_share:
                getChildFragmentManager().beginTransaction().replace(R.id.home_main_container, new HomeShareFragment()).commit();
                break;
            case R.id.home_bottom_shoppingcart:
                getChildFragmentManager().beginTransaction().replace(R.id.home_main_container, new HomeShoppingcartFragment()).commit();
                break;
            case R.id.home_bottom_profile:
                getChildFragmentManager().beginTransaction().replace(R.id.home_main_container, new HomeProfileFragment()).commit();
                break;
        }
    }

    public void setTitle(int resId) {
        homeTitleTextView.setText(resId);
    }
}
