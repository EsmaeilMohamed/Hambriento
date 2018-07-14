package com.thedevwolf.hambriento.View.Adapter.Recycler;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.thedevwolf.hambriento.Callback.FavoriteListener;
import com.thedevwolf.hambriento.Database.RestaurantModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.databinding.RecycleRestaurantBinding;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private List<RestaurantModel> restaurantModelList;
    private FavoriteListener favoriteListener;


    public FavoriteAdapter(List<RestaurantModel> restaurantModelList, FavoriteListener favoriteListener) {
        this.restaurantModelList = restaurantModelList;
        this.favoriteListener = favoriteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_restaurant, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final RestaurantModel restaurantModel=restaurantModelList.get(position);
        Picasso.get().load(String.valueOf(!TextUtils.isEmpty(restaurantModel.getImage())
                ? restaurantModel.image: R.drawable.restaurant))
                .placeholder(R.drawable.restaurant)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .resize(2048, 1600)
                .onlyScaleDown()
                .into(holder.restaurantBinding.ivRestaurantImage, new Callback() {
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
                                .into(holder.restaurantBinding.ivRestaurantImage);
                    }
                });


        holder.restaurantBinding.tvRestaurantName.setText(restaurantModel.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favoriteListener.onFavoriteClickListener(restaurantModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return restaurantModelList.size();
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
