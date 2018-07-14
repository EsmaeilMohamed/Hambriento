package com.thedevwolf.hambriento.View.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.thedevwolf.hambriento.Base.BaseActivity;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.Utils.SharedPrefUtils;

import timber.log.Timber;

public class SplashActivity extends BaseActivity {

    FirebaseAuth mFirebaseAuth;



    @Override
    protected void init(Bundle savedInstanceState) {

        mFirebaseAuth=FirebaseAuth.getInstance();


        Thread thread=new Thread(){

            @Override
            public void run() {
                try {
                    sleep(3000);

                    if (SharedPrefUtils.getInstance(getApplicationContext()).isSlideFinished()){
                        if (mFirebaseAuth.getCurrentUser()!=null){
                            startActivity(new Intent(SplashActivity.this,MainActivity.class));
                        }else{
                            startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                        }

                    }else{
                        startActivity(new Intent(SplashActivity.this,SlideIntroActivity.class));
                    }


                }catch (InterruptedException e){
                    Timber.e(e);
                }


            }
        };

        thread.start();

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_splash;
    }
}
