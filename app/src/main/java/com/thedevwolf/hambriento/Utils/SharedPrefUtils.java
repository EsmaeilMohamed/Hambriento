package com.thedevwolf.hambriento.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {
    private static SharedPrefUtils mInstance;
    private Context mCtx;

    //Shared Pref Key
    private static final String SHARED_PREF_KEY="shared_key";

    //Keys
    private static final String SLIDE_INTRO="slide_intro";

    private SharedPrefUtils(Context context){
            mCtx=context;

    }

    public static synchronized SharedPrefUtils getInstance(Context context){
        if (mInstance==null){
            mInstance=new SharedPrefUtils(context);
        }
        return mInstance;
    }

    public void slideIntroFinish(Boolean isFinished){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_KEY,0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(SLIDE_INTRO,isFinished);
        editor.apply();
    }


    public boolean isSlideFinished(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_KEY,0);
        return sharedPreferences.getBoolean(SLIDE_INTRO,false);
    }


}
