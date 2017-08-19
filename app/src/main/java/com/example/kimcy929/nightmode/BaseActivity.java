package com.example.kimcy929.nightmode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by kimcy929 on 8/19/2017.
 */

public class BaseActivity extends AppCompatActivity {

    protected void setNightMode(Bundle savedInstanceState, int mode) {
        if (savedInstanceState == null) {
            getDelegate().setLocalNightMode(mode);
            recreate();
        }
    }

    protected int getNightMode(int mode) {
        switch (mode) {
            case 0:
                return AppCompatDelegate.MODE_NIGHT_AUTO;

            case 1:
                return AppCompatDelegate.MODE_NIGHT_YES;

            case 2:
                return AppCompatDelegate.MODE_NIGHT_NO;

            case 3:
                return AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
        }
        return AppCompatDelegate.MODE_NIGHT_AUTO;
    }
}
