package com.thedevwolf.hambriento.View.Fragment;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.thedevwolf.hambriento.Model.RestaurantsModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.Utils.Utils;
import com.thedevwolf.hambriento.databinding.FragmentInfoBinding;
import com.thefinestartist.finestwebview.FinestWebView;

import timber.log.Timber;

import static com.thedevwolf.hambriento.View.Activity.RestaurantsActivity.RESTAURANT_DATA;
import static com.thedevwolf.hambriento.View.Activity.RestaurantsActivity.RESTAURANT_LOCATION;
import static com.thedevwolf.hambriento.View.Activity.RestaurantsActivity.RESTAURANT_RATING;

public class FragmentInfo extends Fragment {

    FragmentInfoBinding infoBinding;

    //Rec Var
    RestaurantsModel.RestaurantsData.RestaurantData restaurantData;
    RestaurantsModel.RestaurantsData.RestaurantData.LocationBean locationBean;
    RestaurantsModel.RestaurantsData.RestaurantData.UserRatingBean userRatingBean;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        infoBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_info,container,false);

        if (getArguments()!=null){
            restaurantData=getArguments().getParcelable(RESTAURANT_DATA);
            locationBean=getArguments().getParcelable(RESTAURANT_LOCATION);
            userRatingBean=getArguments().getParcelable(RESTAURANT_RATING);
        }


        fetchData();

        return infoBinding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    private void fetchData() {
        if (userRatingBean.getAggregate_rating()!=null){
            infoBinding.rbRestaurant.setRating(Float.parseFloat(String.valueOf(userRatingBean.getAggregate_rating())));

        }else{
            infoBinding.rbRestaurant.setRating((float) 0);
        }



        infoBinding.tvAddress.setText(locationBean.getAddress());
        infoBinding.tvDesc.setText(locationBean.getCity());

        infoBinding.tvRatingTxt.setText(userRatingBean.getRating_text());
        infoBinding.tvVoteNumber.setText(userRatingBean.getVotes()+" "+getString(R.string.votes));


        if (restaurantData.getIs_delivering_now()==0){
            infoBinding.tvOnlineDelivery.setTextColor(Color.RED);
            infoBinding.tvOnlineDelivery.setText(getString(R.string.not_available));
        }


        infoBinding.ivRestaurantMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FinestWebView.Builder(getActivity()).show(restaurantData.getMenu_url());

            }
        });


    }


}
