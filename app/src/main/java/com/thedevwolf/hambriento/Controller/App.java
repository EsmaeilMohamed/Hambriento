package com.thedevwolf.hambriento.Controller;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.thedevwolf.hambriento.BuildConfig;
import com.thedevwolf.hambriento.Utils.ReleaseTree;
import com.thedevwolf.hambriento.View.Activity.LoginActivity;
import com.thedevwolf.hambriento.View.Activity.MainActivity;

import timber.log.Timber;

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ReleaseTree());
        }


        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this,Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);

    }
}
