package com.liudonghua.specialties;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.liudonghua.specialties.adapters.WelcomeSplashAdapter;
import com.liudonghua.specialties.utils.Constant;
import com.viewpagerindicator.PageIndicator;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {

    WelcomeSplashAdapter mAdapter;
    @Bind(R.id.pager)
    ViewPager mPager;
    @Bind(R.id.indicator)
    PageIndicator mIndicator;

    private static final int STARTUP_TIMEOUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //SpecialtiesApplication application = SpecialtiesApplication.getApplication();
        SharedPreferences preferences = SpecialtiesApplication.getDefaultPreferences();
        boolean isFirstStartup = preferences.getBoolean(Constant.PREF_KEY_IS_FIRST, true);
        if(isFirstStartup) {
            setContentView(R.layout.activity_welcome);
            ButterKnife.bind(this);
            mAdapter = new WelcomeSplashAdapter(getSupportFragmentManager(), this);
            mPager.setAdapter(mAdapter);
            mIndicator.setViewPager(mPager);
        }
        else {
            setContentView(R.layout.activity_startup);
            final Activity activity = this;
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    // start main activity
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                }
            }, STARTUP_TIMEOUT);
        }
    }

}
