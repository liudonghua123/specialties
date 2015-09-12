package com.liudonghua.specialties;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by liudonghua on 9/11/15.
 */
public class SpecialtiesApplication extends Application {

    private static SpecialtiesApplication application;
    private static SharedPreferences preferences;

    public static SpecialtiesApplication getApplication() {
        return application;
    }

    public static SharedPreferences getDefaultPreferences() {
        return preferences;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        preferences = getApplication().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);

    }
}
