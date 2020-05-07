package test.app.myapplication;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public class MainApplication extends Application {
    public static MainApplication getInstance() {
        return instance;
    }

    private static final String APP_PREFERENCES = "settings";
    private static final String APP_PREFERENCES_DARK_MODE = "settings_dark_mode";

    private static MainApplication instance;

    private boolean currentMode;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SharedPreferences sharedPref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        currentMode = sharedPref.getBoolean(APP_PREFERENCES_DARK_MODE, false);
        updateNightMode();
    }
    private void updateNightMode() {
        AppCompatDelegate.setDefaultNightMode(currentMode ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
    }
    public boolean getCurrentNightMode() {
        return currentMode;
    }
    public void setCurrentNightMode(boolean value) {
        if (currentMode != value) {
            currentMode = value;
            SharedPreferences sharedPref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean(APP_PREFERENCES_DARK_MODE, value);
            editor.apply();

            updateNightMode();
        }
    }
}
