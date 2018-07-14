package com.thedevwolf.hambriento.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.thedevwolf.hambriento.Database.AppDatabase;
import com.thedevwolf.hambriento.Database.RestaurantModel;

import java.util.List;

public class RestaurantViewModel extends AndroidViewModel {


    private AppDatabase database;

    public RestaurantViewModel(@NonNull Application application) {
        super(application);
        database=AppDatabase.getInstance(application);
    }


    public LiveData<List<RestaurantModel>> getAllRestaurants(){
        return database.restaurantDao().loadAllRestaurants();
    }

    public LiveData<RestaurantModel> getRestaurantById(String id){
        return database.restaurantDao().loadRestaurantById(id);
    }
}
