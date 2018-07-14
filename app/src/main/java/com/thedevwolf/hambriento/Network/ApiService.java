package com.thedevwolf.hambriento.Network;

import com.thedevwolf.hambriento.Model.CuisinesModel;
import com.thedevwolf.hambriento.Model.GeocodeModel;

import com.thedevwolf.hambriento.Model.RestaurantsModel;

import io.reactivex.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {


    @Headers("user-key: 5da255e481f39722e4c825938d2058ba")
    @GET("api/v2.1/geocode")
    Observable<GeocodeModel> getGeoCodeCityId(@Query("lat") double lat,
                                              @Query("lon") double lon);

    @Headers("user-key: 5da255e481f39722e4c825938d2058ba")
    @GET("api/v2.1/cuisines")
    Call<CuisinesModel> getCuisineId(@Query("city_id") int cityId, @Query("lat") double lat,
                                     @Query("lon") double lon);


    @Headers("user-key: 5da255e481f39722e4c825938d2058ba")
    @GET("api/v2.1/search")
    Call<RestaurantsModel> getRestaurants(@Query("lat") double lat,
                                          @Query("lon") double lon,
                                          @Query("cuisines") int cuisine);



}
