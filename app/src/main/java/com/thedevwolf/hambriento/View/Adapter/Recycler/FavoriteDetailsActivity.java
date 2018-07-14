package com.thedevwolf.hambriento.View.Adapter.Recycler;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.thedevwolf.hambriento.Base.BaseActivity;
import com.thedevwolf.hambriento.Database.RestaurantModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.View.Activity.FavoriteActivity;
import com.thedevwolf.hambriento.databinding.ActivityFavoriteDetailsBinding;
import com.thefinestartist.finestwebview.FinestWebView;

public class FavoriteDetailsActivity extends BaseActivity {


    ActivityFavoriteDetailsBinding favoriteDetailsBinding;

    RestaurantModel restaurantModel;

    @Override
    protected void init(Bundle savedInstanceState) {

        favoriteDetailsBinding= DataBindingUtil.setContentView(this,getLayoutRes());

        if (getIntent().getExtras()!=null){
            restaurantModel=getIntent().getExtras().getParcelable(FavoriteActivity.RESTAURANT_MODEL);
        }


        setUpToolbarConfig();

        fetchData();

    }

    private void setUpToolbarConfig() {
        setSupportActionBar(favoriteDetailsBinding.toolbar.titleToolbar);
        favoriteDetailsBinding.toolbar.tvTitle.setText(restaurantModel.name);
    }

    @SuppressLint("SetTextI18n")
    private void fetchData() {
        //get restaurant image
        Picasso.get().load(String.valueOf(!TextUtils.isEmpty(restaurantModel.getImage())
                ? restaurantModel.image: R.drawable.restaurant))
                .placeholder(R.drawable.restaurant)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .resize(2048, 1600)
                .onlyScaleDown()
                .into(favoriteDetailsBinding.imageView3, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        Picasso.get().load(String.valueOf(!TextUtils.isEmpty(restaurantModel.getImage())
                                ? restaurantModel.image: R.drawable.restaurant))
                                .placeholder(R.drawable.restaurant)
                                .resize(2048, 1600)
                                .onlyScaleDown()
                                .into(favoriteDetailsBinding.imageView3);
                    }
                });

        if (restaurantModel.getAggregate_rating()!=null){
            favoriteDetailsBinding.rbRestaurant.setRating(Float.parseFloat(String.valueOf(restaurantModel.getAggregate_rating())));

        }else{
            favoriteDetailsBinding.rbRestaurant.setRating((float) 0);
        }



        favoriteDetailsBinding.tvAddress.setText(restaurantModel.getAddress());
        favoriteDetailsBinding.tvDesc.setText(restaurantModel.getCity());

        favoriteDetailsBinding.tvRatingTxt.setText(restaurantModel.getRating_text());
        favoriteDetailsBinding.tvVoteNumber.setText(restaurantModel.getVotes()+" "+getString(R.string.votes));


        if (restaurantModel.getOnline_delivery()==0){
            favoriteDetailsBinding.tvOnlineDelivery.setTextColor(Color.RED);
            favoriteDetailsBinding.tvOnlineDelivery.setText(getString(R.string.not_available));
        }


        favoriteDetailsBinding.ivRestaurantMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FinestWebView.Builder(getApplicationContext()).show(restaurantModel.getMenu_url());

            }
        });



    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_favorite_details;
    }
}
