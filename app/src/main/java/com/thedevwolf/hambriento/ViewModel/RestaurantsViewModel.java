package com.thedevwolf.hambriento.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.thedevwolf.hambriento.Model.RestaurantsModel;
import com.thedevwolf.hambriento.Network.ApiService;
import com.thedevwolf.hambriento.Network.RetrofitCall;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantsViewModel extends ViewModel{
   private MutableLiveData<RestaurantsModel> restaurantsModelMutableLiveData;

    public MutableLiveData<RestaurantsModel> getRestaurantsModelMutableLiveData(double lat,double lng,int cuisineId) {

        if (restaurantsModelMutableLiveData==null){
            restaurantsModelMutableLiveData=new MutableLiveData<>();
            loadData(lat,lng,cuisineId);
        }

        return restaurantsModelMutableLiveData;
    }

    private void loadData(double lat, double lng, int cuisineId) {
        ApiService apiService= RetrofitCall.getClient().create(ApiService.class);
        apiService.getRestaurants(lat,lng, cuisineId)
                .enqueue(new Callback<RestaurantsModel>() {
                    @Override
                    public void onResponse(Call<RestaurantsModel> call, Response<RestaurantsModel> response) {
                        restaurantsModelMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<RestaurantsModel> call, Throwable t) {

                    }
                });

    }
}
