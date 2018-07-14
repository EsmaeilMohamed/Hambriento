package com.thedevwolf.hambriento.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.thedevwolf.hambriento.Model.RestaurantsModel;
import com.thedevwolf.hambriento.Network.ApiService;
import com.thedevwolf.hambriento.Network.RetrofitCall;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


public class RestaurantsViewModel extends ViewModel{
   private MutableLiveData<RestaurantsModel> restaurantsModelMutableLiveData;

   //Rec Var
    double lat;
    double lng;
    int cuisineId;

    public MutableLiveData<RestaurantsModel> getRestaurantsModelMutableLiveData(double lat,double lng,int cuisineId) {
        this.lat=lat;
        this.lng=lng;
        this.cuisineId=cuisineId;

        if (restaurantsModelMutableLiveData==null){
            restaurantsModelMutableLiveData=new MutableLiveData<>();
            loadData();
        }

        return restaurantsModelMutableLiveData;
    }

    private void loadData() {
       new restauantTask().execute();
    }

    public class restauantTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            ApiService apiService= RetrofitCall.getClient().create(ApiService.class);
            apiService.getRestaurants(lat,lng, cuisineId)
                    .enqueue(new Callback<RestaurantsModel>() {
                        @Override
                        public void onResponse(Call<RestaurantsModel> call, Response<RestaurantsModel> response) {
                            restaurantsModelMutableLiveData.setValue(response.body());
                        }

                        @Override
                        public void onFailure(Call<RestaurantsModel> call, Throwable t) {
                            Timber.wtf(t);
                        }
                    });
            return null;
        }
    }
}
