package com.thedevwolf.hambriento.View.Activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.location.LocationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.thedevwolf.hambriento.Base.BaseActivity;
import com.thedevwolf.hambriento.GPS.GPSTracker;
import com.thedevwolf.hambriento.GPS.GPSTrakerListner;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.Utils.Utils;
import com.thedevwolf.hambriento.databinding.ActivityLoginBinding;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import es.dmoral.toasty.Toasty;
import timber.log.Timber;

public class LoginActivity extends BaseActivity {


    ActivityLoginBinding loginBinding;

    FirebaseAuth mAuth;

    GPSTracker gpsTracker;
    LocationManager locationManager;
    boolean gps_enabled = false;
    boolean network_enabled = false;
    //Rec Var
    private static int RC_SIGN_IN = 120;

    @Override
    protected void init(Bundle savedInstanceState) {

        loginBinding = DataBindingUtil.setContentView(this, getLayoutRes());

        mAuth = FirebaseAuth.getInstance();

        gpsTracker = new GPSTracker(this, new GPSTrakerListner() {
            @Override
            public void onTrakerSuccess(Double lat, Double log) {

            }

            @Override
            public void onStartTraker() {

            }
        });


        loginBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLogin();
            }
        });


    }

    private void startLogin() {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            Utils.goToLocationPermissionSettings(LoginActivity.this);
                        } else if (report.areAllPermissionsGranted()) {
                            if (enableLocation()) {

                                if (Utils.isNetworkAvailable(getApplicationContext())){
                                    startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
                                            .setAvailableProviders(Arrays.asList(
                                                    new AuthUI.IdpConfig.GoogleBuilder().build()))
                                            .build(), RC_SIGN_IN);
                                }else{
                                    Toasty.warning(getApplicationContext(),getString(R.string.check_connection),Toast.LENGTH_SHORT,true).show();
                                }

                            }


                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                })
                .onSameThread()
                .check();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    private boolean enableLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
            assert locationManager != null;
            gps_enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
            Timber.wtf(ex);
        }

        try {
            assert locationManager != null;
            network_enabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
            Timber.wtf(ex);
        }

        gpsTracker.getLocation();
        if (!gpsTracker.canGetLocation() && !gps_enabled && !network_enabled) {
            Utils.goToLocationSettings(this);
            return false;
        }
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {

                startActivity(new Intent(LoginActivity.this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                finish();
            } else {
                if (response == null) {
                    Timber.e("Sign In Cancelled");
                    return;
                }
                if (Objects.requireNonNull(response.getError()).getErrorCode() == ErrorCodes.NO_NETWORK) {

                    return;
                }
                Timber.e("Sign in error, try again!");
            }
        }
    }
}
