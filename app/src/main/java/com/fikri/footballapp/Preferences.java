package com.fikri.footballapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    static final String KEY_VIEW ="list";
    static final String KEY_MODE = "light";

    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setView(Context context, String view){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_VIEW, view);
        editor.apply();
    }

    public static String getView(Context context){
        return getSharedPreference(context).getString(KEY_VIEW,"");
    }

    public static void setMode(Context context,boolean mode){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(KEY_MODE,mode);
        editor.apply();
    }

    public static boolean getMode(Context context){
        return getSharedPreference(context).getBoolean(KEY_MODE,false);
    }
}
