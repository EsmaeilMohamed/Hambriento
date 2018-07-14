package com.thedevwolf.hambriento.View.Fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.thedevwolf.hambriento.Model.RestaurantsModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.databinding.FragmentLocationBinding;

import timber.log.Timber;

import static com.thedevwolf.hambriento.View.Activity.RestaurantsActivity.RESTAURANT_DATA;
import static com.thedevwolf.hambriento.View.Activity.RestaurantsActivity.RESTAURANT_LOCATION;
import static com.thedevwolf.hambriento.View.Activity.RestaurantsActivity.RESTAURANT_RATING;

public class FragmentLocation extends Fragment implements OnMapReadyCallback {

    FragmentLocationBinding locationBinding;
    private GoogleMap gmap;

    //Rec Var
    RestaurantsModel.RestaurantsData.RestaurantData restaurantData;

    RestaurantsModel.RestaurantsData.RestaurantData.LocationBean locationBean;
    RestaurantsModel.RestaurantsData.RestaurantData.UserRatingBean userRatingBean;

    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        locationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_location, container, false);

        if (getArguments() != null) {
            restaurantData = getArguments().getParcelable(RESTAURANT_DATA);
            locationBean = getArguments().getParcelable(RESTAURANT_LOCATION);
            userRatingBean = getArguments().getParcelable(RESTAURANT_RATING);

        }


        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }
        locationBinding.mapView.onCreate(mapViewBundle);
        locationBinding.mapView.getMapAsync(this);

        Timber.e("Lat %s : Lng %s",locationBean.getLatitude(),locationBean.getLongitude());

        return locationBinding.getRoot();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        gmap = googleMap;
        gmap.setMinZoomPreference(10);
        gmap.setIndoorEnabled(true);

        UiSettings uiSettings = gmap.getUiSettings();
        uiSettings.setIndoorLevelPickerEnabled(true);//Indoor level picker is applicable for building with floor plans
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setMapToolbarEnabled(true); // Map tool bar contains actions which take you to directions screen, google map app etc.
        uiSettings.setCompassEnabled(true); //add compass to map
        uiSettings.setZoomControlsEnabled(false); // add zoom control


        //lat lng and marker settings
        LatLng ny = new LatLng(Double.parseDouble(locationBean.getLatitude()),
                Double.parseDouble(locationBean.getLongitude()));


        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(ny);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ny));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
        }

        locationBinding.mapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        locationBinding.mapView.onResume();


    }

    @Override
    public void onStart() {
        super.onStart();
        if (restaurantData.getLocation() != null) {
            locationBinding.mapView.onStart();
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        locationBinding.mapView.onStop();


    }

    @Override
    public void onPause() {
        locationBinding.mapView.onPause();


        super.onPause();
    }

    @Override
    public void onDestroy() {
        locationBinding.mapView.onDestroy();


        super.onDestroy();
    }

    @Override
    public void onLowMemory() {

        super.onLowMemory();
        locationBinding.mapView.onLowMemory();


    }

}
