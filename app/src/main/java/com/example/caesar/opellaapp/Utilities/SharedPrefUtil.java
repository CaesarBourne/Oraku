package com.example.caesar.opellaapp.Utilities;


import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by caesar on 10/9/2018.
 */

public class SharedPrefUtil {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedEditor;
    //THIS BELOW IS THE NAME OF MY SHAREDPREFERENCES FILE that i store data
    private static final String APP_PREFS = "application_preferences";

    //an object with new as to be created when shared pref is used  to pass in the context into the constructor
    public SharedPrefUtil(Context context) {
        this.context = context;
    }

    public void saveString(String key, String value){
        sharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        //THIS BELOW gives a oject we can use to write to our created APP_PREFS file
        sharedEditor = sharedPreferences.edit();
        sharedEditor.putString(key, value);
        sharedEditor.commit();
    }


    public void saveInt(String key, int value){
        sharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        //THIS BELOW gives a oject we can use to write to our created APP_PREFS file
        sharedEditor = sharedPreferences.edit();
        sharedEditor.putInt(key, value);
        sharedEditor.commit();
    }


    public void saveBoolean(String key, Boolean value){
        sharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        //THIS BELOW gives a oject we can use to write to our created APP_PREFS file
        sharedEditor = sharedPreferences.edit();
        sharedEditor.putBoolean(key, value);
    }


    public String getString(String key){
        sharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        //this below retrieves the string in the APP_PREFS folder and returns null if nothing is there
        String savedString = sharedPreferences.getString(key, null);
        return savedString;
    }


    // if a default value is passed actibvate this guy below
    public String getString(String key, String defvalue){
        sharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        //this below retrieves the string in the APP_PREFS folder and returns null if nothing is there
        String savedString = sharedPreferences.getString(key, defvalue);
        return savedString;
    }

    public int getInt(String key){
        sharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        //this below retrieves the string in the APP_PREFS folder and returns null if nothing is there
        int savedInt = sharedPreferences.getInt(key, 0);
        return savedInt;
    }

    // if a default value is passed actibvate this guy below
    public int getInt(String key, int defValue){
        sharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        //this below retrieves the string in the APP_PREFS folder and returns null if nothing is there
        int savedInt = sharedPreferences.getInt(key, defValue);
        return savedInt;
    }

    // if a default value is passed actibvate this guy below
    public Boolean getBoolean(String key){
        sharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        //this below retrieves the string in the APP_PREFS folder and returns null if nothing is there
        boolean savedBoolean = sharedPreferences.getBoolean(key, false);
        return savedBoolean;
    }


    public Boolean getBoolean(String key, boolean defValue){
        sharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        //this below retrieves the string in the APP_PREFS folder and returns null if nothing is there
        boolean savedBoolean = sharedPreferences.getBoolean(key, defValue);
        return savedBoolean;
    }
    public void clear() {
        sharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }
}

