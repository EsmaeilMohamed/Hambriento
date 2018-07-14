package com.thedevwolf.hambriento.View.Widget;

import android.appwidget.AppWidgetManager;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.RemoteViews;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.thedevwolf.hambriento.Base.BaseActivity;
import com.thedevwolf.hambriento.Callback.FavoriteListener;
import com.thedevwolf.hambriento.Database.RestaurantModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.Utils.AppExecutors;
import com.thedevwolf.hambriento.View.Adapter.Recycler.FavoriteAdapter;
import com.thedevwolf.hambriento.ViewModel.RestaurantViewModel;
import com.thedevwolf.hambriento.databinding.ActivityWidgetConfigureBinding;

import java.io.IOException;
import java.util.List;

public class WidgetConfigureActivity extends BaseActivity implements FavoriteListener {


    ActivityWidgetConfigureBinding widgetConfigureBinding;

    FavoriteAdapter favoriteAdapter;

    //Rec Var
    int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
    private AppWidgetManager widgetManager;
    private RemoteViews views;

    @Override
    protected void init(Bundle savedInstanceState) {
        widgetConfigureBinding= DataBindingUtil.setContentView(this,getLayoutRes());

        setUpToolbarConfig();

        fetchData();


        // These steps are seen in the previous examples
        widgetManager = AppWidgetManager.getInstance(this);
        views = new RemoteViews(this.getPackageName(), R.layout.restaurant_widget);
        // Find the widget id from the intent.
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
        }



    }

    private void fetchData() {

        widgetConfigureBinding.rvFavRestaurant.setLayoutManager(new GridLayoutManager(this,2));
        widgetConfigureBinding.rvFavRestaurant.setItemAnimator(new DefaultItemAnimator());

        RestaurantViewModel restaurantViewModel= ViewModelProviders.of(this).get(RestaurantViewModel.class);
        restaurantViewModel.getAllRestaurants().observe(this, new Observer<List<RestaurantModel>>() {
            @Override
            public void onChanged(@Nullable List<RestaurantModel> restaurantModels) {
                if (restaurantModels.size()>0){
                    favoriteAdapter=new FavoriteAdapter(restaurantModels,WidgetConfigureActivity.this);
                    widgetConfigureBinding.rvFavRestaurant.setAdapter(favoriteAdapter);

                }else{
                    widgetConfigureBinding.tvNoFavorite.setVisibility(View.VISIBLE);
                    widgetConfigureBinding.rvFavRestaurant.setVisibility(View.GONE);
                }
            }
        });


    }

    private void setUpToolbarConfig() {
        setSupportActionBar(widgetConfigureBinding.toolbar.titleToolbar);
        widgetConfigureBinding.toolbar.tvTitle.setText(getString(R.string.favorite));
        widgetConfigureBinding.toolbar.ivNavigation.setVisibility(View.GONE);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_widget_configure;
    }

    @Override
    public void onFavoriteClickListener(final RestaurantModel restaurantModel) {


        views.setImageViewResource(R.id.iv_restaurant,R.drawable.restaurant);
        views.setTextViewText(R.id.tv_res_name,restaurantModel.name);
        views.setTextViewText(R.id.textView5,restaurantModel.city);
        views.setTextViewText(R.id.tv_res_rating,restaurantModel.rating_text);

        widgetManager.updateAppWidget(mAppWidgetId, views);
        Intent resultValue = new Intent();
        // Set the results as expected from a 'configure activity'.
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
        setResult(RESULT_OK, resultValue);
        finish();

    }
}
