package com.thedevwolf.hambriento.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        init(savedInstanceState);
    }


    protected abstract void init(Bundle savedInstanceState);

    protected abstract int getLayoutRes();

}
