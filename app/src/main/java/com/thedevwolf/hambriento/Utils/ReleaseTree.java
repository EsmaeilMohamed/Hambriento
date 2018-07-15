package com.thedevwolf.hambriento.Utils;

import android.util.Log;

import timber.log.Timber;

public class ReleaseTree extends Timber.Tree {

    public static final int MESSAGE_LENGTH=4000;
    @Override
    protected boolean isLoggable(String tag, int priority) {
        return priority != Log.VERBOSE && priority != Log.DEBUG && priority != Log.INFO;
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (isLoggable(tag,priority)){
            if (message.length()<MESSAGE_LENGTH){
                Log.wtf(tag,message);
            }else{
                Log.println(priority,tag,message);
            }
        }
    }


}