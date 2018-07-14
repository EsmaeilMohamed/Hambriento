package com.thedevwolf.hambriento.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.thedevwolf.hambriento.Model.CuisinesModel;
import com.thedevwolf.hambriento.Network.ApiService;
import com.thedevwolf.hambriento.Network.RetrofitCall;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class CuisinesViewModel extends ViewModel {

    private MutableLiveData<CuisinesModel> cuisinesModelMutableLiveData;




    public MutableLiveData<CuisinesModel> getCuisinesModelMutableLiveData(int cityId, double lat,double lng) {

        if (cuisinesModelMutableLiveData==null){
            cuisinesModelMutableLiveData=new MutableLiveData<>();
            loadData(cityId,lat,lng);
        }

        return cuisinesModelMutableLiveData;
    }

    private void loadData(int cityId, double lat, double lng) {
        ApiService apiService= RetrofitCall.getClient().create(ApiService.class);



        apiService.getCuisineId(cityId,lat,lng)
                .enqueue(new Callback<CuisinesModel>() {
                    @Override
                    public void onResponse(Call<CuisinesModel> call, Response<CuisinesModel> response) {

                        cuisinesModelMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<CuisinesModel> call, Throwable t) {

                    }
                });

    }


}
