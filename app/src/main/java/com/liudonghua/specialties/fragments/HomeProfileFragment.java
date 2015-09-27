package com.liudonghua.specialties.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liudonghua.specialties.ProfileLoginActivity;
import com.liudonghua.specialties.R;
import com.liudonghua.specialties.adapters.ProfileListAdapter;
import com.liudonghua.specialties.utils.SpacesItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liudonghua on 9/10/15.
 */
public class HomeProfileFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((HomeFragment)getParentFragment()).setTitle(R.string.home_bottombar_text_profile);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_profile, null);
        ButterKnife.bind(this, view);



        return view;
    }

    @OnClick(R.id.profile_click_to_login)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_click_to_login:
                Intent intent = new Intent(getContext(), ProfileLoginActivity.class);
                getActivity().startActivity(intent);
        }

    }


}
