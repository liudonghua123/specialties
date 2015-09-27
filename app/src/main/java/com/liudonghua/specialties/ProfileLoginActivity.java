package com.liudonghua.specialties;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liudonghua on 9/10/15.
 */
public class ProfileLoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.profile_login);
        setContentView(R.layout.fragment_profile_login);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.profile_login_regist)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_login_regist:
                Intent intent = new Intent(this, ProfileRegistActivity.class);
                startActivity(intent);
                break;
        }

    }
}
