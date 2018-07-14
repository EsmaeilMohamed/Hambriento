package com.thedevwolf.hambriento.Database;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RestaurantDao {
    @Query("SELECT * FROM restaurants")
    LiveData<List<RestaurantModel>> loadAllRestaurants();

    @Insert
    void insertRestaurant(RestaurantModel restaurantModel);

    @Delete
    void deleteRestaurants(RestaurantModel restaurantModel);

    @Query("SELECT * FROM restaurants WHERE id = :id")
    LiveData<RestaurantModel> loadRestaurantById(String id);

}
