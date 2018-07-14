package com.thedevwolf.hambriento.View.Activity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.thedevwolf.hambriento.Base.BaseActivity;
import com.thedevwolf.hambriento.Callback.CuisineListener;
import com.thedevwolf.hambriento.Callback.NavigationCloseDrawerListener;
import com.thedevwolf.hambriento.GPS.GPSTracker;
import com.thedevwolf.hambriento.GPS.GPSTrakerListner;
import com.thedevwolf.hambriento.Model.CuisinesModel;
import com.thedevwolf.hambriento.Model.GeocodeModel;
import com.thedevwolf.hambriento.Network.ApiService;
import com.thedevwolf.hambriento.Network.RetrofitCall;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.View.Adapter.Recycler.CuisinesAdapter;
import com.thedevwolf.hambriento.View.Fragment.NavigationFragment;
import com.thedevwolf.hambriento.ViewModel.CuisinesViewModel;
import com.thedevwolf.hambriento.databinding.ActivityMainBinding;


import java.text.DecimalFormat;

import cn.pedant.SweetAlert.SweetAlertDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements CuisineListener {

    ActivityMainBinding mainBinding;

    SweetAlertDialog progressDialog;


    //GPS
    GPSTracker gpsTracker;

    CompositeDisposable disposable = new CompositeDisposable();
    ApiService apiService;

    //Adapters
    CuisinesAdapter cuisinesAdapter;

    NavigationFragment navigationFragment;

    //Res Var
    public static final String CUISINE_ID = "cuisine_id";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String CUISINE_NAME = "cuisine_name";

    double lat = 0;
    double lng = 0;



    @Override
    protected void init(Bundle savedInstanceState) {
        mainBinding = DataBindingUtil.setContentView(this, getLayoutRes());

        progressDialog=new SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE);

        apiService = RetrofitCall.getClient().create(ApiService.class);


        setUpToolbarConfig();

        setUpLocation();

        mainBinding.rvCuisine.setLayoutManager(new GridLayoutManager(this, 2));
        setUpCuisineData();
        setUpAdBanner();


    }

    private void setUpCuisineData() {


        ApiService apiService = RetrofitCall.getClient().create(ApiService.class);


        disposable.add(apiService.getGeoCodeCityId(lat, lng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<GeocodeModel>() {

                    @Override
                    public void onNext(GeocodeModel geocodeModel) {
                        getCuisinesData(geocodeModel.getLocation().getCity_id());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                }));

    }

    private void getCuisinesData(int city_id) {
        CuisinesViewModel cuisinesViewModel = ViewModelProviders.of(this).get(CuisinesViewModel.class);
        cuisinesViewModel.getCuisinesModelMutableLiveData(city_id, lat, lng)
                .observe(this, new Observer<CuisinesModel>() {
                    @Override
                    public void onChanged(@Nullable CuisinesModel cuisinesModel) {
                        Timber.e("%s", cuisinesModel.getCuisines().size());
                        cuisinesAdapter = new CuisinesAdapter(cuisinesModel, MainActivity.this);
                        mainBinding.rvCuisine.setAdapter(cuisinesAdapter);
                    }
                });

    }

    @SuppressLint("MissingPermission")
    private void setUpLocation() {


        gpsTracker = new GPSTracker(this, new GPSTrakerListner() {
            @Override
            public void onTrakerSuccess(Double lat, Double log) {

            }

            @Override
            public void onStartTraker() {

            }
        });
        //if gps failed to get location from first time

        if (gpsTracker.getLocation().getLongitude() == 0 && gpsTracker.getLocation().getLatitude() == 0) {
            gpsTracker = new GPSTracker(this, new GPSTrakerListner() {
                @Override
                public void onTrakerSuccess(Double lat, Double log) {

                }

                @Override
                public void onStartTraker() {

                }
            });


            DecimalFormat dFormat = new DecimalFormat("#.####");

            lat = Double.valueOf(dFormat.format(gpsTracker.getLocation().getLatitude()));
            lng = Double.valueOf(dFormat.format(gpsTracker.getLocation().getLongitude()));


        } else {

            DecimalFormat dFormat = new DecimalFormat("#.####");

            lat = Double.valueOf(dFormat.format(gpsTracker.getLocation().getLatitude()));
            lng = Double.valueOf(dFormat.format(gpsTracker.getLocation().getLongitude()));


        }


    }


    private void setUpAdBanner() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mainBinding.adView.loadAd(adRequest);
    }

    private void setUpToolbarConfig() {
        //set support action bar
        setSupportActionBar(mainBinding.toolbar.mainToolbar);
        //initial navigation fragment
        navigationFragment = new NavigationFragment();
        getSupportFragmentManager().beginTransaction()
                .add(mainBinding.menulayout.getId(), navigationFragment)
                .commit();

        //close menu when press on home item
        navigationFragment.setCloseDrawerListener(new NavigationCloseDrawerListener() {
            @Override
            public void onDrawerClose(Boolean b) {
                mainBinding.drawerlayout.closeMenu(b);
            }
        });

        mainBinding.toolbar.ivNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainBinding.drawerlayout.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
                mainBinding.drawerlayout.openMenu(false, Gravity.START);
            }
        });


    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }

    @Override
    public void onCuisineClickListener(int cuisineId, String cuisineName) {
        Bundle bundle = new Bundle();
        bundle.putInt(CUISINE_ID, cuisineId);
        bundle.putString(CUISINE_NAME, cuisineName);
        bundle.putDouble(LATITUDE, lat);
        bundle.putDouble(LONGITUDE, lng);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide=new Slide();
            slide.setSlideEdge(Gravity.START);
            slide.setDuration(1000);

            getWindow().setExitTransition(slide);
            getWindow().setReenterTransition(slide);
            startActivity(new Intent(this, RestaurantsActivity.class).putExtras(bundle),
                    ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
        }else{
            startActivity(new Intent(this, RestaurantsActivity.class).putExtras(bundle));
        }


    }

}
