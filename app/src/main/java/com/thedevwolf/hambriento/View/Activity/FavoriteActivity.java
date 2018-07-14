package com.thedevwolf.hambriento.View.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.thedevwolf.hambriento.Base.BaseActivity;
import com.thedevwolf.hambriento.Callback.FavoriteListener;
import com.thedevwolf.hambriento.Database.RestaurantModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.View.Adapter.Recycler.FavoriteAdapter;
import com.thedevwolf.hambriento.ViewModel.RestaurantViewModel;
import com.thedevwolf.hambriento.databinding.ActivityFavoriteBinding;

import java.util.List;

public class FavoriteActivity extends BaseActivity implements FavoriteListener {

    ActivityFavoriteBinding favoriteBinding;

    FavoriteAdapter favoriteAdapter;

    //Rec Var
    public static final String RESTAURANT_MODEL="restaurant_model";

    @Override
    protected void init(Bundle savedInstanceState) {
        favoriteBinding= DataBindingUtil.setContentView(this,getLayoutRes());

        setUpToolbar();

        fetchData();


    }

    private void fetchData() {

        favoriteBinding.rvFavorite.setLayoutManager(new GridLayoutManager(this,2));
        favoriteBinding.rvFavorite.setItemAnimator(new DefaultItemAnimator());

        RestaurantViewModel restaurantViewModel= ViewModelProviders.of(this).get(RestaurantViewModel.class);
        restaurantViewModel.getAllRestaurants().observe(this, new Observer<List<RestaurantModel>>() {
            @Override
            public void onChanged(@Nullable List<RestaurantModel> restaurantModels) {
                if (restaurantModels.size()>0){
                    favoriteAdapter=new FavoriteAdapter(restaurantModels,FavoriteActivity.this);
                    favoriteBinding.rvFavorite.setAdapter(favoriteAdapter);

                }else{
                    favoriteBinding.rvFavorite.setVisibility(View.GONE);
                    favoriteBinding.tvNoFavoriteLbl.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setUpToolbar() {
        setSupportActionBar(favoriteBinding.toolbar.titleToolbar);
        favoriteBinding.toolbar.ivNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavoriteActivity.super.onBackPressed();
            }
        });
        favoriteBinding.toolbar.tvTitle.setText(getString(R.string.favorite));
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_favorite;
    }

    @Override
    public void onFavoriteClickListener(RestaurantModel restaurantModel) {
        Bundle bundle=new Bundle();
        bundle.putParcelable(RESTAURANT_MODEL,restaurantModel);
        startActivity(new Intent(this, FavoriteDetailsActivity.class)
        .putExtras(bundle));
    }
}
