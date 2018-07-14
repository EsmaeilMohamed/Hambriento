package com.thedevwolf.hambriento.View.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.android.gms.ads.AdRequest;
import com.thedevwolf.hambriento.Base.BaseActivity;
import com.thedevwolf.hambriento.Callback.RestaurantListener;
import com.thedevwolf.hambriento.Model.RestaurantsModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.View.Adapter.Recycler.RestaurantAdapter;
import com.thedevwolf.hambriento.ViewModel.RestaurantsViewModel;
import com.thedevwolf.hambriento.databinding.ActivityRestaurantsBinding;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RestaurantsActivity extends BaseActivity implements RestaurantListener {


    ActivityRestaurantsBinding restaurantsBinding;


    //Adapter
    RestaurantAdapter restaurantAdapter;
    //Rec Var
    int cuisineId;
    String cuisineName;
    double lat;
    double lng;
    public static final String RESTAURANT_DATA="restaurant_data";
    public static final String RESTAURANT_RATING="restaurant_rating";
    public static final String RESTAURANT_LOCATION="restaurant_location";

    @Override
    protected void init(Bundle savedInstanceState) {

        restaurantsBinding= DataBindingUtil.setContentView(this,getLayoutRes());





        restaurantsBinding.spinKit.setIndeterminateDrawable(new DoubleBounce());


        if (getIntent().getExtras()!=null){
            cuisineId=getIntent().getExtras().getInt(MainActivity.CUISINE_ID);
            cuisineName=getIntent().getExtras().getString(MainActivity.CUISINE_NAME);
            lat=getIntent().getExtras().getDouble(MainActivity.LATITUDE);
            lng=getIntent().getExtras().getDouble(MainActivity.LONGITUDE);
        }
        setUpToolbarConfig();
        setUpAdBanner();


        restaurantsBinding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        fetchData();





    }

    private void setUpAdBanner() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        restaurantsBinding.adView.loadAd(adRequest);
    }

    private void setUpToolbarConfig() {
        setSupportActionBar(restaurantsBinding.toolbar.titleToolbar);
        restaurantsBinding.toolbar.tvTitle.setText(cuisineName);
        restaurantsBinding.toolbar.ivNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestaurantsActivity.super.onBackPressed();
            }
        });

    }

    private void fetchData() {
        RestaurantsViewModel restaurantsViewModel= ViewModelProviders.of(this).get(RestaurantsViewModel.class);
        restaurantsViewModel.getRestaurantsModelMutableLiveData(lat,lng,cuisineId)
                .observe(this, new Observer<RestaurantsModel>() {
                    @Override
                    public void onChanged(@Nullable RestaurantsModel restaurantsModel) {
                        assert restaurantsModel != null;
                        if (restaurantsModel.getRestaurants().size()>0){
                            restaurantAdapter=new RestaurantAdapter(restaurantsModel,RestaurantsActivity.this);
                            restaurantsBinding.recyclerView.setAdapter(restaurantAdapter);
                            restaurantsBinding.spinKit.setVisibility(View.GONE);
                            restaurantsBinding.recyclerView.setVisibility(View.VISIBLE);
                            restaurantsBinding.adView.setVisibility(View.VISIBLE);


                        }else{
                            restaurantsBinding.spinKit.setVisibility(View.GONE);
                            restaurantsBinding.tvNoRestaurantLbl.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_restaurants;
    }

    @Override
    public void OnRestaurantClickListener(RestaurantsModel.RestaurantsData.RestaurantData restaurantData) {


        Bundle bundle=new Bundle();
        bundle.putParcelable(RESTAURANT_DATA,restaurantData);
        bundle.putParcelable(RESTAURANT_LOCATION,restaurantData.getLocation());
        bundle.putParcelable(RESTAURANT_RATING,restaurantData.getUser_rating());
        startActivity(new Intent(this,RestaurantDetailsActivity.class).putExtras(bundle));





    }



}
