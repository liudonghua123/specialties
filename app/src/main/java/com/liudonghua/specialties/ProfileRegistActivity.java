package com.liudonghua.specialties;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liudonghua on 9/10/15.
 */
public class ProfileRegistActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.profile_regist);
        setContentView(R.layout.fragment_profile_regist);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.profile_regist_login)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_regist_login:
                Intent intent = new Intent(this, ProfileLoginActivity.class);
                startActivity(intent);
                break;
        }

    }
}
