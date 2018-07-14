package com.thedevwolf.hambriento.View.Adapter.Recycler;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.thedevwolf.hambriento.Callback.RestaurantListener;
import com.thedevwolf.hambriento.Model.RestaurantsModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.databinding.RecycleRestaurantBinding;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    private RestaurantsModel restaurantsModel;
    private RestaurantListener restaurantListener;

    public RestaurantAdapter(RestaurantsModel restaurantsModel, RestaurantListener restaurantListener) {
        this.restaurantsModel = restaurantsModel;
        this.restaurantListener = restaurantListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_restaurant, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RestaurantsModel.RestaurantsData.RestaurantData restaurantData = restaurantsModel.getRestaurants().get(position).getRestaurant();

        Picasso.get().load(String.valueOf(!TextUtils.isEmpty(restaurantData.getFeatured_image())
                ? restaurantData.getFeatured_image() : R.drawable.restaurant))
                .placeholder(R.drawable.restaurant)
                .resize(2048, 1600)
                .onlyScaleDown()
                .into(holder.restaurantBinding.ivRestaurantImage);


        holder.restaurantBinding.tvRestaurantName.setText(restaurantData.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restaurantListener.OnRestaurantClickListener(restaurantData);
            }
        });

    }


    @Override
    public int getItemCount() {
        return restaurantsModel.getRestaurants().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecycleRestaurantBinding restaurantBinding;

        public ViewHolder(View itemView) {
            super(itemView);
            restaurantBinding = DataBindingUtil.bind(itemView);
            assert restaurantBinding != null;
            restaurantBinding.notifyChange();

        }
    }
}
