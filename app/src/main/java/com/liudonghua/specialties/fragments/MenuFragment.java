package com.liudonghua.specialties.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.liudonghua.specialties.MainActivity;
import com.liudonghua.specialties.R;

/**
 * Created by liudonghua on 9/10/15.
 */
public class MenuFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_list, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] menus = getResources().getStringArray(R.array.menu_names);
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, menus);
        setListAdapter(colorAdapter);
    }

    @Override
    public void onListItemClick(ListView lv, View v, int position, long id) {
        Fragment contentFragment = null;
        switch (position) {
            case 0:
                contentFragment = new HomeFragment();
                break;
            case 1:
                contentFragment = new CategoryFragment();
                break;
            case 2:
                contentFragment = new SettingsFragment();
                break;
            case 3:
                contentFragment = new AboutFragment();
                break;
        }
        if (contentFragment != null)
            switchFragment(contentFragment);
    }

    private void switchFragment(Fragment fragment) {
        if (getActivity() == null)
            return;

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.switchContent(fragment);
    }
}
