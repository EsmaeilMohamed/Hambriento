package com.thedevwolf.hambriento.View.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.Utils.SharedPrefUtils;
import com.thedevwolf.hambriento.View.Fragment.SampleSlide;



public class SlideIntroActivity extends AppIntro {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
         addSlide(SampleSlide.newInstance(R.layout.fragment_first));
        addSlide(SampleSlide.newInstance(R.layout.fragment_second));
        addSlide(SampleSlide.newInstance(R.layout.fragment_third));
        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(getResources().getColor(R.color.colorPrimary));
        setSeparatorColor(getResources().getColor(R.color.colorPrimary));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.


        setFadeAnimation();

        setVibrate(true);
        setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        SharedPrefUtils.getInstance(this).slideIntroFinish(true);
        startActivity(new Intent(this, LoginActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK));

    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        SharedPrefUtils.getInstance(this).slideIntroFinish(true);
        startActivity(new Intent(this, LoginActivity.class)
        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }



}
