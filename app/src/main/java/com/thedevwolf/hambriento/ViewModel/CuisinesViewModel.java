package com.thedevwolf.hambriento.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

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

    //Rec Var
    int cityid;
    double lat;
    double lng;


    public MutableLiveData<CuisinesModel> getCuisinesModelMutableLiveData(int cityId, double lat,double lng) {
        this.cityid=cityId;
        this.lat=lat;
        this.lng=lng;

        if (cuisinesModelMutableLiveData==null){
            cuisinesModelMutableLiveData=new MutableLiveData<>();
            loadData();
        }

        return cuisinesModelMutableLiveData;
    }

    private void loadData() {

        new CuisineTask().execute();

    }

    public  class CuisineTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            ApiService apiService= RetrofitCall.getClient().create(ApiService.class);



            apiService.getCuisineId(cityid,lat,lng)
                    .enqueue(new Callback<CuisinesModel>() {
                        @Override
                        public void onResponse(Call<CuisinesModel> call, Response<CuisinesModel> response) {

                            cuisinesModelMutableLiveData.setValue(response.body());
                        }

                        @Override
                        public void onFailure(Call<CuisinesModel> call, Throwable t) {
                            Timber.wtf(t);
                        }
                    });
            return null;
        }
    }


}
