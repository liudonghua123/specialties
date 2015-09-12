package com.liudonghua.specialties.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.liudonghua.specialties.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liudonghua on 9/10/15.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.home_bottom_main_button)
    ImageButton buttonMain;
    @Bind(R.id.home_bottom_forum_button)
    ImageButton buttonForum;
    @Bind(R.id.home_bottom_shoppingcart_button)
    ImageButton buttonShoppingcart;
    @Bind(R.id.home_bottom_profile_button)
    ImageButton buttonProfile;

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

    @OnClick({R.id.home_bottom_main_button, R.id.home_bottom_forum_button, R.id.home_bottom_shoppingcart_button, R.id.home_bottom_profile_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_bottom_main_button:
                getChildFragmentManager().beginTransaction().replace(R.id.home_main_container, new HomeMainFragment()).commit();
                break;
            case R.id.home_bottom_forum_button:
                getChildFragmentManager().beginTransaction().replace(R.id.home_main_container, new HomeForumFragment()).commit();
                break;
            case R.id.home_bottom_shoppingcart_button:
                getChildFragmentManager().beginTransaction().replace(R.id.home_main_container, new HomeShoppingcartFragment()).commit();
                break;
            case R.id.home_bottom_profile_button:
                getChildFragmentManager().beginTransaction().replace(R.id.home_main_container, new HomeProfileFragment()).commit();
                break;
        }
    }
}
