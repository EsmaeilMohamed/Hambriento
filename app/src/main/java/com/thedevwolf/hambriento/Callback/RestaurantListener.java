package com.thedevwolf.hambriento.Callback;

import com.thedevwolf.hambriento.Model.RestaurantsModel;

public interface RestaurantListener {
    void OnRestaurantClickListener(RestaurantsModel.RestaurantsData.RestaurantData restaurantData);
}
