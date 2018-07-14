package com.thedevwolf.hambriento.View.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.thedevwolf.hambriento.Base.BaseActivity;
import com.thedevwolf.hambriento.Database.AppDatabase;
import com.thedevwolf.hambriento.Database.RestaurantModel;
import com.thedevwolf.hambriento.Model.RestaurantsModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.Utils.AppExecutors;
import com.thedevwolf.hambriento.View.Adapter.ViewPager.ViewPagerAdapter;
import com.thedevwolf.hambriento.View.Fragment.FragmentInfo;
import com.thedevwolf.hambriento.View.Fragment.FragmentLocation;
import com.thedevwolf.hambriento.ViewModel.RestaurantViewModel;
import com.thedevwolf.hambriento.databinding.ActivityRestaurantDetailsBinding;

import es.dmoral.toasty.Toasty;

import static com.thedevwolf.hambriento.View.Activity.RestaurantsActivity.RESTAURANT_DATA;
import static com.thedevwolf.hambriento.View.Activity.RestaurantsActivity.RESTAURANT_LOCATION;
import static com.thedevwolf.hambriento.View.Activity.RestaurantsActivity.RESTAURANT_RATING;

public class RestaurantDetailsActivity extends BaseActivity {

    ActivityRestaurantDetailsBinding restaurantDetailsBinding;

    //fragments
    FragmentInfo fragmentInfo;
    FragmentLocation fragmentLocation;

    //Rec Var
    RestaurantsModel.RestaurantsData.RestaurantData restaurantData;
    RestaurantsModel.RestaurantsData.RestaurantData.LocationBean locationBean;
    RestaurantsModel.RestaurantsData.RestaurantData.UserRatingBean userRatingBean;

    boolean isFavorite=false;

    @Override
    protected void init(Bundle savedInstanceState) {
        restaurantDetailsBinding= DataBindingUtil.setContentView(this,getLayoutRes());
        if (getIntent().getExtras()!=null){
            restaurantData=getIntent().getExtras().getParcelable(RESTAURANT_DATA);
            locationBean=getIntent().getExtras().getParcelable(RESTAURANT_LOCATION);
            userRatingBean=getIntent().getExtras().getParcelable(RESTAURANT_RATING);
        }


        setUpToolbarConfig();

        fetchData();


    }

    private void fetchData() {
        
        checkFavorite();
        
        
        Picasso.get().load(String.valueOf(!TextUtils.isEmpty(restaurantData.getFeatured_image())
                ? restaurantData.getFeatured_image() : R.drawable.restaurant))
                .placeholder(R.drawable.restaurant)
                .resize(2048, 1600)
                .onlyScaleDown()
                .into(restaurantDetailsBinding.htabHeader);


        setUpViewPager();

        restaurantDetailsBinding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==1){
                    restaurantDetailsBinding.floatingActionButton.setVisibility(View.GONE);
                }else{
                    restaurantDetailsBinding.floatingActionButton.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        restaurantDetailsBinding.tabs.setupWithViewPager(restaurantDetailsBinding.viewpager);


        AddAndRemoveFavorite();



    }

    private void AddAndRemoveFavorite() {
        final RestaurantModel restaurantModel=new RestaurantModel();
        restaurantModel.setId(restaurantData.getId());
        restaurantModel.setAddress(locationBean.getAddress());
        restaurantModel.setCity(locationBean.getCity());
        restaurantModel.setVotes(userRatingBean.getVotes());
        restaurantModel.setAggregate_rating(userRatingBean.getAggregate_rating());
        restaurantModel.setRating_text(userRatingBean.getRating_text());
        restaurantModel.setName(restaurantData.getName());
        restaurantModel.setMenu_url(restaurantData.getMenu_url());
        restaurantModel.setImage(restaurantData.getFeatured_image());
        restaurantModel.setOnline_delivery(restaurantData.getHas_online_delivery());


        restaurantDetailsBinding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFavorite){
                    AppExecutors.getInstance().diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            AppDatabase.getInstance(RestaurantDetailsActivity.this)
                                    .restaurantDao().deleteRestaurants(restaurantModel);

                        }
                    });


                    Toasty.warning(getApplicationContext(),getString(R.string.restaurant_remove_msg),Toast.LENGTH_SHORT,true).show();
                }else{
                    AppExecutors.getInstance().diskIO().execute(new Runnable() {
                        @Override
                        public void run() {

                            AppDatabase.getInstance(RestaurantDetailsActivity.this)
                                    .restaurantDao().insertRestaurant(restaurantModel);

                        }
                    });

                    Toasty.success(getApplicationContext(),getString(R.string.restaurant_add_msg),Toast.LENGTH_SHORT,true).show();

                }
            }
        });

    }

    private void checkFavorite() {
        RestaurantViewModel restaurantViewModel= ViewModelProviders.of(this).get(RestaurantViewModel.class);
        restaurantViewModel.getRestaurantById(restaurantData.getId())
                .observe(this, new Observer<RestaurantModel>() {
                    @Override
                    public void onChanged(@Nullable RestaurantModel restaurantModel) {
                        if (restaurantModel!=null){
                            isFavorite=true;
                            restaurantDetailsBinding.floatingActionButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_active_24dp));
                        }else{
                            isFavorite=false;
                            restaurantDetailsBinding.floatingActionButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_24dp));

                        }
                    }
                });


    }

    private void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());

        //prepare bundle
        Bundle bundle=new Bundle();
        bundle.putParcelable(RESTAURANT_DATA,restaurantData);
        bundle.putParcelable(RESTAURANT_LOCATION,locationBean);
        bundle.putParcelable(RESTAURANT_RATING,userRatingBean);

        //add bundle to fragment info
         fragmentInfo=new FragmentInfo();
        fragmentInfo.setArguments(bundle);

        //add bundle to fragment location
         fragmentLocation=new FragmentLocation();
        fragmentLocation.setArguments(bundle);

        viewPagerAdapter.addFrag(fragmentInfo,"Info");
        viewPagerAdapter.addFrag(fragmentLocation,"Location");

        restaurantDetailsBinding.viewpager.setAdapter(viewPagerAdapter);

        restaurantDetailsBinding.viewpager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setAlpha(normalizedposition);
            }
        });

    }

    private void setUpToolbarConfig() {
        setSupportActionBar(restaurantDetailsBinding.toolbar.titleToolbar);
        restaurantDetailsBinding.toolbar.tvTitle.setText(restaurantData.getName());
        restaurantDetailsBinding.toolbar.ivNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestaurantDetailsActivity.super.onBackPressed();
            }
        });

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_restaurant_details;
    }
}
